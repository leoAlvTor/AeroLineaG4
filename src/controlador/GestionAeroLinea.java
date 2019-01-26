package controlador;

import modelo.ModeloEmpleado;
import modelo.ModeloPreFactura;

import java.util.ArrayList;
import java.util.List;

public class GestionAeroLinea {
    public GestionAeroLinea(){}

    private ConexionAgente conexionAgente;
    private ConexionAdministrador conexionAdministrador;

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

    public List<ModeloEmpleado> obtenerEmpleados(){
        List<ModeloEmpleado> modeloEmpleadoList = new ArrayList<>();
        conexionAgente = new ConexionAgente();
        conexionAgente.

    }

}
