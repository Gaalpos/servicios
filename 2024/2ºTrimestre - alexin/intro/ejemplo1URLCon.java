package intro;
import java.net.*;
import java.io.*;

public class ejemplo1URLCon {
    public static void main(String[] args) {
        URL url = null;
        URLConnection urlCon = null;

        try {
            url = new URL("https://www.cebem.net/index.php/es/");
            urlCon = url.openConnection();
            BufferedReader in;

            InputStream inputStream = urlCon.getInputStream();
            in = new BufferedReader(new InputStreamReader(inputStream));

            String inputLine;
            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);

            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }// fin de main
}// Fin de Ejemplo1urlCon
