package palindromo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Clientepalin {
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
			System.out.print("Introduce frase para comprobar palindromo: ");
			String cadena = sc.nextLine();
			fsalida.println(cadena);
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