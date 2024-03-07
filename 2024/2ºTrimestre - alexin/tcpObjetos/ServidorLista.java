package tcpObjetos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ServidorLista {
	static Scanner sc;
    public static void main(String[] arg) throws IOException, ClassNotFoundException {
    	sc = new Scanner(System.in);
        int numeroPuerto = 6000; // Puerto
        ServerSocket servidor = new ServerSocket(numeroPuerto);
        System.out.println("Esperando al cliente.....");
        Socket cliente = servidor.accept();
     
        ArrayList<Elemento> recibe= new ArrayList<Elemento>();
        ObjectInputStream perEnt = new ObjectInputStream(cliente.getInputStream());

        
       //Recibe Lista completa
        recibe=(ArrayList<Elemento>) perEnt.readObject();
        	
        
        for(Elemento manolo: recibe) {
        	
        	modificarPersona(manolo);
        }
        
        

        // FLUJO DE salida para objetos
        ObjectOutputStream perSal = new ObjectOutputStream(cliente.getOutputStream());

        // Se envía el objeto
        perSal.writeObject(recibe);
   
        
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
    	String s=sc.next();
    	System.out.println("Modifica edad: ");
    	int e=sc.nextInt();
    	p.setNombre(s);
    	p.setEdad(e);
    	
    	
    }
}
