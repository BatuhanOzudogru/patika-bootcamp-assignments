package Week6;

import java.io.*;

public class ReadFromFile {
    public static void main(String[] args) {
        try {
            // Array of strings representing numbers
            String[] numbers = {"5", "10", "20", "12", "33"};

            // Creating a new file named "numbers.txt"
            File newFile = new File("numbers.txt");

            // Writing the numbers from the array to the file
            FileWriter input = new FileWriter(newFile);
            BufferedWriter output = new BufferedWriter(input);

            // Loop through the numbers array and write each number followed by a newline to the file
            for (String str : numbers) {
                output.write(str + "\n");
            }

            // Closing the BufferedWriter after writing to the file
            output.close();

            // Reading from the file and calculating the sum of numbers
            FileReader reader = new FileReader(newFile);
            BufferedReader bufferedReader = new BufferedReader(reader);

            // Variable to store each line read from the file
            String line;

            // Variable to store the total sum of numbers
            int sum = 0;

            // Loop to read each line from the file and calculate the sum
            while ((line = bufferedReader.readLine()) != null) {
                // Parsing the line as an integer and adding it to the total sum
                int n = Integer.parseInt(line);
                sum += n;
            }

            // Printing the total sum of numbers
            System.out.println("Sum of numbers: " + sum);

            // Closing the BufferedReader
            bufferedReader.close();

        } catch (Exception e) {
            // Handling any exceptions that might occur during file operations or number parsing
            System.out.println("Error: " + e.getMessage());
        }

    }
}