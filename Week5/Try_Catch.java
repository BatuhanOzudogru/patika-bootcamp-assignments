package Week5;

import java.util.Scanner;

public class Try_Catch {
    public static void printIndex(int[]arr,int selectIndex) throws  ArrayIndexOutOfBoundsException{
        if(selectIndex>arr.length-1||selectIndex<0){
            throw new ArrayIndexOutOfBoundsException("Hatalı indis numarası girdiniz. İndis numarası 0-9 arasında olmalıdır");
        }
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
            System.out.println(e.getMessage());
            System.out.println("Error : Dizi sınırlarının dışına çıkıldı");
        }
        System.out.println("Program bitti..");


    }
}
