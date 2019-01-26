package controlador;

import modelo.ModeloEmpleado;
import modelo.ModeloVuelos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class SentenciasAdministrador {
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;

    private ResultSet resultado = null;
    private PreparedStatement psentencia = null;

    private int id;
    private String cedula, nombre, apellido, rol, password, respuesta, pregunta;

    private ModeloEmpleado modeloEmpleado;



    public List<ModeloVuelos> listarVuelosPorDestino(ConexionAdministrador con, String destino){
        List<ModeloVuelos> modeloVuelosList = new ArrayList<>();
        ModeloVuelos modeloVuelos = new ModeloVuelos();

        try{
            String sentencia = "select * from age_vuelos," +
                    "(select are_id" +
                    "from age_areopuertos" +
                    "where are_direccion = ?), leo" +
                    "where age_vuelos.age_areopuertos_are_id1 = leo.are_id";

            psentencia = con.getConnection().prepareStatement(sentencia);

            psentencia.setString(1, destino);

            resultado = psentencia.executeQuery();

            while(resultado.next()){
                modeloVuelos = new ModeloVuelos();

                modeloVuelos.setId(resultado.getString("vue_id"));
                modeloVuelos.setCapacidad(resultado.getString("vue_capacidad"));
                modeloVuelos.setSalida(resultado.getString("vue_hora_salida"));
                modeloVuelos.setLlegada(resultado.getString("vue_hora_llegada"));
                modeloVuelos.setTipo(resultado.getString("vue_tip_vuelo"));
                modeloVuelos.setCosto(resultado.getString("vue_costo"));
                modeloVuelos.setAeropuertoSalida(resultado.getString("age_areopuertos_are_id"));
                modeloVuelos.setAeropuertoLlegada(resultado.getString("age_areopuertos_are_id1"));
                modeloVuelos.setAvion(resultado.getString("age_avion_avi_id"));

                modeloVuelosList.add(modeloVuelos);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return modeloVuelosList;
    }


    public void crearUsuario(ConexionAdministrador con, String pCedula, String pNombre, String pApellido,
                             String pPassword, String pPregunta, String pRespuesta, String pRol){

        try{
            String sentencia = "Insert into age_empleados values"
                    + "(age_empleados_seq.nextval, ?,?,?,?,?,?,?)";

            psentencia = con.getConnection().prepareStatement(sentencia);

            psentencia.setString(1, pCedula);
            psentencia.setString(2, pNombre);
            psentencia.setString(3, pApellido);
            psentencia.setString(4, pRol);
            psentencia.setString(5, pPassword);
            psentencia.setString(6, pRespuesta);
            psentencia.setString(7, pPregunta);

            psentencia.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public List<String> listarDestinos(ConexionAdministrador con){
        List<String> datos = new ArrayList<>();

        try{
            psentencia = con.getConnection().prepareStatement("Select * from age_areopuertos");
            resultado = psentencia.executeQuery();

            while(resultado.next()){
                datos.add(resultado.getString("are_direccion"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return datos;
    }

    public List<ModeloEmpleado> recuperarPass(ConexionAdministrador con){
        List<ModeloEmpleado> modeloEmpleadoList = new ArrayList<>();

        try{
            psentencia = con.getConnection().prepareStatement("Select * from age_empleados");
            resultado = psentencia.executeQuery();

            while(resultado.next()){
                modeloEmpleado = new ModeloEmpleado();

                cedula = resultado.getString("emp_cedula");
                pregunta = resultado.getString("emp_pregunta");
                respuesta = resultado.getString("emp_resp_seguridad");
                password = resultado.getString("emp_contrasena");

                modeloEmpleado.setCedula(cedula);
                modeloEmpleado.setPregunta(pregunta);
                modeloEmpleado.setRespuesta(respuesta);
                modeloEmpleado.setPassword(password);

                modeloEmpleadoList.add(modeloEmpleado);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return modeloEmpleadoList;
    }

    public List<ModeloEmpleado> obtenerEmpleados(ConexionAdministrador con){

        List<ModeloEmpleado> modeloEmpleadoList = new ArrayList<>();

        try{
            psentencia = con.getConnection().prepareStatement("Select * from age_empleados");
            resultado = psentencia.executeQuery();

            while(resultado.next()){
                modeloEmpleado = new ModeloEmpleado();
                id = Integer.parseInt(resultado.getString("emp_id"));
                cedula = resultado.getString("emp_cedula");
                nombre = resultado.getString("emp_nombre");
                apellido = resultado.getString("emp_apellido");
                rol = resultado.getString("emp_rol");
                password = resultado.getString("emp_contrasena");
                respuesta = resultado.getString("emp_resp_seguridad");
                pregunta = resultado.getString("emp_pregunta");

                modeloEmpleado.setCodigo(id);
                modeloEmpleado.setCedula(cedula);
                modeloEmpleado.setNombre(nombre);
                modeloEmpleado.setApellido(apellido);
                modeloEmpleado.setRol(rol);
                modeloEmpleado.setPassword(password);
                modeloEmpleado.setRespuesta(respuesta);
                modeloEmpleado.setPregunta(pregunta);

                modeloEmpleadoList.add(modeloEmpleado);

            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return modeloEmpleadoList;
    }

}
