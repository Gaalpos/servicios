package tcpweek;

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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class ServerWeek {
public static void main(String[] arg) throws IOException {
		
		int numPort = 6100;// Puerto
		ServerSocket servidor = new ServerSocket(numPort);
		
		Socket cliente = null;
		System.out.println("Esperando al cliente.....");
		cliente = servidor.accept();
	
		
		// CREO FLUJO DE SALIDA AL CLIENTE
		PrintWriter fsalida= new PrintWriter(cliente.getOutputStream(),true);
		

		// CREO FLUJO DE ENTRADA DEL CLIENTE
		BufferedReader fentrada= new BufferedReader(new InputStreamReader(cliente.getInputStream()));
		
		boolean seguir=true;
		while(seguir) {
			String cad= fentrada.readLine();
			if(cad.equals("quit")) {
				seguir=false;
			}
			diaSemana(cad);
			
		}
		
		
		// CERRAR STREAMS Y SOCKETS
		System.out.println("Cerrando conexion......");
		fentrada.close();
		fsalida.close();
		cliente.close();
		servidor.close();
		}// main

		public static String diaSemana(String cad) {
			System.out.println("Recibiendo fecha: "+cad);
			String[] digitos=cad.split("/");
			
			Date date= new Date(Integer.parseInt(digitos[2]), Integer.parseInt(digitos[1])-1, Integer.parseInt(digitos[0]));
			Calendar calendar= new GregorianCalendar();
			calendar.setTime(date);
			int dia= calendar.get(calendar.DAY_OF_WEEK);
			String[] nombreDia={"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
			return cad=nombreDia[dia];
			
			
			
		}

}
