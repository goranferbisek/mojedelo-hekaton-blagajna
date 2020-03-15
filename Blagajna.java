import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.regex.*;

class Blagajna {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(
            new FileReader(new File("test.txt")));

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

        int maxStringLen = longestStringLength(words);
        int maxSize = rowLength / maxStringLen;

        // if longest word is longer than row lenght
        if (maxStringLen > rowLength) {
            return 0;
        }

        int remainingRows;
        int currentRowLength;

        //try to put text on to display
        while (maxSize > 0) {
            //scale dimensions

            rowLength  /= maxSize;
            currentRowLength = rowLength;
            remainingRows = rows / maxSize;
            boolean isNewLine = true;

            int wordCount = 0;
            String word = null;

            while (wordCount < words.length) {
                word = words[wordCount];
                // if first word in row
                if (isNewLine) {
                    currentRowLength -= word.length();
                    wordCount++;
                    isNewLine = false;
                } else {
                    // if next word fits to row add one for space
                    if (word.length() + 1  <= currentRowLength ) {
                        currentRowLength -= word.length() + 1;
                        wordCount++;
                    } else {
                        remainingRows--;
                        currentRowLength = rowLength;
                        isNewLine = true;
                    }

                    if (remainingRows == 0) {
                        maxSize--;
                        break;
                    }
                }
            }

            return maxSize;
        }

        return maxSize;
    }

    private static String[] textToArray(String text) {
        return text.split(" ");
    }

    private static int longestStringLength(String[] words) {
        int maxLength = 0;

        for (String word: words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
        }
        return maxLength;
    }
}