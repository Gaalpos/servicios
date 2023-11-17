package jugar2;

import java.util.Random;

public class Atleta implements Runnable {

	int dorsal;
	String nombre;
	long tiempo;
	String pais;

	Atleta() {

	}

	public Atleta(int dorsal, String nombre, String pais) {
		super();
		this.dorsal = dorsal;
		this.nombre = nombre;
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Atleta [dorsal=" + dorsal + ", nombre=" + nombre + ", tiempo=" + tiempo + ", pais=" + pais + "]";
	}

	public int compareTo(Object obj) {
		Atleta a = (Atleta) obj;
		return (int) (this.tiempo - a.tiempo);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(this.nombre + " preparado ");
		long inicio = System.currentTimeMillis();
		Random r = new Random();
		long t = r.nextLong(8000, 12000);
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this.nombre + " llegando ");
		long fin = System.currentTimeMillis();
		this.tiempo = fin;
		System.out.println(toString());
	}

}
