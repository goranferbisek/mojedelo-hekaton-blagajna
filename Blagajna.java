import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.regex.*;

class Blagajna {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(
            new FileReader(new File("vhodi.txt"))); //vhod

            String line;

            //regex pattern (row length) (rows) (text)
            Pattern pattern = Pattern.compile("(\\d+)\\s(\\d+)\\s(.+)");
            Matcher matcher;

            while ( (line = reader.readLine()) != null) {
                matcher = pattern.matcher(line);

                if (matcher.groupCount() != 3) {
                    System.out.println("Parsing did not succeed");
                } else {
                    System.out.println("Let's get it on");
                }
            }

            reader.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }
}