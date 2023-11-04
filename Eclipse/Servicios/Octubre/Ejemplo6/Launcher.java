package Ejemplo6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Launcher {

	public static void main(String[] args) {

		String[] ficheroEntrada = { "informatica.txt", "gerencia.txt", "rrhh.txt", "contabilidad.txt", "comercio.txt" };
		String[] ficheroSalida = { "informaticaTotal.txt", "gerenciaTotal.txt", "rrhhTotal.txt",
				"contabilidadTotal.txt", "comercioTotal.txt" };
		String[] ficheroError = { "informaticaError.txt", "gerenciaError.txt", "rrhhError.txt", "contabilidadError.txt",
				"comercioError.txt" };

		ProcessBuilder processBuilder;
		String path = System.getProperty("user.dir");
		String paquete = "\\src\\Ejemplo6\\";
		String ruta = path + paquete;

		for (int i = 0; i < ficheroEntrada.length; i++) {

			processBuilder = new ProcessBuilder("java", ruta + "Calculadora.java", ruta+ficheroEntrada[i], ruta+ficheroSalida[i]);
			processBuilder.redirectError(new File(ruta+ficheroError[i]));
			try {
				processBuilder.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// QUIERO RECUPERAR LOS TEOTALES DE CADA FICHERO MOSTRANDOLOS POR PANTALLA
		// Y GUARDAR LOS GASTOS EN totalGastos.txt
		
		int total =0;
		int parcial =0;

		for (int i = 0; i < ficheroEntrada.length; i++) {
			try {
				// BufferedReader bufferedReader =
				// Calculadora.getBufferedReader(ficheroEntrada[i]);
				BufferedReader bufferedReader = Calculadora.getBufferedReader(ruta+ficheroSalida[i]);
				parcial = Integer.parseInt(bufferedReader.readLine());
				total = total+parcial;
				System.out.println("Gastos: " +ficheroEntrada[i]+" : "+parcial);

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("GASTOS TOTALES: "+total );
		System.out.println("Guardando en gastosTotales.txt ... " );
		try {
			PrintWriter printWriter =Calculadora.getPrintWriter(ruta+"gastosTotales.txt");
			printWriter.print(String.valueOf(total));
			printWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
