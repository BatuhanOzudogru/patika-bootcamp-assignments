package Week1;
import java.util.Scanner;

public class SinifGecmeDurumu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Değişkenleri tanımlıyoruz

        int mat,fizik,turkce,kimya,muzik,toplamDers=0;
        double notOrt;

        //Kullanıcıdan değerleri alıyoruz

        System.out.print("Matematik dersinden aldığınız notu giriniz: ");
        mat= input.nextInt();
        System.out.print("Fizik dersinden aldığınız notu giriniz: ");
        fizik= input.nextInt();
        System.out.print("Türkçe dersinden aldığınız notu giriniz: ");
        turkce= input.nextInt();
        System.out.print("Kimya dersinden aldığınız notu giriniz: ");
        kimya= input.nextInt();
        System.out.print("Müzik dersinden aldığınız notu giriniz: ");
        muzik= input.nextInt();

        /* Değerleri 0-100 arasında girilen dersleri toplamDers sayısını arttırarak
           sisteme dahil ediyoruz. Değilse dersin notunu 0 a çekiyoruz.*/


        if (0<=mat && mat<=100)
        {
            toplamDers ++;

        }
        else
        {
            mat=0;
            System.out.println("Matematik notunuzu yanlış girdiniz.Ortalamaya dahil edilmedi.");
        }
        if (0<=fizik && fizik<=100)
        {
            toplamDers ++;

        }
        else
        {
            fizik=0;
            System.out.println("Fizik notunuzu yanlış girdiniz.Ortalamaya dahil edilmedi.");
        }
        if (0<=turkce && turkce<=100)
        {
            toplamDers ++;

        }
        else
        {
            turkce=0;
            System.out.println("Türkçe notunuzu yanlış girdiniz.Ortalamaya dahil edilmedi.");
        }
        if (0<=kimya && kimya<=100)
        {
            toplamDers ++;

        }
        else
        {
            kimya=0;
            System.out.println("Kimya notunuzu yanlış girdiniz.Ortalamaya dahil edilmedi.");
        }
        if (0<=muzik && muzik<=100)
        {
            toplamDers ++;

        }
        else
        {
            muzik=0;
            System.out.println("Müzik notunuzu yanlış girdiniz.Ortalamaya dahil edilmedi.");
        }

        // Notları toplayıp sisteme dahil olan ders sayısına bölüyoruz

        notOrt=(mat+kimya+turkce+muzik+fizik)/(double)toplamDers;

        //Öğrenciye ortalaması 55 ve yukarısıysa geçtiğini değilse kaldığını belirtiyoruz.

        if (notOrt>=55)
        {
            System.out.println("Tebrikler sınıfı geçtiniz. Ortalamanız : "+notOrt);
        }
        else
        {
            System.out.println("Sınıfta kaldınız,seneye tekrar görüşmek üzere. Ortalamanız: "+notOrt);
        }



    }
}
