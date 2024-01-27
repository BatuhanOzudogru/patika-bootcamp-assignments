package Week5;

import java.util.HashMap;
import java.util.Scanner;


public class ModeWord {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your text : ");
        String metin = input.nextLine();
        String[] words = metin.toLowerCase().split(" ");

        HashMap<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }

        int maxValue = 0;
        for(int count : wordCount.values()){
            if(count>maxValue){
                maxValue=count;
            }
        }
        System.out.println("Most frequenct word(s)");
        for(String key : wordCount.keySet()){
            if(wordCount.get(key)==maxValue){
                System.out.print(key+" ");
            }
        }



        System.out.println("Count "+ maxValue);




    }
}
