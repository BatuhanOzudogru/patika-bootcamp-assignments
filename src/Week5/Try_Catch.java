package Week5;

import java.util.Scanner;

public class Try_Catch {
    public static void printIndex(int[]arr,int selectIndex){

        System.out.println(arr[selectIndex]);
    }

    public static void main(String[] args) {

        int[] arr={10,20,30,40,50,60,70,80,90,100};
        System.out.print("{10,20,30,40,50,60,70,80,90,100}\nDizinin kaçıncı indis numarasını yazdırmak istiyorsunuz : ");
        Scanner input =new Scanner(System.in);
        int selectIndex=input.nextInt();

        try{
           printIndex(arr,selectIndex);
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println("Hatalı indis numarası girdiniz. İndis numarası 0-9 arasında olmalıdır");
        }
        System.out.println("Program bitti..");


    }
}
