package Week2;
import java.util.Scanner;
public class Exponentiation {
    static int usAlma(int a,int b)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Taban değeri giriniz : ");
        a=input.nextInt();
        System.out.print("Üs değerini giriniz : ");
        b= input.nextInt();

        int result=1;

        if(a!=0 ){

            for(int i=1;i<=b;i++)
            {
                result*=a;
            }
            System.out.println("Üs sonuç: " +result);
            return usAlma(a,b);
        }else if (b!=0) {
            int sifirUssuX = 1;
            System.out.println("Üs sonuç: " +sifirUssuX);
            return usAlma(a,b);
        }
        else{System.out.println("BELİRSİZ");}

        return 0;

    }
    public static void main(String[] args) {

        int a=0,b=0;
        usAlma(a,b);
    }
}
