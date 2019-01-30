package controlador;
/**
 * En esta clase se programaron todas las sentencias que pertenecen al rol de agente de ventas entre ellos se encuentran
 * los actualizaciones creaciones de registros ediciones y eliminaciones
 */
import modelo.ModeloCliente;
import modelo.ModeloVuelos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SentenciasAgente {

    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;

    private ResultSet resultado = null;
    private PreparedStatement psentencia = null;

    /**
     * Este metodo borrara a un cliente en especifico mediante su id, recibiendo como parametro la conexion de agente y
     * el id perteneciente al cliente a eliminar
     * @param con
     * @param id
     */
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

    /**
     * Este metodo realiza una acualizacion de un cliente en especifico el metodo recibira todos los parametros que
     * pertenece a el cliente exepto el id ya que este es necesario para identificar al uusario de manera unica, ademas
     * se pasara como parametro el id junto con la conexion de agente.
     * @param con
     * @param id
     * @param nombre
     * @param cedula
     * @param direccion
     * @param fecha
     */
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

    /**
     *Este metodo crea a un nuevo cliente recibiendo como parametro la conexion agente con sus respectivos atributos
     * que se describen a continuacion
     * @param con
     * @param nombre
     * @param cedula
     * @param direccion
     * @param fecha
     */
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

    /**
     * Este metodo retorna los de clientes en una lista de tipo modelo cliente, y recibe como parametro la conexion de
     * tipo agente
     * @param con
     * @return
     */
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
