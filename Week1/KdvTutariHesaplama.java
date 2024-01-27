package Week1;

import java.util.Scanner;
public class KdvTutariHesaplama {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double anaPara,kdvliTutar,kdvTutari,kdvOrani;
        System.out.print("Lütfen ana parayı giriniz: ");
        anaPara =input.nextInt();

        kdvOrani=(anaPara<1001)  ? 0.18 : 0.08;


        kdvliTutar = (anaPara*kdvOrani)+anaPara;
        kdvTutari = anaPara*kdvOrani;
        System.out.println("Ana paranız: " + anaPara +"\nKdvli tutar: " + kdvliTutar  +"\nKDV Tutarı: " + kdvTutari );


    }
}