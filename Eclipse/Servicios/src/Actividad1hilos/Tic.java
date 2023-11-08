package Actividad1hilos;

public class Tic extends Thread {

	String tic;

	public Tic(String tic) {
		super();
		this.tic = tic;
	}

	public void run() {

		while (true) {
			try {
				Thread.sleep(2000);
				System.out.println(tic);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
