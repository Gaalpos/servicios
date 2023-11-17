package jugar2;

public class TestAtleta {
	
	public static void main(String[] args) {
		Atleta peleteiro;
		
		for(int i=0;i<3;i++) {
			peleteiro = new Atleta(i+1, "ghicho"+i, "pais"+i);
			new Thread(peleteiro).start();
			//peleteiro.run();
		}
	}

}
