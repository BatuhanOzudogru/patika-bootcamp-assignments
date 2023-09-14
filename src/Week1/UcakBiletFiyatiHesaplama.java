package Week1;
import java.util.Scanner;

public class UcakBiletFiyatiHesaplama {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        /*
        Kişi 12 yaşından küçükse bilet fiyatı üzerinden %50 indirim uygulanır.
        Kişi 12-24 yaşları arasında ise bilet fiyatı üzerinden %10 indirim uygulanır.
        Kişi 65 yaşından büyük ise bilet fiyatı üzerinden %30 indirim uygulanır.
        Kişi "Yolculuk Tipini" gidiş dönüş seçmiş ise bilet fiyatı üzerinden %20 indirim uygulanır.
        Kilometre başına ücret 0.10 Tl
        */


        //Değişkenleri tanımlıyoruz.

        int mesafe,yas,type;

        double kmUcreti= 0.1,normalTutar,indirimliTutar;

        /*İndirimleri burada belirtiyoruz.
        (Örneğin= Toplam fiyat 100 ve %20 lik bir indirim uygulanacak 100*0.8(%20)=80 gibi) */

        double yasIndirimi1=0.5,yasIndirimi2=0.9,yasIndirimi3=0.7,gidisDonusIndirimi=0.8;

        //Kullanıcıdan değerleri alıyoruz.

        System.out.print("Mesafeyi km türünden giriniz : ");
        mesafe=input.nextInt();
        System.out.print("Yaşınızı giriniz: ");
        yas=input.nextInt();
        System.out.println("Yolculuk tipini giriniz\n1-Tek Yön\n2-Gidiş Dönüş");
        type=input.nextInt();
        input.close();
        normalTutar=mesafe*kmUcreti;

        /*If else metoduyla koşullarımızı belirtip,
        eğer indirim sağlanacak koşul varsa indirimi uygulayıp kullanıcıya yansıtıyoruz.
        Koşul olarak ucuş tipi 1 ve mesafe pozitif / uçuş tipi 2 ve mesafe pozitif seçerek
        Kullanıcının Ucuş tipini 1ve 2 den farklı seçmesi veya mesafeye negatif girmesi durumunda
        hata almasını sağlıyoruz.*/

        if (type==1 && mesafe>0)
        {
            if((yas>=0) && (yas<12))
            {
                indirimliTutar=normalTutar*yasIndirimi1;
                System.out.println("Toplam Tutar : "+ indirimliTutar+" TL");
            }
            else if (yas<=24)
            {
                indirimliTutar=normalTutar*yasIndirimi2;
                System.out.println("Toplam Tutar : "+ indirimliTutar+" TL");
            }
            else if (yas>=65)
            {
                indirimliTutar=normalTutar*yasIndirimi3;
                System.out.println("Toplam Tutar : "+ indirimliTutar+" TL");
            }
            else
            {
                System.out.println("Toplam Tutar : "+ normalTutar+" TL");
            }

        }
        else if(type==2 && mesafe>0)
        {
            if((yas>=0) && (yas<12))
            {
                indirimliTutar=(normalTutar*yasIndirimi1*gidisDonusIndirimi)*2;
                System.out.println("Toplam Tutar : "+ indirimliTutar+" TL");
            }
            else if (yas<=24)
            {
                indirimliTutar=(normalTutar*yasIndirimi2*gidisDonusIndirimi)*2;
                System.out.println("Toplam Tutar : "+ indirimliTutar+" TL");
            }
            else if (yas>=65)
            {
                indirimliTutar=(normalTutar*yasIndirimi3*gidisDonusIndirimi)*2;
                System.out.println("Toplam Tutar : "+ indirimliTutar+" TL");
            }
            else
            {
                System.out.println("Toplam Tutar : "+ normalTutar*2+" TL");
            }
        }
        else{
            System.out.println("Hatalı Veri Girdiniz !");
        }
    }
}