package Week1;
import java.util.Scanner;
public class GirilenSayilardanMaxMin {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n;                    //girilecek sayı adedini alıyoruz
        System.out.print("Kaç adet sayı gireceksiniz : ");
        n=input.nextInt();

        if(n<=0)             // girilen sayı 0 veya negatifse uyarı veriyoruz.
        {
            System.out.println("0dan büyük bir sayı giriniz!");
        }else {

            int max = Integer.MIN_VALUE;         //2 adet degişken tanımlıyoruz max degere int in alabilecegi min değer
            int min = Integer.MAX_VALUE;         //min değere int in alabileceği max değer

            for (int i = 1; i <= n; i++) {         // örneğin 2 sayı girilecek 5 ve 1 burada ilk sayı yazıldıktan sonra
                System.out.print(i + ". Sayıyı giriniz : ");  // max ve min değere atanıyor daha sorasında diğer sayı
                int number = input.nextInt();                  //girildiğinde kontrol sağlanıp max veya min e atanıyor


                if (number > max) {
                    max = number;
                }
                if (number < min) {
                    min = number;
                }



            }
            System.out.println("En büyük sayı: " + max);
            System.out.println("En küçük sayı: " + min);

        }

        input.close();




    }

}
