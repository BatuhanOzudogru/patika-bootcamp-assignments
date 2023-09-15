package Week1;

import java.util.Scanner;

public class EbobEkok {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n1,n2;
        int ebob=1;                 //degişkenleri tanımlıyoruz.

        System.out.print("n1 sayısını giriniz : ");
        n1= input.nextInt();
        System.out.print("n2 sayısını giriniz : ");
        n2= input.nextInt();



        int i =1;
        while(i<=n1 && i<=n2)           //while döngüsüyle eğer n1 ve n2 i den küçük ise işleme koyuyoruz.
                                        // böylelikle büyük sayı küçük sayı yazma önceliği ortadan kalıyor
        {
            if (n1%i==0 && n2%i==0)
            {
                ebob=i;

            }
            i++;

        }
        int ekok= (n1*n2)/ebob;
        System.out.println("Sayıların en küçük ortak katı : "+ekok);
        System.out.println("Sayıların en böyük ortak böleni : "+ebob);






    }
}
