package Week1;
import java.util.Scanner;
public class HesapMakinesi {
    public static void main(String[] args) {
        int a,b,islem;
        Scanner input = new Scanner(System.in);

        System.out.print("İlk sayıyı giriniz: ");
        a = input.nextInt();
        System.out.print("İkinci sayıyı giriniz: ");
        b =input.nextInt();

        System.out.println("İşlemi seçiniz : \n1-Toplama\n2-Çıkarma\n3-Çarpma\n4-Bölme");
        islem=input.nextInt();
        switch (islem){
            case 1:
                System.out.println("Toplama işlemi sonucu = "+ (a+b));
                break;
            case 2:
                System.out.println("Çıkarma işlemi sonucu = "+ (a-b));
                break;
            case 3:
                System.out.println("Çarpma işlemi sonucu = "+ (a*b));
                break;
            case 4:
                switch(b){
                    case 0:
                        System.out.println("Bir sayı 0'a bölünemez, tekrar deneyiniz.");
                        break;
                    default:
                        System.out.println("Bölme işlemi sonucu = "+ (a/b));
                }
                break;
            default:
                System.out.println("Yanlış seçim yaptınız, tekrar deneyiniz.");

                break;
        }



    }
}