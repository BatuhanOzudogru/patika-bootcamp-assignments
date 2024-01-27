package Week1;

import java.util.Scanner;

public class UcveDordeTamBolunme {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int k,sum=0,sayac=0;   //degişkenler
        double ort;
        System.out.print("Sayı giriniz: ");
        k=input.nextInt();

        for(int i=0; i<=k; i++){   //her 3ve4 e tam bölünen sayı için sayaç 1 artacak ve toplam sayı sayaça bölünecek.
            if(i%3==0 && i%4==0){
                sum+=i;
                sayac++;

            }
        }

        ort=(double) sum/sayac;
        System.out.println("3 ve 4'e tam bölünen sayıların ortalaması: " + ort);
    }
}
