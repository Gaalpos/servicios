package Ejemplos1;

public class TestPrimerHilo {
	
	public static void main(String[] args) {
		
		PrimerHilo hilo1 = new PrimerHilo(10);
		PrimerHilo hilo2 = new PrimerHilo(10);
		System.out.println("antes de arrancar el hilo...");
		
		hilo1.start();
		hilo2.start();
	System.out.println("sugo sugo ha terminado");	
	}
	

}
