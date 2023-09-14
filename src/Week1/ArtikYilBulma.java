package Week1;
import java.util.Scanner;

public class ArtikYilBulma {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int year;
        System.out.print("Yıl Giriniz: ");
        year=input.nextInt();  // kullanıcıdan yıl değerini alıyoruz

        if(year%100==0)                      //ilk koşulumuz yıl'ın 100 e bölünebilmesi
        {
            if(year%400==0) {                //eğer 100 e bölünüp aynı zamanda 400 e de bölünebiliyorsa artık yıldır.
                System.out.println(year + " bir artık yıldır.");
            }
            else                             // bölünemiyorsa artık yıl degildir.
            {
                System.out.println(year+" bir artık yıl değildir.");
            }
        }
        else if(year%4==0)                  //eğer yıl 400 ün katı degil ve 4 e bölünebiliyorsa artık yıldır.
        {
            System.out.println(year+" bir artık yıldır.");
        }
        else
        {
            System.out.println(year+" bir artık yıl değildir.");
        }

    }
}
