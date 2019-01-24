package controlador;

import modelo.ModeloBoletos;
import modelo.ModeloPreFactura;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class SentenciasAgente {

    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;

    private ResultSet resultado = null;
    private PreparedStatement psentencia = null;

    private ModeloPreFactura modeloPreFactura = new ModeloPreFactura();
    private List<ModeloPreFactura> preFacturaList = new ArrayList<>();

    private ModeloBoletos modeloBoletos = new ModeloBoletos();
    private List<ModeloBoletos> modeloBoletosList = new ArrayList<>();



    public List<ModeloPreFactura> obtenerTodosVuelos(ConexionAgente con){
        String codigo, origen, destino, avion;
        double costo;
        int i=0;
        try{
            psentencia = con.getConnection().prepareStatement("Select * from prefactura");
            resultado = psentencia.executeQuery();

            while (resultado.next()){
                modeloPreFactura = new ModeloPreFactura();
                codigo = resultado.getString("codigo");
                origen = resultado.getString("origen");
                destino = resultado.getString("destino");
                avion = resultado.getString("avion");
                costo = Double.parseDouble(resultado.getString("costo"));

                modeloPreFactura.setCodigo(codigo);
                modeloPreFactura.setOrigen(origen);
                modeloPreFactura.setDestino(destino);
                modeloPreFactura.setPlacaAvion(avion);
                modeloPreFactura.setCosto(costo);


                preFacturaList.add(modeloPreFactura);

            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        con.Desconectar();
        return preFacturaList;
    }




}
