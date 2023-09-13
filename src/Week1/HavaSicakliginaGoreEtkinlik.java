package Week1;

import java.util.Scanner;

public class HavaSicakliginaGoreEtkinlik {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        /*Koşullar :
        Sıcaklık 5'dan küçük ise "Kayak" yapmayı öner.
        Sıcaklık 5 ve 15 arasında ise "Sinema" etkinliğini öner.
        Sıcaklık 10 ve 25 arasında ise "Piknik" etkinliğini öner.
        Sıcaklık 25'ten büyük ise "Yüzme" etkinliğini öner. */

        int heat;

        // kullanıcıdan sıcaklık değerini alıyoruz

        System.out.print("Sıcaklık derecesini giriniz: ");
        heat=input.nextInt();

        //sıcaklık değerine göre aktivite öneriyoruz.

        if (heat<5)
        {
            System.out.println("Kayak yapabilirsiniz.");
        }
        else if (heat<10)
        {
            System.out.println("Sinemaya gidebilirsiniz.");
        }
        //bir önceki koşulda 10dan küçük değeri yazdıgımız için bir alt koşulda onu belirtmeye gerek yok
        else if (heat<=15)
        {
            System.out.println("Sinemaya veya pikniğe gidebilirsiniz.");
        }
        //bir önceki koşulda 15ten küçük eşit değeri yazdıgımız için bir alt koşulda onu belirtmeye gerek yok
        else if (heat<=25)
        {
            System.out.println("Pikniğe gidebilirsiniz.");
        }
        else{
            System.out.println("Yüzmeye gidebilirsiniz.");
        }
    }
}
