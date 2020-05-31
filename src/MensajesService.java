import java.util.Scanner;

public class MensajesService {

    public static void crearMensaje (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();
        System.out.println("Escribe el nombre del autor");
        String nombre = sc.nextLine();

        Mensajes registro  = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        MensajesDAO.crearMensajeDB(registro);
    }
    public static void listarMensaje (){
    MensajesDAO.leerMensajeDB();
    }
    public static void borrarMensaje (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el ID del mensjae a borrar");
        int id = sc.nextInt();
        MensajesDAO.borrarMensajeDB(id);
    }
    public static void editarMensaje (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu nuevo mensaje");
        String mensaje = sc.nextLine();
        System.out.println("Escribe el ID del mensaje");
        int id = sc.nextInt();
        Mensajes actualizacion = new Mensajes();
        actualizacion.setId_mensaje(id);
        actualizacion.setMensaje(mensaje);
        MensajesDAO.actualizarMensajeDB(actualizacion);
    }

}
