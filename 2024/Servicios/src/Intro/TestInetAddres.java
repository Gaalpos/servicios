package Intro;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddres{
	
	
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
    }
	
	public static void main(String[] args) {
		
		InetAddress dir = null;
		System.out.println("------");
		System.err.println("SALIDA PARA LOCAL HOST");
		
		try {
			dir = InetAddress.getByName("EQUIPO-P24");
			pruebaMetodos(dir);
			
			System.out.println("");
			System.out.println("Salida para una url");
			System.out.println("");
			
			System.out.println("--");
			System.out.println("SALIDA PARA UNA URL");
			dir = InetAddress.getByName("www.google.es");
			pruebaMetodos(dir);
			
			
		}catch (UnknownHostException e){
			
		}
	}
	
	
	
	
}