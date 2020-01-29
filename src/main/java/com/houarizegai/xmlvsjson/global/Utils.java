package com.houarizegai.xmlvsjson.global;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Utils {
    public static int getNumberOfLinesInFile(String filePath) {
        int lines = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            while (reader.readLine() != null) lines++;
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    public static String readStringFromFile(String pathName) {
        return readStringFromFile(new File(pathName));
    }

    public static String readStringFromFile(File file) { // Read file and convert it to String
        try {
            StringBuilder fileContents = new StringBuilder((int) file.length());

            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    fileContents.append(scanner.nextLine() + System.lineSeparator());
                }
                return fileContents.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
