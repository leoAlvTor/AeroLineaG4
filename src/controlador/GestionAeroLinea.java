package controlador;

import modelo.ModeloPreFactura;

import java.util.ArrayList;
import java.util.List;

public class GestionAeroLinea {
    public GestionAeroLinea(){}


    public List<ModeloPreFactura> obtenerTodosVuelos() {
        List<ModeloPreFactura> preFacturaList = new ArrayList<>();

        ConexionAgente conexionAgente = new ConexionAgente();
        conexionAgente.setUrl("jdbc:oracle:thin:@192.168.56.101:1521:xe");
        conexionAgente.setUsuario("system");
        conexionAgente.setPassword("leo");
        conexionAgente.Conectar();

        if (conexionAgente.getConnection() != null)
            System.out.println("Se ha conectado correctamente");
        else
            System.out.println("Se ha interrumpido la conexion");

        SentenciasAgente sentenciasAgente = new SentenciasAgente();
        preFacturaList = sentenciasAgente.obtenerTodosVuelos(conexionAgente);

        return preFacturaList;

    }

}
