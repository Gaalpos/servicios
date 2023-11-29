package Banco;

public class Cuenta{
	private int saldo;
	
	Cuenta(int c){
		saldo =c;
	}
	
	int getSaldo() {
		return saldo;
	}

	public void restar(int cantidad) {
		saldo = saldo -cantidad;
		
	}

	@Override
	public String toString() {
		return "Cuenta [saldo=" + saldo + "]";
	}
	
	synchronized void RetirarDinero(int cant, String nom) {
		
		if(getSaldo() >= cant) {
			System.out.println("Se va a retirar dinero. Saldo actual: " +getSaldo());
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				
			}
			restar(cant);
			System.out.println(nom + " retira " + cant + " ACTUAL:" + getSaldo());
			
		}else {
			System.out.println( "NO HAY SALDO SUFICIENTE: " + getSaldo() );
			
		}
		if(getSaldo() < 0) {
			System.out.println("Saldo negativo: "+getSaldo());
		}
	}

	
}
