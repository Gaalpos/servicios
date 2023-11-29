package Prodduccion;

public class testCola {
	
	
	public static void main(String[] args) {
		Cola hola = new Cola();
		Productor jowi= new Productor(hola,7);
		Consumidor pepe = new Consumidor(hola, 0);


		jowi.start();
		pepe.start();
	}
}
