import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Inicio {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {

            System.out.println("-----------------");
            System.out.println("Aplicacion de mensajes");
            System.out.println("1. Crear un mensaje");
            System.out.println("2. Listar un mensaje");
            System.out.println("3. Eliminar un mensaje");
            System.out.println("4. Modificar un mensaje");
            System.out.println("5. Salir");
            //Leemos al opcion del usuario en panatalla
            opcion = sc.nextInt();
            switch (opcion){
                case 1:
                    MensajesService.crearMensaje();
                    break;
                case 2:
                    MensajesService.listarMensaje();
                    break;
                case 3:
                    MensajesService.borrarMensaje();
                    break;
                case 4:
                    MensajesService.editarMensaje();
                    break;
                default:
                    break;
            }

        }while (opcion != 5);
        Conexion conexion = new Conexion();

        try (Connection cnx = conexion.getConection()){

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}