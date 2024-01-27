package Week1;
import java.util.Scanner;

public class CiftveDordunKatiToplam {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        //Java döngüler ile tek bir sayı girilene kadar kullanıcıdan girişleri
        // kabul eden ve girilen değerlerden çift ve 4'ün katları olan sayıları toplayıp ekrana basan programı yazıyoruz.


        int k,total=0;  //değişkenler
        System.out.println("Çift ve 4'ün katı olan sayıları toplama programı");

        do {          //do while döngüsüyle kullanıcı tek sayı girene kadar programı sürdürüyoruz.
            System.out.print("Bir sayı giriniz: ");
            k= input.nextInt();
            if(k%2==0 && k%4==0)        //buradaki if komutuyla çift ve 4'ün katı olan sayıları topluyoruz.
            {
                total+=k;
            }
        }while(k%2==0);

        System.out.println("Toplam değer: "+total);   //toplam değeri kullanıcıya gösteriyoruz

    }
}
