package Actividad1hilos;

public class TestTicTac {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		System.out.println("prueba de tik tac");
		
		Tac tac = new Tac("Tac ...");
		Tic tic = new Tic("Tac ...");
		
		tic.start();
		tac.start();

		try {
			tic.join();
			tac.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
