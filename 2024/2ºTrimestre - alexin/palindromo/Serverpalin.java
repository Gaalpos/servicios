package palindromo;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Serverpalin {

	
public static void main(String[] arg) throws IOException {
		
		int numPort = 6000;// Puerto
		ServerSocket servidor = new ServerSocket(numPort);
		Socket cliente = null;
		System.out.println("Esperando al cliente.....");
		
		cliente = servidor.accept();
		PrintWriter fsalida = new PrintWriter(cliente.getOutputStream(), true);
		BufferedReader fentrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
		boolean seguir=true;
		
		while (seguir) {
			String cad = fentrada.readLine();
			
			if (cad.equals("quit")) 
				seguir=false;
			else
				fsalida.println(esPalindromo(cad));
					
		}
		
		// CERRAR STREAMS Y SOCKETS
		System.out.println("cerrando conexion ....");
		fentrada.close();
		fsalida.close();
		cliente.close();
		servidor.close();
	}// main

	public static String esPalindromo(String cad) {
		
		System.out.println("Recibiendo cadena: " + cad);
		String chequeo= cad.replaceAll("[ ,.]","");
		System.out.println("Sin Espacios cadena: " + chequeo);
		String sin=chequeo.toLowerCase();
		
		StringBuilder sb = new StringBuilder(sin);
		String reves=sb.reverse().toString();
		
		if(sin.equals(reves))
			return "ES PALINDROMO";
		else
			return "NO ES PALINDROMO";
	
	}
}