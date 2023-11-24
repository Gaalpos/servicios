package contemos;

public class HiloDec extends Thread {

	private Contador contador;

	public HiloDec(String n, Contador c) {
		setName(n);
		contador = c;
	}

	public void run() {
		synchronized (contador) {
			for (int j = 0; j < 300; j++) {
				contador.decrementa();
				try {
					sleep(150);
				} catch (Exception e) {
					System.out.println("errror");
				}
				System.out.println(getName() + "contador vale" + contador.getValor());
			}
		}

	}

}
