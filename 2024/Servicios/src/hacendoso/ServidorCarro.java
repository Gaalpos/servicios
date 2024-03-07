package hacendoso;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ServidorCarro {
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
        	
  	
       String envia="";
        
        
        

        // FLUJO DE salida para objetos CAMBIAR A STRING
        for(int i=0;i<calculaCuenta(recibe).length;i++) {
        	envia+=calculaCuenta(recibe)[i]+"";
        	
        }
        OutputStream perSal =cliente.getOutputStream();
        PrintWriter pw= new PrintWriter(perSal);

        // Se envía el objeto
        pw.write(envia);
   
        
        // CERRAR STREAMS Y SOCKETS
        perEnt.close();
        perSal.close();
        cliente.close();
        sc.close();
    }// Fin de main
    
    
    public static double[] calculaCuenta(ArrayList<Elemento> prod) {
    	System.out.println(" datos de la persona recibida");
    	double base=0d;
    	for(Elemento e:prod) {
    		System.out.println(e);
    		base+=e.getPrecio()*e.getCantidad();
    	}
    	/*System.out.println(p.toString());
    	System.out.println("Modifica nombre: ");
    	String s=sc.next();
    	System.out.println("Modifica edad: ");
    	int e=sc.nextInt();*/
    	double iva=base*0.21;
    	double total=base+iva;
    	double[] datos= {base,iva,total};
    	return datos;
    	
    	
    }
}
