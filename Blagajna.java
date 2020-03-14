import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

class Blagajna {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(
            new FileReader(new File("vhodi.txt")));

            String line;
            while( (line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.getMessage();
        }
    }
}