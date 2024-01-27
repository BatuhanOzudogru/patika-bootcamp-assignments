package Week2;
import java.util.Arrays;
import java.util.Scanner;
public class NumberSorter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many numbers will you enter ? : "); //This line displays a prompt asking the user to enter the number of integers they want to input.
        int n = input.nextInt();
        int[] array= new int[n];
        for (int i = 1; i<=n;i++){   //This loop iterates from 1 to n, prompting the user to enter each integer and storing it in the array at the corresponding index (subtracting 1 from i because arrays in Java are 0-indexed).
            System.out.print(i+". Number = ");
            int number = input.nextInt();
            array[i-1]=number;

        }
        Arrays.sort(array);  //This line sorts the array in ascending order using the Arrays.sort method.
        System.out.println(Arrays.toString(array));
    }
}