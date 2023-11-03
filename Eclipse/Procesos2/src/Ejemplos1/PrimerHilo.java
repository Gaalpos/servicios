package Ejemplos1;

public class PrimerHilo extends Thread{
	
	int x;
	
	public PrimerHilo(int x) {
	
		System.out.println("Estoy creando un hilito");
		this.x=x;
		
	}
	
	public void  run() {
		for(int i=0; i<x;i++) {
			System.out.println("sugo sugo : "+i);
		}
	}
	

}
