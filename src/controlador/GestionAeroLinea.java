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

    public List<ModeloPreFactura> obtenerTodosVuelos() {
        List<ModeloPreFactura> preFacturaList = new ArrayList<>();
         conexionAgente = new ConexionAgente();

        conexionAgente.Conectar();

        if (conexionAgente.getConnection() != null)
            System.out.println("Se ha conectado correctamente");
        else
            System.out.println("Se ha interrumpido la conexion");

        SentenciasAgente sentenciasAgente = new SentenciasAgente();
        preFacturaList = sentenciasAgente.obtenerTodosVuelos(conexionAgente);
        conexionAgente.Desconectar();
        return preFacturaList;
    }


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

}
