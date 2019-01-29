package controlador;

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
