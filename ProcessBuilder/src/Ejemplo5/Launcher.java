package Ejemplo5;

import java.io.File;
import java.io.IOException;

/*
 * 1 recoger el primer aprametro (argas ([0]) quje contendra el fichero a procesar
 * 
 * 2 Recoger el segundo parametro que contendra el directorio classhpath donde habra
 * que buscar la clase utilidadesFicheros ????
 * 
 * 3 recoger el tercer parametro, que contendra el directorio donde habra 
 * que buscar la clase "Contador"
 * 
 * 4 una vez recogidos los parametros, se lanzaran varios procesos utilizando cla clase
 * ProcessBuilder
 * 
 * 5. Los preoceseos se ejecutaran y despues recogeremos los resultados en unos ficheros 
 * con un dato entero
 */

public class Launcher {

	public static void main(String[] args) throws IOException, InterruptedException {
		// fichero antigero2.txt
		String entrada = "antihero2.txt";

		// ruta hata Contador.java
		String ruta = "\\src\\Ejemplo5\\Contador.java";

		String[] vocales = { "a", "e", "i", "o", "u" };

		String classPath = System.getProperty("user.dir");

		System.out.println("usando ruta: " + ruta);
		System.out.println("usando classpath: " + classPath);
		System.out.println("usando classpath + ruta: " + classPath+ruta);

		for (int i = 0; i < vocales.length; i++) {
			String fichErrores = "Errores_" + vocales[i] + ".txt";
			ProcessBuilder pb;
			pb = new ProcessBuilder("java", classPath + ruta, entrada, vocales[i],
					vocales[i] + ".txt");

			// Si hay algún error, almacenarlo en un fichero
			pb.redirectError(new File(fichErrores));
			pb.start();
			// fin del for
		}
	}

}
