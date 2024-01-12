package Intro;

import java.net.*;
import java.io.*;

public class Ejemplo2URLCom {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://localhost/conn/vernombre.php");
			URLConnection conexion = url.openConnection();
			conexion.setDoOutput(true);

			String cadena = "nombre=Maria Jesús&apellidos=Ramos Martin";

			PrintWriter output = new PrintWriter(conexion.getOutputStream());
			output.write(cadena);
			output.close(); 

			BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
			String linea;
			while ((linea = reader.readLine()) != null) {
				System.out.println(linea);
			}
			reader.close();
		} catch (MalformedURLException me) {
			System.err.println("MalformedURLException: " + me);
		} catch (IOException ioe) {
			System.err.println("IOException: " + ioe);
		}
	}
}
	