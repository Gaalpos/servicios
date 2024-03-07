package tcpObjetos;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteObjeto {
	static Scanner sc;
    public static void main(String[] arg) throws IOException, ClassNotFoundException {
    	
    	sc = new Scanner(System.in);
    	
        String host = "localhost";
        int puerto = 6000; // puerto remoto
        System.out.println("PROGRAMA CLIENTE INICIADO....");
        Socket cliente = new Socket(host, puerto);

     // Se prepara un flujo de salida para objetos
        ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());

        // Se prepara un objeto y se envía
        Elemento per = crearPersona();
        outObjeto.writeObject(per);
        // enviando objeto
        //System.out.println("Envio: " + per.getNombre() + "*" + per.getEdad());

        // Se obtiene un stream para leer objetos
        ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
        Elemento dato = (Elemento) inObjeto.readObject();
        System.out.println("Recibo: " +dato.toString());

        // CERRAR STREAMS Y SOCKETS
        outObjeto.close();
        inObjeto.close();
        cliente.close();
        sc.close();
    }// Fin de main
    
    public static Elemento crearPersona() {
    	System.out.println("introduce datos de la nueva persona");
    	Elemento p= new Elemento();
    	System.out.println("Nombre: ");
    	String s=sc.nextLine();
    	System.out.println("Edad: ");
    	int e=sc.nextInt();
    	p.setNombre(s);
    	p.setEdad(e);
    	
    	return p;
    }
    
    
}// Fin de ClienteObjeto

