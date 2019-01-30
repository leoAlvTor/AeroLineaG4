package controlador;

import modelo.ModeloCliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SentenciasAgente {

    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;

    private ResultSet resultado = null;
    private PreparedStatement psentencia = null;

    private CallableStatement cStmt = null;
    private Connection conn = null;

    private void insertarCabeceraDetalle(ConexionAgente con, String fecha, double costo, int cliente, int empleado,
                                         String asiento, String tipoPasajero, int codigoVuelos){
        con = new ConexionAgente();
        try {
            cStmt = con.getConnection().prepareCall("{call p_insertar_cabecera(?,?,?,?,?,?,?)}");
            cStmt.setString(1, fecha);
            cStmt.setDouble(2, costo);
            cStmt.setInt(3, cliente);
            cStmt.setInt(4, empleado);
            cStmt.setString(5, asiento);
            cStmt.setString(6, tipoPasajero);
            cStmt.setInt(7, codigoVuelos);
            cStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        con.Desconectar();
    }

    public List<String> asientosDisponibles(ConexionAgente con, int avi_id){
        List<String> asientos = new ArrayList<>();
        try{
            String sentencia = "Select * from age_asientos " +
                    "where age_asientos.age_avion_avi_id = ? and asi_disponible = 'D'";
            psentencia = con.getConnection().prepareStatement(sentencia);
            psentencia.setInt(1,avi_id);
            System.out.println("Id del avion: "+ avi_id);
            resultado = psentencia.executeQuery();
            while(resultado.next()){
                String leo = resultado.getString("asi_loc");
                System.out.println(leo);
                asientos.add(leo);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return asientos;
    }

    public void borrarCliente(ConexionAgente con, int id){
        try{
            String sentencia = "delete from age_clientes where cli_id = ?";
            psentencia = con.getConnection().prepareStatement(sentencia);
            psentencia.setInt(1, id);
            psentencia.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void actualizarCliente(ConexionAgente con, int id, String nombre, String cedula, String direccion,
                                  String fecha){
        try{
            String sentencia = "update age_clientes set cli_nom_completo = ?, cli_cedula = ?, cli_direccion = ?," +
                    " fecha_nac = ? where cli_id = ?";
            psentencia = con.getConnection().prepareStatement(sentencia);
            psentencia.setString(1, nombre);
            psentencia.setString(2, cedula);
            psentencia.setString(3, direccion);
            psentencia.setString(4, fecha);
            psentencia.setInt(5, id);

            psentencia.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void crearCliente(ConexionAgente con, String nombre, String cedula, String direccion, String fecha){
        try{
            String sentencia = "insert into age_clientes values(age_clientes_seq.nextval,?,?,?,?)";

            psentencia = con.getConnection().prepareStatement(sentencia);
            psentencia.setString(1, nombre);
            psentencia.setString(2, cedula);
            psentencia.setString(3, direccion);
            psentencia.setString(4, fecha);

            psentencia.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public List<ModeloCliente> clienteList(ConexionAgente con){
        List<ModeloCliente> clientes = new ArrayList<>();
        ModeloCliente modeloCliente = new ModeloCliente();

        try {
            String sentencia = "select * from age_clientes order by 1";

            psentencia = con.getConnection().prepareStatement(sentencia);
            resultado = psentencia.executeQuery();

            while(resultado.next()){
                modeloCliente = new ModeloCliente();
                modeloCliente.setId(resultado.getString("cli_id"));
                modeloCliente.setNombre(resultado.getString("cli_nom_completo"));
                modeloCliente.setDireccion(resultado.getString("cli_direccion"));
                modeloCliente.setCedula(resultado.getString("cli_cedula"));
                modeloCliente.setFecha_nac(resultado.getString("fecha_nac"));

                clientes.add(modeloCliente);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return clientes;
    }

}
