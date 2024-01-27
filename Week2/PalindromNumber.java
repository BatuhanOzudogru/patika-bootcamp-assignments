package Week2;
import java.util.Scanner;
public class PalindromNumber {

    static String isPalindrom (int number){
        int temp=number,reverseNumber=0,lastNumber;
        while(temp!=0){
            lastNumber=temp%10;
            reverseNumber=(reverseNumber*10)+lastNumber;
            temp=temp/10;

        }
        if(reverseNumber==number){
            return number+" is a palindrom number.";
        }else{
            return number+" is not a palindrom number";
        }


    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Write a number : ");
        int n=input.nextInt();
        System.out.println(isPalindrom(n));
    }

}