package contemos;

public class HiloInc extends Thread {

	private Contador contador;
	
	public HiloInc(String n, Contador c) {
		setName(n);
		contador = c;
	}
	
	
	
	public void run() {
		synchronized (contador) {
			for(int j =0; j<300; j++) {
				contador.incrementa();
				try {
					sleep(150);
				} catch (Exception e) {
					System.out.println("errror");
				}
				System.out.println(getName ()+ "contador vale" + contador.getValor());
			}
		}
	
	}
	
}
