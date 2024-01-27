package Week1;
import java.util.Scanner;
public class Fibonacci {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n ;
        System.out.print("Fibonaacci sayısı için eleman giriniz : ");
        n= input.nextInt();

        int numb1=0;
        int numb2=1;

        if (n >= 1) {
            System.out.print(numb1 + " ");
        }
        if (n >= 2) {
            System.out.print(numb2 + " ");
        }

        for (int i = 3; i <= n; i++) {
            int numbNext = numb1 + numb2;
            System.out.print(numbNext + " ");

            numb1 = numb2;
            numb2 = numbNext;
        }

    }
}
