package Week2;
import java.util.Arrays;
import java.util.Scanner;
public class ArrayMaxMin {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] list = {15,12,788,1,-1,-778,2,0};
        System.out.println("Array : "+ Arrays.toString(list));
        System.out.print("Enter a number : ");
        int n = input.nextInt();
        Arrays.sort(list);
        int min = list[0];
        int max = list[0];
        int nearestGreater=0,nearestSmaller=0;
            for (int i=0;i<list.length;i++){
                if(list[i]<n){
                    nearestSmaller=list[i];
                }
                if(list[i]>n){
                    nearestGreater=list[i];
                    break;
                }
            }
        System.out.println("Nearest number smaller than the entered number : "+nearestGreater);
        System.out.println("Nearest number greater than the entered number : "+nearestSmaller);
        }
}



