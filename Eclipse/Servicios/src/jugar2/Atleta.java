package jugar2;

import java.util.Random;

public class Atleta implements Runnable{

	int dorsal;
	String nombre;
	long tiempo;
	String pais;
	
	Atleta(){
		
	}
	
	
	public int getDorsal() {
		return dorsal;
	}


	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getTiempo() {
		return tiempo;
	}


	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}


	public Atleta(int dorsal, String nombre, double tiempo, String pais) {
		super();
		this.dorsal = dorsal;
		this.nombre = nombre;
		//this.tiempo = tiempo;
		this.pais = pais;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(this.nombre+ " preparado ");
		double inicio = System.currentTimeMillis();
		Random r = new Random();
		long t=r.nextLong(8000, 12000);
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this.nombre + " llegando ");
		
		double fin = System.currentTimeMillis();
		System.out.println(toString());
	}

}
