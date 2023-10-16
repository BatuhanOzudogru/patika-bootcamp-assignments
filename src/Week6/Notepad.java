package Week6;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Notepad {
    public static void main(String[] args) {
        // Define the file name where the notes will be stored
        String fileName = "src/Week6/notes.txt";

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Create an ArrayList to store previously written notes
        ArrayList<String> previousNotes = new ArrayList<>();

        try {
            // Open the file in read mode or create the file if it doesn't exist
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("File created: " + fileName);
            }
            System.out.println("Type 'exit' to quit the program.");
            System.out.println("Type 'clear' to clear the file.\n");

            while (true) {
                // Open the file in read mode
                FileReader fileReader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                // Read and store previously written notes
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    previousNotes.add(line);
                }

                // Close the BufferedReader after reading
                bufferedReader.close();

                // Print previously written notes
                System.out.println("Previously written notes:");
                for (String note : previousNotes) {
                    System.out.println(note);
                }

                // Ask the user to write a new note
                System.out.println("Please write your new note:");
                String note = scanner.nextLine();

                // Check if the user wants to exit the program
                if (note.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting notepad. Goodbye!");
                    break; // Exit the loop if the user enters 'exit'
                }
                if (note.equalsIgnoreCase("clear")) {
                    FileWriter fileWriter = new FileWriter(fileName, false);
                    PrintWriter printWriter = new PrintWriter(fileWriter);
                    //printWriter.println("");
                    printWriter.close();
                    continue;
                }
                // Open the file in append mode to add new notes without overwriting existing content
                FileWriter fileWriter = new FileWriter(fileName, true);
                PrintWriter printWriter = new PrintWriter(fileWriter);

                // Write the user's note to the file and close the PrintWriter
                printWriter.println(note);
                printWriter.close();

                // Inform the user that the note has been saved
                System.out.println("Note saved successfully!\n");

                // Clear the ArrayList for the next iteration
                previousNotes.clear();
            }
        } catch (IOException e) {
            // Handle any IOException that might occur during file operations
            // Print an error message and terminate the program
            System.out.println("Error: " + e.getMessage());
        }
    }
}