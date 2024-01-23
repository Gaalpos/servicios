package TCP1;

import java.io.DataInputStream;

import java.io.DataOutputStream;

import java.io.IOException;

import java.io.InputStream;

import java.io.OutputStream;

import java.net.ServerSocket;

import java.net.Socket;


public class Server1 {

	public static void main(String[] arg) throws IOException {

		

		int numPort = 6000;// Puerto

		ServerSocket servidor = new ServerSocket(numPort);

		

		Socket cliente = null;

		System.out.println("Esperando al cliente.....");

		cliente = servidor.accept();

		

		// CREO FLUJO DE ENTRADA DEL CLIENTE

		InputStream entrada = null;

		entrada = cliente.getInputStream();

		DataInputStream flujoEntrada = new

		DataInputStream(entrada);


		System.out.println("Recibiendo del CLIENTE: \n\t" +
		flujoEntrada.readUTF());
		OutputStream salida = null;
		salida = cliente.getOutputStream();
		DataOutputStream flujoSalida = new
		DataOutputStream(salida);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

		flujoSalida.writeUTF("Saludos al cliente del servidor");


		entrada.close();
		flujoEntrada.close();
		salida.close();
		flujoSalida.close();
		cliente.close();
		servidor.close();

		}// main

}
