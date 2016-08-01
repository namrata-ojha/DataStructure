package CountTheWordFromFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by namrataojha on 6/16/16.
 */
public class Count {
    public static void readFileAndPrintCounts(String crunchifyFile) throws FileNotFoundException {

        BufferedReader crunchifyBuffer = null;
        int crunchifyTotalWords = 0;
        int crunchifyTotalLines = 0;
        int crunchifyTotalCharacters = 0;

        String crunchifyLine;

        // Read file contents
        crunchifyBuffer = new BufferedReader(new FileReader(crunchifyFile));

        try {
            crunchifyLog("========== File Content ==========");

            // read each line one by one
            while ((crunchifyLine = crunchifyBuffer.readLine()) != null) {
                crunchifyLog(crunchifyLine);
                crunchifyTotalLines++;

                // ignore multiple white spaces
                String[] myWords = crunchifyLine.replaceAll("\\s+", " ").split(" ");

                for (String s : myWords) {
                    crunchifyTotalCharacters += s.length();
                }

                crunchifyTotalWords += myWords.length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        crunchifyLog("\n========== Result ==========");

        crunchifyLog("* Total Characters: " + crunchifyTotalCharacters);
        crunchifyLog("* Total Words: " + crunchifyTotalWords);
        crunchifyLog("* Total Lines: " + crunchifyTotalLines);
    }

    private static void crunchifyLog(String string) {
        System.out.println(string);
    }

    public static void main(String[] args) {
        try {
            String crunchifyFile = "/Users/<username>/Downloads/index.php";
            readFileAndPrintCounts(crunchifyFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
