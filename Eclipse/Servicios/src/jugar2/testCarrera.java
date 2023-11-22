package jugar2;

public class testCarrera {
	
	public static void main(String[] args) {
		
		System.out.println("Inicio main");
		Carrera japon = new Carrera();
		japon.inicializaCarrera();
		japon.correr();
		
		System.out.println("PUM");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		japon.mostrarClasificacion();
		System.out.println("acabar la prueba");
	}

}
