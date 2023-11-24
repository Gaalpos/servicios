package contemos;

public class TestContador {
	
	public static void main(String[] args) {
	
		
		
		Contador cont = new Contador(100);
		HiloInc a = new HiloInc("Steam deck  ", cont);
		HiloDec b = new HiloDec("ROG Ally  ", cont);
		a.start();
		b.start();
	}
}
