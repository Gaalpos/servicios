package Banco;

public class testCuenta {
	
	public static void main(String[] args) {
		
		System.out.println("sacando dinero");
		Cuenta c= new Cuenta(400);
		
		SacarDinero s1 = new SacarDinero(c, "Yowi");
		SacarDinero s2 = new SacarDinero(c, "Pichu");
		
		s1.start();
		s2.start();
		
		System.out.println("fin ");
		
	}

}
