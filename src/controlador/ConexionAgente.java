package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionAgente {

    private String usuario = "leo_proyecto";
    private String password = "pro123";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";


    private Connection connection = null;

    public void Conectar(){
        try{
            this.setConnection(DriverManager.getConnection(url, usuario, password));
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void Desconectar(){
        try{
            if(this.getConnection() != null && !this.getConnection().isClosed())
                this.getConnection().close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
