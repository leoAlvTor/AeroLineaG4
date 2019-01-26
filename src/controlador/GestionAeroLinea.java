package controlador;

import modelo.ModeloEmpleado;
import modelo.ModeloPreFactura;

import java.util.ArrayList;
import java.util.List;

public class GestionAeroLinea {
    public GestionAeroLinea(){}

    private ConexionAgente conexionAgente;
    private ConexionAdministrador conexionAdministrador;

    private SentenciasAgente sentenciasAgente;
    private SentenciasAdministrador sentenciasAdministrador;

    /*
    |
    |
    |   ~~~~ Empieza todas las sentencias del Administrador del sistema
    |
    |
     */

    public List<ModeloEmpleado> obtenerEmpleados(){
        List<ModeloEmpleado> modeloEmpleadoList = new ArrayList<>();
        conexionAdministrador = new ConexionAdministrador();
        conexionAdministrador.Conectar();
        sentenciasAdministrador = new SentenciasAdministrador();

        if(conexionAdministrador.getConnection() != null) {
            System.out.println("Conexion administrador correcta...");
            modeloEmpleadoList = sentenciasAdministrador.obtenerEmpleados(conexionAdministrador);
        }else{
            System.out.println("La conexion no se ha realizado correctamente");
        }
        conexionAdministrador.Desconectar();


        return modeloEmpleadoList;
    }

    public List<String> recuperarPassword(String cedula, String pregunta, String respuesta){
        List<ModeloEmpleado> modeloEmpleadoList = new ArrayList<>();
        List<String> datos = new ArrayList<>();

        conexionAdministrador = new ConexionAdministrador();
        conexionAdministrador.Conectar();
        sentenciasAdministrador = new SentenciasAdministrador();

        String retCedula = "";
        String retPassword = "";

        if(conexionAdministrador.getConnection() != null){
            System.out.println("Conexion administrador correcta...");
            modeloEmpleadoList = sentenciasAdministrador.recuperarPass(conexionAdministrador);
        }else{
            System.out.println("La conexion no se ha realizado correctamente");
        }
        conexionAdministrador.Desconectar();

        System.out.println(cedula + "<<" + pregunta + "<<"+ respuesta+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        for (int i = 0; i < modeloEmpleadoList.size(); i++) {
            String password1 = modeloEmpleadoList.get(i).getPassword();
            String cedula1 = modeloEmpleadoList.get(i).getCedula();
            String pregunta1 = modeloEmpleadoList.get(i).getPregunta();
            String respuesta1 = modeloEmpleadoList.get(i).getRespuesta();

            if(cedula1.equals(cedula) && pregunta1.equals(pregunta) && respuesta1.equals(respuesta)) {
                retPassword = password1;
                retCedula = cedula1;
                break;
            }
        }

        datos.add(retCedula);
        datos.add(retPassword);

        return datos;
    }

}
