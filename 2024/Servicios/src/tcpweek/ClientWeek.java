package tcpweek;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientWeek {
	public static void main(String[] args) throws Exception {
		String Host = "localhost";
		 //InetAddress i = InetAddress.getByName("10.101.19.19");
		int Puerto = 6100;//puerto remoto
		System.out.println("PROGRAMA CLIENTE INICIADO....");
		Socket cliente = new Socket(Host, Puerto);
		
		// CREO FLUJO DE SALIDA AL SERVIDOR
		PrintWriter fsalida= new PrintWriter(cliente.getOutputStream(),true);
		
		
		// CREO FLUJO DE ENTRADA AL SERVIDOR
		BufferedReader fentrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
		
		
		//Flujo para entrada estandar
		Scanner sc = new Scanner(System.in);
		
		boolean seguir=true;
		
		
		do {
			System.out.println("Introduce fecha dd/MM/yyyy");
			String cadena=sc.nextLine();
			fsalida.print(cadena);
			if(cadena.equals("quit")) {
				seguir=false;
			}
			String eco= fentrada.readLine();
			System.out.println("=> recibo: "+eco);
			
			
			if(cadena.equals("*"))break;
		}while(seguir);
			
			
			
			
		
		System.out.println("Programa cliente cerrandose");
		
		
		
		
		// CERRAR STREAMS Y SOCKETS
		fentrada.close();
		fsalida.close();
		cliente.close();
		
		}// fin de main
	
	
	
	
}
