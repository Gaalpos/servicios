package tcpdos;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server2 {
public static void main(String[] arg) throws IOException {
		Scanner sc = new Scanner(System.in);
		int numPort = 6000;// Puerto
		ServerSocket servidor = new ServerSocket(numPort);
		
		Socket cliente = null;
		System.out.println("Esperando al cliente.....");
		cliente = servidor.accept();
	
		
		// CREO FLUJO DE SALIDA AL CLIENTE
		PrintWriter fsalida= new PrintWriter(cliente.getOutputStream(),true);
		

		// CREO FLUJO DE ENTRADA DEL CLIENTE
		BufferedReader fentrada= new BufferedReader(new InputStreamReader(cliente.getInputStream()));
		String cad="";
		
		while((cad=fentrada.readLine())!=null) {
			
			System.out.println("Recibiendo: "+cad);
			fsalida.print(cad.toUpperCase());
			System.out.println("Responde: ");
			if(cad.equals("*"))break;
		}
		
		
		// CERRAR STREAMS Y SOCKETS
		System.out.println("Cerrando conexion......");
		fentrada.close();
		fsalida.close();
		cliente.close();
		servidor.close();
		}// main
}
