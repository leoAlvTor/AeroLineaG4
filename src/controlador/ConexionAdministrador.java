package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * En esta clase se programo la conexion que la aplicacion tendra con la base de datos
 * se especifica el usuario, la contraseña
 * y la direccion de conexion
 * para tener un codigo mas ordenado cada rol del usuario tendra su propia conexion a la base de datos
 */
public class ConexionAdministrador {
    private String usuario = "leo_proyecto";
    private String password = "leo";
    private String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";


    private Connection connection = null;


    public void Conectar(){
        try{
            this.setConnection(DriverManager.getConnection(url,usuario,password));
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
