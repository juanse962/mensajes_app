import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajesDAO {

    public static void crearMensajeDB (Mensajes mensaje){
        Conexion db_conect = new Conexion();

        try(Connection connection = db_conect.getConection()) {
            PreparedStatement ps = null;
            try{

                String query = "INSERT INTO mensajes ( mensaje, autor_mensaje) VALUES (?,?)";
                ps = connection.prepareStatement(query);
                ps.setString(1,mensaje.getMensaje());
                ps.setString(2,mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("El mensaje se creó correctamente");

            }catch (SQLException ex){
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void leerMensajeDB (){
        Conexion db_conect = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try(Connection cnx = db_conect.getConection()) {

            try {

                String query = "SELECT * FROM mensajes";
                ps = cnx.prepareStatement(query);
                rs = ps.executeQuery();
                while (rs.next()){

                    System.out.println("ID: "+rs.getInt("id_mensaje"));
                    System.out.println("Mensjae: "+rs.getString("mensaje"));
                    System.out.println("Autor: "+rs.getString("autor_mensaje"));
                    System.out.println("fecha: "+rs.getString("fecha_mensaje")+"\n");

                }
            }catch (SQLException e){

                System.out.println("No, se pudieron recuperar los datos");
                System.out.println(e);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void borrarMensajeDB (int id_mensaje){
        Conexion db_conect = new Conexion();
        try (Connection conexion = db_conect.getConection()) {

            PreparedStatement ps = null;
            try {
                String querry = "DELETE FROM mensajes WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(querry);
                ps.setInt(1,id_mensaje);
                ps.executeUpdate();
                System.out.println("El mensjae fue borrado exitosamente");

            }catch (Exception e) {
                System.out.println(e);
                System.out.println("No, se pudo borrar el mensaje");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    public static void actualizarMensajeDB (Mensajes mensaje){
        Conexion db_conect = new Conexion();
        try(Connection cnx = db_conect.getConection()) {
            PreparedStatement ps = null;
            try {
                String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                ps = cnx.prepareStatement(query);
                ps.setString(1,mensaje.getMensaje());
                ps.setInt(2,mensaje.getId_mensaje());
                ps.executeUpdate();
                System.out.println("El mensaje se actualizo correctamente");
            }catch (SQLException e){
                System.out.println(e);
                System.out.println("El mensjae no se pudo actualizar");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
