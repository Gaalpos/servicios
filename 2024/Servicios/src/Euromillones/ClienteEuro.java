package Euromillones;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteEuro {
	public static void main(String[] args) throws Exception {

		String host = "localhost";
		int port = 6000;// puerto remoto
		System.out.println("PROGRAMA CLIENTE INICIADO....");
		System.out.println("escribe quit para terminar....");

		Socket cliente = new Socket(host, port);
		PrintWriter fsalida = new PrintWriter(cliente.getOutputStream(), true);
		BufferedReader fentrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

		Scanner sc = new Scanner(System.in);
		boolean seguir = true;

		do {
			// envio
			System.out.print("Introduce numeros (1-50) para comprobar millones: ");
			
			String cadena = sc.nextLine();
			fsalida.println(cadena);
			System.out.println("Introduce estrellas (1-12) para comprobar millones: ");
			
			String estrella= sc.nextLine();
			fsalida.print(estrella);
			if (cadena.equals("quit"))
				seguir = false;
			else {
			// recibo
			String eco = fentrada.readLine();
			System.out.println("=>recibo: " + eco);
			}
		} while (seguir);

		System.out.println("programa cliente cerrandose");
		// CERRAR STREAMS Y SOCKETS
		fentrada.close();
		fsalida.close();
		cliente.close();
	}// fin de main
}
