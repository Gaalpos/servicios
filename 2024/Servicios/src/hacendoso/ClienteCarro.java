package hacendoso;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ClienteCarro {
	static Scanner sc;
    public static void main(String[] arg) throws IOException, ClassNotFoundException {
    	
    	sc = new Scanner(System.in);
    	
        String host = "localhost";
        int puerto = 6000; // puerto remoto
        System.out.println("PROGRAMA CLIENTE INICIADO....");
        Socket cliente = new Socket(host, puerto);

     // Se prepara un flujo de salida para objetos
        ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());
        
        ArrayList<Elemento> enviados= new ArrayList<Elemento>();
        System.out.println("Cuantos productos añadimos para enviar al servidor?: ");
        int num= sc.nextInt();
        for(int i=0;i<num;i++) {
        	 Elemento per = addElemento();
             enviados.add(per);
        }
       
        outObjeto.writeObject(enviados);
        // Se obtiene un stream para leer objetos
        //ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
        //ArrayList<Elemento> recibidos= new ArrayList<Elemento>();
        //recibidos =(ArrayList<Elemento>) inObjeto.readObject();
        //System.out.println("Recibo: " +dato.toString());
        System.out.println("Recibo: ");
        for(Elemento p: recibidos) {
        	System.out.println(p);
        }

        // CERRAR STREAMS Y SOCKETS
        outObjeto.close();
        inObjeto.close();
        cliente.close();
        sc.close();
    }// Fin de main
    
    public static Elemento addElemento() {
    	System.out.println("introduce datos de la nueva persona");
    	Elemento p= new Elemento();
    	System.out.println("Nombre: ");
    	String s=sc.next();
    	System.out.println("Edad: ");
    	int e=sc.nextInt();
    	p.setNombre(s);
    	p.setEdad(e);
    	
    	return p;
    }
}
