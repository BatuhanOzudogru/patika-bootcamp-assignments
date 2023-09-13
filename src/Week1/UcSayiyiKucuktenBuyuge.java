package Week1;

import java.util.Scanner;

public class UcSayiyiKucuktenBuyuge {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Değişkenleri tanımlayıp kullanıcıdan değerleri alıyoruz.
        int a,b,c;

        System.out.print("İlk sayıyı giriniz: ");
        a= input.nextInt();
        System.out.print("İkinci sayıyı giriniz: ");
        b=input.nextInt();
        System.out.print("Üçüncü sayıyı giriniz:");
        c=input.nextInt();

        /* if koşuluyla her bir sayının en
         büyük olduğu 3 farklı duruma göre koşulları yazıp kullanıcıya yansıtıyoruz.*/
        if ((a>b)&&(a>c))
        {
            if (b>c)
            {
                System.out.println(c+"<"+b+"<"+a);
            }
            else
            {
                System.out.println(b+"<"+c+"<"+a);
            }
        }
        if((b>a)&&(b>c))
        {
            if (a>c)
            {
                System.out.println(c+"<"+a+"<"+b);
            }
            else
            {
                System.out.println(a+"<"+c+"<"+b);
            }
        }
        if((c>a)&&(c>b))
        {
            if (a>b)
            {
                System.out.println(b+"<"+a+"<"+c);
            }
            else
            {
                System.out.println(a+"<"+b+"<"+c);
            }
        }
    }
}