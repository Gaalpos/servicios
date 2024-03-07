package intro;
import java.net.*;
import java.io.*;

public class ejemplo2URL {
    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL("https://www.cebem.net/index.php/es/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        BufferedReader in;
        try {
            InputStream inputStream = url.openStream();
            in = new BufferedReader(new InputStreamReader(inputStream));
            String inputLine;

            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }// Fin de main
}// Fin de Ejemplo2URL

