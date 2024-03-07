package tcpdos;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente2 {
	public static void main(String[] args) throws Exception {
		String Host = "localhost";
		 //InetAddress i = InetAddress.getByName("10.101.19.19");
		int Puerto = 6000;//puerto remoto
		System.out.println("PROGRAMA CLIENTE INICIADO....");
		Socket cliente = new Socket(Host, Puerto);
		
		// CREO FLUJO DE SALIDA AL SERVIDOR
		PrintWriter fsalida= new PrintWriter(cliente.getOutputStream(),true);
		
		
		// CREO FLUJO DE ENTRADA AL SERVIDOR
		BufferedReader fentrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
		
		
		//Flujo para entrada estandar
		Scanner sc = new Scanner(System.in);
		String cadena, eco="";
		System.out.println("Introduce cadena: ");
		cadena=sc.nextLine();
		
		
		while(cadena != null) {
			
			fsalida.print(cadena);
			eco= fentrada.readLine();
			System.out.println("=> Eco: "+eco);
			System.out.println("Introduce cadena: ");
			cadena= sc.nextLine();
			if(cadena.equals("*"))break;
			
			
			
		}
		System.out.println("Programa cliente cerrandose");
		
		
		
		
		// CERRAR STREAMS Y SOCKETS
		fentrada.close();
		fsalida.close();
		cliente.close();
		
		}// fin de main
	
	
	
	
}
