package Week2;

import java.util.Scanner;
import java.util.Arrays;
public class NumberGuessGame {
    public static void main(String[] args) {
        int number = (int)(Math.random()*100);
        Scanner input=new Scanner(System.in);
        System.out.println("Welcome to the number guessing game");
        int right=0;
        boolean isInvalid = false;
        boolean isWin=false;
        int[] wrongGuesses=new int[5];
        while(right<5){
            System.out.print("Please enter your guess between 0-100: ");
            int guess=input.nextInt();
            if(0>guess||guess>100){
                System.out.println("Incorrect Number !");
                if(isInvalid){
                    right++;
                    System.out.println("You entered too many incorrect numbers. Remaining rights = "+(5-right));
                }else{
                    System.out.println("If you enter incorrect guess again,you will lose your rights. ");
                    isInvalid=true;
                }
                continue;
            }
            if(number==guess){
                System.out.println("Congratulations ! You win !");
                break;
            }else if (guess>number){
                wrongGuesses[right]=guess;
                right++;
                System.out.println("Your guess is greater than the secret number " +(5-right)+" rights remaining..");
            }else{
                wrongGuesses[right]=guess;
                right++;
                System.out.println("Your guess is less than the secret number " +(5-right)+" rights remaining..");
            }
        }
        input.close();
        if(!isWin){
            System.out.println("GAME OVER !");
            System.out.println("Secret Number is = "+number);
            if(!isInvalid){
                System.out.println("Your guesses : " + Arrays.toString(wrongGuesses));
            }
        }



    }
}
