package controlador;

import modelo.ModeloEmpleado;
import modelo.ModeloPreFactura;

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

    private ModeloEmpleado modeloEmpleado;

    public List<ModeloEmpleado> obtenerEmpleados(ConexionAdministrador con){
        int id;
        String cedula, nombre, apellido, rol, password, respuesta, pregunta;
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
