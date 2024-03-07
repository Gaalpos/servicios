package tcpin;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client1 {
	
	public static void main(String[] args) throws IOException {
        String host = "localhost";
        int puerto = 6000; // puerto remoto

        
        InetAddress i = InetAddress.getByName("10.101.19.19");
        // ABRIR SOCKET
        Socket cliente = new Socket(i, puerto); // conecta
        

        System.out.println("Puerto local: " + cliente.getLocalPort());
        System.out.println("Puerto Remoto: " + cliente.getPort());
        System.out.println("Host Remoto: " + i.getHostName());
        System.out.println("IP Host Remoto: " + i.getHostAddress());

        // No es necesario cerrar explícitamente el socket en este contexto.
        //cliente.close(); // Cierra el socket
    }

}
