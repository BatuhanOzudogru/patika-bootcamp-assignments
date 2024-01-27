package Week1;

import java.util.Scanner;

public class SayininBasamaklariToplami {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int k,sonBas,toplam=0;  //değişkenler
        System.out.print("Bir sayı giriniz: ");
        k=input.nextInt();

        while(k!=0) {    //kullanıcıdan aldığımız sayının her defasında 10 dan kalanını bulup toplama ekliyoruz.
            sonBas = k % 10;
            toplam = toplam + sonBas;
            k/=10;
        }
        System.out.println(toplam);
        input.close();
    }
}