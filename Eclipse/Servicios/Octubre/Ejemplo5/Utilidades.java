package Ejemplo5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Utilidades {

	//LEER DE UN FICHERO
	public static BufferedReader getBufferedReader(String nombreFichero) throws FileNotFoundException {

		FileReader lector = new FileReader(nombreFichero);
		BufferedReader bufferedReader = new BufferedReader(lector);
		return bufferedReader;
	}

	// PARA ESCRIBIR EN UN FICHERO
	public static PrintWriter getPrintWriter(String nombreFichero) throws IOException {
		FileWriter fileWriter = new FileWriter(nombreFichero);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		return printWriter;
	}

	
	// PARA OBTENER UNA LSITA DINAMICA DE CADENAS DE LAS LINEAS DE UN FICHERO
	public static ArrayList<String> getLineasFichero(String nombreFichero) throws IOException {
		ArrayList<String> lineas = new ArrayList<String>();
		BufferedReader bfr = getBufferedReader(nombreFichero);
		
		// Leemos líneas del fichero...
		String linea = bfr.readLine();
		while (linea != null) {
			// Y las añadimos al array
			lineas.add(linea);
			linea = bfr.readLine();
		}
		// Fin del bucle que lee líneas
		return lineas;
	}
}
