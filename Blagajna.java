import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.regex.*;

class Blagajna {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(
                new FileReader(new File("vhodi.txt")));

            String line;

            // regex pattern (row length) (rows) (text)
            Pattern pattern = Pattern.compile("(\\d+)\\s(\\d+)\\s(.+)");
            Matcher matcher;
            int pixelSize;

            while ((line = reader.readLine()) != null) {
                matcher = pattern.matcher(line);

                if (matcher.matches()) {
                    pixelSize = getPixelSize(
                                    Integer.parseInt(matcher.group(1)),
                                    Integer.parseInt(matcher.group(2)),
                                    matcher.group(3));

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

    private static int getPixelSize(int rowLength, int rows, String text) {
        String[] words = text.split(" ");

        int maxStringLen = longestStringLength(words);
        int maxPixelSize = rowLength / maxStringLen;

        if (maxStringLen > rowLength) {
            return 0;
        }

        // try to put text on to display
        while (maxPixelSize > 0) {
            if (fitsOnDisplay(rowLength, rows, words, maxPixelSize)) {
                return maxPixelSize;
            } else {
                maxPixelSize--;
            }
        }

        return 0;
    }

    private static boolean fitsOnDisplay(int rowLength, int rows, String[] words, int pixelSize) {
        // scale dimensions
        rowLength /= pixelSize;
        int remainingRows = rows / pixelSize;

        int currentRowLength = rowLength;
        boolean isNewLine = true;
        int wordCount = 0;
        String word = null;

        while (wordCount < words.length) {
            word = words[wordCount];

            if (isNewLine) {
                currentRowLength -= word.length();
                wordCount++;
                isNewLine = false;
            } else {
                // +1 for whitespace
                if (word.length() + 1 <= currentRowLength) {
                    currentRowLength -= word.length() + 1;
                    wordCount++;
                } else {
                    remainingRows--;
                    currentRowLength = rowLength;
                    isNewLine = true;
                }

                if (remainingRows == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int longestStringLength(String[] words) {
        int maxLength = 0;

        for (String word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
        }
        return maxLength;
    }
}