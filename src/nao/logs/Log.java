package nao.logs;

import java.io.File;  // Import the File class
import java.io.FileWriter;  // Import the FileWriter class
import java.io.FileNotFoundException;  // Import the FileNotFoundException for the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.nio.file.Paths;
import java.time.LocalDate; // Import the LocalDate class for the current date
import java.time.LocalDateTime;
import java.util.Scanner;   // Import the Scanner class for the ReadLog class
import java.util.ArrayList; // Import the ArrayList class to add and item to an array

public class Log {
    public static void newLog(String newText){
        try {
            String[] prevText;
            String path = Paths.get(".").toAbsolutePath().normalize().toString() + "\\src\\nao\\logs\\log_files";
            File log = new File(path + "\\" + LocalDate.now() + "_log.txt");
            if (log.createNewFile()) {
                System.out.println("File created: " + log.getName());
                prevText = new String[0];
            } else {
                System.out.println("File already exists.");
                prevText = readLog(log);
            }
            writeLog(log, prevText, newText);
        } catch (IOException e) {
            System.out.println("Could not create a file.");
            e.printStackTrace();
        }
    }

    public static String[] readLog(File file){
        try {
            ArrayList<String> list = new ArrayList<>();
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                list.add(data);
            }
            String[] array = list.toArray(new String[0]);
            myReader.close();
            return array;
        } catch (FileNotFoundException e) {
            System.out.println("Could not read file.");
            e.printStackTrace();
            return null;
        }
    }

    public static void writeLog(File file, String[] prevText, String newText){
        try {
            FileWriter myWriter = new FileWriter(file);
            for (int i = 0; i < prevText.length; i++) {
                myWriter.write(prevText[i] + "\n");
            }
            myWriter.write(LocalDateTime.now() + ": " + newText);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("Could not write file.");
            e.printStackTrace();
        }
    }

    public static void deleteLastLog(int amount){

    }

}
