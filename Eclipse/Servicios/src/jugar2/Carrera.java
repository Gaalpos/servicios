package jugar2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Carrera {

	ArrayList<Atleta> finalistas ;
	
	

	Carrera(ArrayList<Atleta> f) {
		this.finalistas = f;
	}

	public void ordenar() {
		Collections.sort(finalistas);
	}
	public int numeroParticipantes() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca numero de participantes: ");
		int n = sc.nextInt();
		return n;
	}
	
	public void correr() {
		for(Atleta atleta : finalistas) {
			new Thread(atleta).start();
		}
	}
	public void mostrarClasificacion() {
		ordenar();
		System.out.println("clasificacion");
		for(Atleta atletas :finalistas) {
			System.out.println(atletas.toString());
		}
	}

	public void inicializaCarrera() {
		int n = numeroParticipantes();
	
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<n;i++) {
			System.out.println("datos del atleta "+i+" : ");
			
			System.out.println("Nombre");
			String nombre = sc.nextLine();
			
			System.out.println("Pais");
			String pais = sc.nextLine();
			
			System.out.println("Dorsal");
			int dorsal = sc.nextInt();
			
		}
		

	}

}
