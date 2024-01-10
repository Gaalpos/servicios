package Intro;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddres {
	
	private static void pruebaMetodos(InetAddress dir) {
		
		System.out.println("\tMetodo getByName(): " + dir);
        InetAddress dir2;
        try {
            dir2 = InetAddress.getLocalHost();
            System.out.println("\tMetodo getLocalHost(): " + dir2);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        // USAMOS METODOS DE LA CLASE
        System.out.println("\tMetodo getHostName(): " + dir.getHostName());
        System.out.println("\tMetodo getHostAddress(): " + dir.getHostAddress());
        System.out.println("\tMetodo toString(): " + dir.toString());
        System.out.println("\tMetodo getCanonicalHostName(): " + dir.getCanonicalHostName());
    }// pruebaMetodos

}
