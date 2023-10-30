package ejemplo7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;





public class Calculadora {
	
	public static void hacerCalculosCondicionados(String fichEntrada,String fichSalida, String cantidad) throws IOException {
		
		int suma=0;
		int corte= Integer.parseInt(cantidad);
		//1 Abrir el fichero informática.txt
			ArrayList<String> cantidades= getLineasFichero(fichEntrada);
		
			// TODO Auto-generated catch block
			
		
			//2 Sumar las cantidades de dicho fichero
		for(String s : cantidades) {
			int aux=Integer.parseInt(s);
			if(aux>corte)
			suma+= aux;
		}
		//provisionalmente
		System.out.println("el total de gastos de: "+fichEntrada+" es: "+suma+" €");
		
		//3 Guardar el resultado numérico en un fichero llamado 
		//totalInformatica.txt
		PrintWriter pw=  getPrintWriter(fichSalida);
		pw.println(suma);
		pw.close();
		
	}
	
	
public static void main(String[] args) {
	String ent, sal;
	String cantidad;
	//Scanner jaime= new Scanner(System.in);
	
	System.out.println("fichero de entrada: ");
	ent=args[0];  //jaime.nextLine();
	
	System.out.println("fichero de salida: ");
	sal=args[1];  //jaime.nextLine();
	
	System.out.println("Cantidad de corte: ");
	cantidad=args[2];   //jaime.nextInt();
	
	try {
		hacerCalculosCondicionados(ent,sal,cantidad);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}


public static BufferedReader getBufferedReader(
		String nombreFichero) 
				throws FileNotFoundException {

		FileReader lector;
		lector = new FileReader(nombreFichero);
		BufferedReader bufferedReader = new BufferedReader(lector);
		return bufferedReader;
		}

//Para escribir en un fichero
public static PrintWriter getPrintWriter(String nombreFichero) throws
IOException {
FileWriter fileWriter = new FileWriter(nombreFichero);
PrintWriter printWriter = new PrintWriter(fileWriter);
return printWriter;
}

//para obtener una lista dinámica de las líneas de un fichero
public static ArrayList<String> getLineasFichero(String nombreFichero)
		throws IOException {
		ArrayList<String> lineas = new ArrayList<String>();
		
		BufferedReader bfr = getBufferedReader(nombreFichero);
		
		//Leemos líneas del fichero...
		
		String linea = bfr.readLine();
		
		while (linea != null) {
			
		//Y las añadimos al array
		lineas.add(linea);
		linea = bfr.readLine();
		}
		//Fin del bucle que lee líneas
		return lineas;
		}
}
