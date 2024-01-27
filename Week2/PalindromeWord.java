package Week2;
import java.util.Scanner;
public class PalindromeWord {
    public static String isPalindrome(String str){
        String reverse="";
        for(int i=0,j=str.length()-1;i<str.length();i++,j--){  //This for loop is used to iterate through the characters of the input string.
            reverse += str.charAt(j);                          // It starts with two pointers, i at the beginning (index 0) and j at the end
        }                                                      //(index str.length() - 1). It continues until i is less than the length of the string.
        if(reverse.equals(str)){
            return str+" is a palindrome word";
        }
        return str+" is not a palindrome word";

    }

    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.print("Please enter a word : ");
        String word = input.nextLine();
        System.out.println(isPalindrome(word));
    }
}

