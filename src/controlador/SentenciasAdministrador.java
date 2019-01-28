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

    public void actualizarVuelos(ConexionAdministrador con, String id, String capacidad, String hSalida,
                                 String hLlegada, String tipo, String costo, String paeroSalida, String paeroLlegada,
                                 String avion, String fSalida, String fLlegada){
        try{
            String obtenerIds = "Select * from age_areopuertos where are_direccion = ?";
            psentencia = con.getConnection().prepareStatement(obtenerIds);
            psentencia.setString(1, paeroSalida);

            resultado = psentencia.executeQuery();

            String aeroSalidaId = "";
            while(resultado.next())
                aeroSalidaId = resultado.getString("are_id");

            System.out.println("Id del aeropuerto de salida");
            psentencia = null;
            resultado = null;

            psentencia = con.getConnection().prepareStatement(obtenerIds);
            psentencia.setString(1, paeroLlegada);

            resultado = psentencia.executeQuery();

            String aeroLlegadaId = "";
            while(resultado.next())
                aeroLlegadaId = resultado.getString("are_id");
            System.out.println("Id del aeropuerto de llegada");

            psentencia = null;
            
            String consultaUpdate = "update age_vuelos set vue_id = ?, vue_capacidad = ?, vue_hora_salida = ?," +
                    " vue_hora_llegada = ?, vue_tip_vuelo = ?, vue_costo = ?, age_areopuertos_are_id = ?," +
                    " age_areopuertos_are_id1 = ?, age_avion_avi_id = ?, fecha_salida = ?, fecha_llegada = ?" +
                    " where vue_id = ?";

            System.out.println("Antes de mandar la consulta");
            psentencia = con.getConnection().prepareStatement(consultaUpdate);
            System.out.println("Despues de mandar la consulta");
            psentencia.setInt(1, Integer.parseInt(id));
            psentencia.setInt(2, Integer.parseInt(capacidad));
            psentencia.setString(3, hSalida);
            psentencia.setString(4, hLlegada);
            psentencia.setString(5, tipo);
            psentencia.setString(6, costo);
            psentencia.setInt(7, Integer.parseInt(aeroSalidaId));
            psentencia.setInt(8, Integer.parseInt(aeroLlegadaId));
            psentencia.setInt(9, Integer.parseInt(avion));
            psentencia.setString(10, fSalida);
            psentencia.setString(11, fLlegada);
            psentencia.setInt(12, Integer.parseInt(id));
            System.out.println("Antes de la sentencia");
            psentencia.executeUpdate();

            System.out.println("Al final de todo las cosas anteriores");

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public List<ModeloVuelos> listarVuelosPorDestino(ConexionAdministrador con, String destino){
        List<ModeloVuelos> modeloVuelosList = new ArrayList<>();
        ModeloVuelos modeloVuelos = new ModeloVuelos();

        try{
            String sentenciaDestino = "select * from age_areopuertos where are_direccion = ?";

            psentencia = con.getConnection().prepareStatement(sentenciaDestino);
            psentencia.setString(1, destino);

            resultado = psentencia.executeQuery();


            String valor = "";
            while(resultado.next())
                valor = resultado.getString("are_id");

            sentenciaDestino = "select * from age_vuelos where  age_areopuertos_are_id1 = ?";
            psentencia = null;
            psentencia = con.getConnection().prepareStatement(sentenciaDestino);
            psentencia.setString(1, valor);

            resultSet = psentencia.executeQuery();

            while(resultSet.next()){
                modeloVuelos = new ModeloVuelos();

                modeloVuelos.setId(resultSet.getString("vue_id"));
                modeloVuelos.setCapacidad(resultSet.getString("vue_capacidad"));
                modeloVuelos.setSalida(resultSet.getString("vue_hora_salida"));
                modeloVuelos.setLlegada(resultSet.getString("vue_hora_llegada"));
                modeloVuelos.setTipo(resultSet.getString("vue_tip_vuelo"));
                modeloVuelos.setCosto(resultSet.getString("vue_costo"));
                modeloVuelos.setAeropuertoSalida(resultSet.getString("age_areopuertos_are_id"));
                modeloVuelos.setAeropuertoLlegada(resultSet.getString("age_areopuertos_are_id1"));
                modeloVuelos.setAvion(resultSet.getString("age_avion_avi_id"));
                modeloVuelos.setFechaSalida(resultSet.getString("fecha_salida"));
                modeloVuelos.setFechaLLegada(resultSet.getString("fecha_llegada"));

                modeloVuelosList.add(modeloVuelos);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return modeloVuelosList;
    }

    public void eliminarVuelo(ConexionAdministrador con,int vuelo){
        try{
            String sentencia = "Delete from age_vuelos where vue_id = ?";
            psentencia = con.getConnection().prepareStatement(sentencia);
            psentencia.setInt(1, vuelo);
            psentencia.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
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
