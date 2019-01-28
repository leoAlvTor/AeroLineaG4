package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SentenciasAgente {

    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;

    private ResultSet resultado = null;
    private PreparedStatement psentencia = null;

    /**
     * metodo para ingresar clientes 
     */
    public void crearCliente(ConexionAgente con ,String nomCompletos,String ced, String direcc ,String fecha_nac) {
    	
    	/**
    	 * ATENTO QUE FALTA LA FECHA DE NACIMIENTO
    	 */
    	
    	try {
    		
    		String sentencia ="insert into age_clientes values "
    				+ "(next_id_Clientes,?,?,?)";
    		
    		psentencia=con.getConnection().prepareStatement(sentencia);
    		psentencia.setString(1, nomCompletos);
    		psentencia.setString(2, ced);
    		psentencia.setString(3, direcc);
    		//psentencia.setString(4, fecha_nac);
    		
    		psentencia.executeUpdate();
  
    		
    	}catch (SQLException e) {
			e.printStackTrace();
		}
    	
    }



}
