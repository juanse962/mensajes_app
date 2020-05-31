import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public Connection getConection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/mensajes_app", "root", "");

        } catch (SQLException e){
            System.out.println(e);
        }
        return connection;
    }
}
