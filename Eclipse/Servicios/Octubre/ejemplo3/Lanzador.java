package ejemplo3;

import java.io.File;

public class Lanzador {

  public void lanzarSumador(Integer n1, Integer n2, String fichResultado) {
    String clase = "C:\\DAM\\servicios\\Septiembre\\ejemplo2\\Sumador";
    ProcessBuilder pb;
    try {
      pb = new ProcessBuilder("java", clase, n1.toString(), n2.toString());

      pb.redirectError(new File("errores.txt"));
      pb.redirectOutput(new File(fichResultado));
      pb.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

public static void main(String[] args) {

    Lanzador launcher = new Lanzador();
    launcher.lanzarSumador(1, 5, "result1.txt");
    launcher.lanzarSumador(6, 10, "result2.txt");
    System.out.println("Ok");
  }
}
