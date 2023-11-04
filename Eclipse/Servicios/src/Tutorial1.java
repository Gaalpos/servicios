import java.io.IOException;

public class Tutorial1 {

    public static void main(String[] args) {

        ProcessBuilder pb = new ProcessBuilder("notepad.exe");
        try {
            pb.start();
        } catch (IOException e) {
            System.out.println("error al lanzar el proceso");
            e.printStackTrace();
        }
        
    }
    
}
