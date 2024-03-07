package MultiCast;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class ServerMC {
	 public static void main(String args[]) throws Exception {
	        // FLUJO PARA ENTRADA ESTANDAR
	       // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		 
		 Scanner sc= new Scanner(System.in);
		 System.out.println("Arrancando servidor multicast");
	        // Se crea el socket multicast.
	        MulticastSocket ms = new MulticastSocket();
	        int Puerto = 12345; // Puerto multicast
	        InetAddress grupo = InetAddress.getByName("225.0.0.1"); // Grupo
	        String cadena = "";
	        
	        while (!cadena.trim().equals("quit")) {
	            System.out.print("Datos a enviar al grupo: ");
	            cadena = sc.nextLine();
	            // ENVIANDO AL GRUPO
	            DatagramPacket paquete = new DatagramPacket(cadena.getBytes(), cadena.length(), grupo, Puerto);
	            ms.send(paquete);
	        }
	        // Cerrar socket
	        ms.close();
	        System.out.println("Socket cerrado...");
	    }
}
