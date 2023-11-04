package Ejemplos1;

public class TestSegundoHilo {
	public static void main(String[] args) {
		
		SegundoHilo macarron=null;
		
		for(int i=0;i<21;i++) {
			macarron=new SegundoHilo(i);
			macarron.start();
		}
		System.out.println("Macarron ha terminado");
	}
	

}
