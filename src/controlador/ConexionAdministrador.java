package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionAdministrador {
    private String usuario, password, url;
    private Connection connection = null;

    public void Conectar(){
        try{
            this.setConnection(DriverManager.getConnection(this.getUrl(),this.getUsuario(),this.getPassword()));
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
