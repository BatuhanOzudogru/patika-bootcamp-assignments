package Week1;

import java.util.Scanner;

public class KombinasyonHesaplama {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //C(n,r) = n! / (r! * (n-r)!)
        int n,r,totalN=1,totalR=1,totalNR=1;    //değişkenlerimizi tanımlıyoruz

        System.out.print("Eleman sayısını giriniz (n) : ");
        n=input.nextInt();
        System.out.print("Seçim sayısını giriniz (r) : ");
        r=input.nextInt();

        for(int i=1;i<=n;i++)        // n değeri, r değeri ve n-r degeri için faktoriyel hesaplamaları yapıyoruz.
        {
            totalN=totalN*i;
        }
        for(int i=1;i<=r;i++)
        {
            totalR=totalR*i;
        }
        for(int i=1;i<=(n-r);i++)
        {
            totalNR=totalNR*i;
        }

        int sonuc = (totalN)/((totalR)*(totalNR)); // formülde yerine koyup ekrana bastırıyoruz

        System.out.println("C("+n+","+r+") = "+sonuc);
        input.close();
    }
}