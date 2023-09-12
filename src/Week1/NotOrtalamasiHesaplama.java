package Week1;

import java.util.Scanner;

public class NotOrtalamasiHesaplama {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Değişkenleri tanımlıyoruz

        int mat,fizik,kimya,turkce,tarih,muzik;

        //Kullanıcıdan değerleri alıyoruz

        System.out.print("Matematik dersinden aldığınız notu giriniz: ");
        mat= input.nextInt();
        System.out.print("Fizik dersinden aldığınız notu giriniz: ");
        fizik= input.nextInt();
        System.out.print("Kimya dersinden aldığınız notu giriniz: ");
        kimya= input.nextInt();
        System.out.print("Türkçe dersinden aldığınız notu giriniz: ");
        turkce= input.nextInt();
        System.out.print("Tarih dersinden aldığınız notu giriniz: ");
        tarih= input.nextInt();
        System.out.print("Müzik dersinden aldığınız notu giriniz: ");
        muzik= input.nextInt();

        // Derslerin ortalamasını alıyoruz


        int toplamNot = mat+fizik+kimya+turkce+tarih+muzik;
        double ortalama= (double)toplamNot/6;

        //Öğrencinin not ortalaması 60 ın üzerindeyse sınıfı geçti değilse sınıfta kaldı yazdırıyoruz.
        System.out.println("Dönem ortalamanız : " + ortalama);
        String sonuc= (ortalama>60) ? "Sınıfı Geçti" : "Sınıfta Kaldı" ;
        System.out.println(sonuc);

    }
}