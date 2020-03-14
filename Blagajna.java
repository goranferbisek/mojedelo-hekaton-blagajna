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
            int pixelSize;

            while ((line = reader.readLine()) != null) {
                matcher = pattern.matcher(line);

                if (matcher.matches()) {
                    pixelSize = pixelSize(
                            Integer.parseInt(matcher.group(1)),
                            Integer.parseInt(matcher.group(2)),
                            matcher.group(3));

                    //later we write to a file
                    System.out.println(pixelSize);
                } else {
                    System.out.println("Parsing failed");
                }
            }

            reader.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    private static int pixelSize(int rowLength, int rows, String text) {
        String[] words = textToArray(text);
        return longestStringLength(words);
    }

    private static String[] textToArray(String text) {
        return text.split(" ");
    }

    private static int longestStringLength(String[] words) {
        int maxLength = 0;

        for(String word: words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
        }
        return maxLength;
    }
}