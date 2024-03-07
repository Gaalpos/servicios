package udpUno;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerUno {
	
public static void main(String[] args) throws Exception {
	byte[] bufer= new byte[1024];
	DatagramSocket socket= new DatagramSocket(12345);
	
	System.out.println("Esperando datagrama...................");
	DatagramPacket recibo= new DatagramPacket(bufer,bufer.length);
	socket.receive(recibo);
	int bytesRec= recibo.getLength();
	
	String paquete= new String(recibo.getData());
	
	System.out.println("Numero de bytes recibidos: "+bytesRec);
	System.out.println("Contenido del paquete: "+paquete);
	System.out.println("Puerto de origen del mensaje: "+recibo.getPort());
	System.out.println("IP de origen: "+recibo.getAddress().getHostAddress());
	System.out.println("Puerto Destino del mesaje :"+socket.getLocalPort());
	socket.close();
}
}
