package udpUno;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteUno {
	
	public static void main(String[] args) throws IOException {
		 InetAddress destino = InetAddress.getLocalHost();
         int port = 12345; // Puerto al que se envía el datagrama
         String saludo = "Enviando Saludos !!";
         byte[] mensaje = saludo.getBytes(); // Codificar String a bytes

         // Construir el Datagrama a enviar
         DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, port);

         // Abrir un socket Datagrama en un puerto local
         DatagramSocket socket = new DatagramSocket(34567); // Puerto local
         System.out.println("Enviando Datagrama de longitud: " + mensaje.length);
         System.out.println("Host destino: " + destino.getHostName());
         System.out.println("IP Destino: " + destino.getHostAddress());
         System.out.println("Puerto local del socket: " + socket.getLocalPort());
         System.out.println("Puerto al que envío: " + envio.getPort());

         // Enviar el Datagrama
         socket.send(envio);
         socket.close(); // Cerrar el socket
	
}
}
