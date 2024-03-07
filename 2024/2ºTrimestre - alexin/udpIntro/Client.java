package udpIntro;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException {
		int port=12345;
		InetAddress destino= InetAddress.getLocalHost();
		byte[] mensaje= new byte[1024];
		String saludo="Enviando Saludos!!";
		mensaje= saludo.getBytes();
		
		DatagramPacket envio= new DatagramPacket(mensaje, mensaje.length,destino,port);
		try {
			DatagramSocket socket= new DatagramSocket(34567);
			socket.send(envio);
			System.out.println("datagram enviado.....");
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
