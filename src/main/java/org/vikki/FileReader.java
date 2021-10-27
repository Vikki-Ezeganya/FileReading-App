package org.vikki;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class FileReader {
    private HashMap map;

    public FileReader(HashMap map) {
        this.map = map;
    }

    public void readFromFile(String nameOfFile) {

        File file = new File(nameOfFile);
        String line = null;
        Scanner scanner = null;
        String application="";
        int num = 0;
        try {
            scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();


                if (line.isEmpty()) application = "";

                else {

                    if (line.startsWith("[") && line.endsWith("]")) {
                        String word = removeSquareBracketsAroundWord(line);
                        num += 1;
                        application = word+ num +".";
                    }

                    else{

                    String[] splittedLine = line.split("=");
                    this.map.put(application+splittedLine[0], splittedLine[1]);
                    }

                }

            }
            System.out.println(map);
        } catch (FileNotFoundException e) {
            System.out.println("Oops!...");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    public String removeSquareBracketsAroundWord(String wordInBrackets) {
        return wordInBrackets.substring(1, wordInBrackets.length() - 1);
    }

}
