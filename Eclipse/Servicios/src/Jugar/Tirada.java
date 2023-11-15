package Jugar;

public class Tirada extends Thread implements Comparable<Tirada> {

	String nombre;
	int puntos;
	
	
	Tirada (String n){
		this.nombre=n;
	}
	
	public void run() {
		Dado d;
		for(int i =0; i<2;i++) {
			d = new Dado();
			d.start();
			System.out.println(this.getNombre() +Dado.aleatorio());
			puntos +=d.getRes();
		}
		System.out.println();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	@Override
	public String toString() {
		return "Tirada [nombre=" + nombre + ", puntos=" + puntos + "]";
	}
	
	public int compareTo(Tirada o) {
		Tirada t = (Tirada ) o;
		return -(this.puntos-o.puntos);
	}	
}
