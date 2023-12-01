package Prodduccion;

public class testCola {
	
	
	public static void main(String[] args) {
		Cola hola = new Cola();
		Productor jowi= new Productor(hola,11);
		Consumidor pepe = new Consumidor(hola, -55 );


		jowi.start();
		pepe.start();
	}
}
