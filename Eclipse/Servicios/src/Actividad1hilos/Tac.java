package Actividad1hilos;

public class Tac extends Thread{
	String tac;
	
	Tac(String tac){
		super();
		this.tac= tac;
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(2000);
				System.out.println(tac);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
