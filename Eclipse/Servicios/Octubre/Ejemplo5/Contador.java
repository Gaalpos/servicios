package Ejemplo5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;




public class Contador {
	
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
	public static void hacerRecuento(String fichEntrada, String letra, String fichSalida)
			throws FileNotFoundException, IOException {
		
		BufferedReader br= getBufferedReader(fichEntrada);
		PrintWriter pw = getPrintWriter(fichSalida);
		String lineaLeida= br.readLine();
		
		int totalVocales = 0;
		
		// Mientras no queden líneas....
		while (lineaLeida != null) {
			// ...recorremos la linea...
			for (int i = 0; i < lineaLeida.length(); i++) {
				char letraLeida = lineaLeida.charAt(i);
				char letraPasada = letra.charAt(0);
				// incrementamos el contador
				if (letraLeida == letraPasada) {
					totalVocales++;
				}
				// fin del if

			}
			// fin del for
			// Pasamos a la siguiente linea
			lineaLeida = br.readLine();
		}
		
		// Escribimos el total de vocales
		// en el fichero de salida
		pw.println(totalVocales);
		pw.flush();
		// Y cerramos los ficheros
		pw.close();
		br.close();
		// fin del método hacerRecuento
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//Scanner sc = new Scanner(System.in);
		
		
		
		System.out.println("Fichero de entrada");
		//String fileIn = sc.nextLine();
		String fileIn = args[0];
		System.out.println("Caracter a buscar");
		//String letter = sc.nextLine();
		String letter = args[1];
		System.out.println("Fichero de salida");
		//String fileOut = sc.nextLine();
		String fileOut = args[2];
		hacerRecuento(fileIn, letter, fileOut);
	}
}
