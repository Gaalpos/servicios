package Banco;

public class SacarDinero extends Thread {

	
	private Cuenta c;
	
	String nom;

	public SacarDinero(Cuenta c, String nom) {
		super(nom);
		this.c = c;
		//this.nom = nom;
	}

	public void run(){
		for(int i=0;i<=4;i++) {
			c.RetirarDinero(10, this.getName());
			Cuenta c = new Cuenta(40);
		}
	}
	
	
}
