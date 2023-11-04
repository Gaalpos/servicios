package Ejemplos1;

public class TestSegundoHiloJoin {

	public static void main(String[] args) {
		SegundoHilo macarron = null;
		System.out.println("Vamos a hacer unos macarrones");

		for (int i = 0; i < 21; i++) {
			macarron = new SegundoHilo(i);
			macarron.start();
			try {
				macarron.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Han terminado todos los macarrones de hacerse");
		System.out.println("Macarron ha terminado");
	}
}
