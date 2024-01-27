package Week1;
import java.util.Scanner;

public class CinZodyagi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Değişkenleri belirliyoruz.

        int dogumYili,kalan;

        //Kullanıcıdan doğum yılını alıyoruz.

        System.out.print("Doğduğunuz yılı giriniz: ");
        dogumYili= input.nextInt();

        //Eğer doğum yılı 0 dan yüksekse switch-case yapısını kullanarak
        //girilmiş yılın 12 ye bölümünden kalan ile zodyak burcunu yansıtıyoruz

        if (dogumYili>=0)
        {
            kalan=dogumYili%12;
            switch (kalan)
            {
                case 0:
                    System.out.println("Çin Zonyağı Burcunuz: Maymun");
                    break;
                case 1:
                    System.out.println("Çin Zonyağı Burcunuz: Horoz");
                    break;
                case 2:
                    System.out.println("Çin Zonyağı Burcunuz: Köpek");
                    break;
                case 3:
                    System.out.println("Çin Zonyağı Burcunuz: Domuz");
                    break;
                case 4:
                    System.out.println("Çin Zonyağı Burcunuz: Fare");
                    break;
                case 5:
                    System.out.println("Çin Zonyağı Burcunuz: Öküz");
                    break;
                case 6:
                    System.out.println("Çin Zonyağı Burcunuz: Kaplan");
                    break;
                case 7:
                    System.out.println("Çin Zonyağı Burcunuz: Tavşan");
                    break;
                case 8:
                    System.out.println("Çin Zonyağı Burcunuz: Ejderha");
                    break;
                case 9:
                    System.out.println("Çin Zonyağı Burcunuz: Yılan");
                    break;
                case 10:
                    System.out.println("Çin Zonyağı Burcunuz: At");
                    break;
                default:
                    System.out.println("Çin Zonyağı Burcunuz: Koyun");
                    break;
            }
        }
        else
        {
            System.out.println("Yıl negatif olamaz !");

        }
    }
}
