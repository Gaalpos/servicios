package Euromillones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class ServerEuro {
	
	
	public static final int[] NUMEROS= {1,2,3,4,5};
	public static final int[] ESTRELLAS= {1,2};
	
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
			String est = fentrada.readLine();
			if (cad.equals("quit")) 
				seguir=false;
			else
				fsalida.println(tienePremio(cad,est));
					
		}
		
		// CERRAR STREAMS Y SOCKETS
		System.out.println("cerrando conexion ....");
		fentrada.close();
		fsalida.close();
		cliente.close();
		servidor.close();
	}// main

	public static String tienePremio(String cad,String est) {
		System.out.println(cad);
		System.out.println(est);
		String[] num= cad.split(",");
		String[] star= est.split(",");
		int aceN=0;
		int aceS=0;
		
		
		for(int i=0;i<num.length;i++) {
			for(int j=0;j<NUMEROS.length;j++) {
				if(Integer.parseInt(num[i])==NUMEROS[j]) {
					aceN++;
				}
			}
		}
		
		for(int i=0;i<star.length;i++) {
			for(int j=0;j<ESTRELLAS.length;j++) {
				if(Integer.parseInt(star[i])==ESTRELLAS[j]) {
					aceS++;
				}
			}
		}
		
		return "Aciertos: "+aceS;
	}



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
