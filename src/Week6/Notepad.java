package Week6;

import java.io.*;
import java.util.Scanner;

public class Notepad {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Ask the user to write a note and store it in the 'note' variable
        System.out.print("Please write your note:");
        String note = scanner.nextLine();

        // Define the file name where the notes will be stored
        String fileName = "notes.txt";

        try {
            // Open the file in append mode to add new notes without overwriting existing content
            FileWriter fileWriter = new FileWriter(fileName, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Write the user's note to the file and close the PrintWriter
            printWriter.println(note);
            printWriter.close();

            // Open the file in read mode to display the stored notes
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Read the first line of the file (assuming there is only one line in the file)
            String readNotes = bufferedReader.readLine();

            // Close the BufferedReader after reading
            bufferedReader.close();
        } catch (IOException e) {
            // Handle any IOException that might occur during file operations
            // and throw a RuntimeException with the original exception for debugging purposes
            throw new RuntimeException(e);
        }
    }
}
