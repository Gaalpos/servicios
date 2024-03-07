package tcpObjetos;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ServidorObjeto {
	static Scanner sc;
    public static void main(String[] arg) throws IOException, ClassNotFoundException {
    	sc = new Scanner(System.in);
        int numeroPuerto = 6000; // Puerto
        ServerSocket servidor = new ServerSocket(numeroPuerto);
        System.out.println("Esperando al cliente.....");
        Socket cliente = servidor.accept();
     // Flujo de entrada para objetos
        ObjectInputStream perEnt = new ObjectInputStream(cliente.getInputStream());

        // Se recibe un objeto
        Elemento dato = (Elemento) perEnt.readObject();
        // Recibo objeto
        //System.out.println("Recibo: " + dato.getNombre() + "*" + dato.getEdad());

        // Modifico el objeto
        
        //dato.setNombre("Juan Ramos");
        //dato.setEdad(22);
        modificarPersona(dato);

        // FLUJO DE salida para objetos
        ObjectOutputStream perSal = new ObjectOutputStream(cliente.getOutputStream());

        // Se envía el objeto
        perSal.writeObject(dato);
        System.out.println("Envio: " + dato.getNombre() + "*" + dato.getEdad());

        // CERRAR STREAMS Y SOCKETS
        perEnt.close();
        perSal.close();
        cliente.close();
        sc.close();
    }// Fin de main
    
    
    public static void modificarPersona(Elemento p) {
    	System.out.println(" datos de la persona recibida");
    	System.out.println(p.toString());
    	System.out.println("Modifica nombre: ");
    	String s=sc.nextLine();
    	System.out.println("Modifica edad: ");
    	int e=sc.nextInt();
    	p.setNombre(s);
    	p.setEdad(e);
    	
    	
    }
}// Fin de ServidorObjeto
