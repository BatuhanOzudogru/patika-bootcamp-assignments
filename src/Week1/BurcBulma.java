package Week1;
import java.util.Scanner;

public class BurcBulma {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Değişkenleri tanımlayıp kullanıcıdan değerleri alıyoruz.
        int month,day;
        boolean isError = false;
        String burc="";

        System.out.print("Doğduğunuz ay 1-12 : ");
        month=input.nextInt();
        System.out.print("Doğdugunuz gün : ");
        day=input.nextInt();
        input.close();

        //Doğduğu aya ve güne göre if else bloklarıyla burcunu belirleyip kullanıcıya yansıtıyoruz.

        //Koç Burcu. 21 Mart- 20 Nisan.
        //Boğa Burcu. 21 Nisan – 20 Mayıs.
        //İkizler Burcu. 21 Mayıs – 21 Haziran.
        //Yengeç Burcu. 22 Haziran – 22 Temmuz.
        //Aslan Burcu. 23 Temmuz – 23 Ağustos.
        //Başak Burcu. 24 Ağustos – 23 Eylül.
        //Terazi Burcu. 24 Eylül – 23 Ekim.
        //Akrep Burcu. 24 Ekim – 22 Kasım.
        //Yay Burcu. 23 Kasım - 21 Aralık.
        //Kova Burcu. 21 Ocak - 19 Şubat.
        //Balık Burcu. 20 Şubat - 20 Mart.
        if (month==1)
        {
            if(day>=1 && day<=31)
            {
                if(day<21)
                {
                    burc="Oğlak";
                }
                else
                {
                    burc="Kova";
                }
            }
            else{
                isError=true;

            }

        }
        else if (month==2)
        {
            if(day>=1 && day<=28)
            {
                if(day<20)
                {
                    burc="Kova";
                }
                else
                {
                    burc="Balık";
                }
            }
            else{
                isError=true;

            }

        }
        else if (month==3)
        {
            if(day>=1 && day<=31)
            {
                if(day<21)
                {
                    burc="Balık";
                }
                else
                {
                    burc="Koç";
                }
            }
            else{
                isError=true;

            }

        }
        else if (month==4)
        {
            if(day>=1 && day<=30)
            {
                if(day<21)
                {
                    burc="Koç";
                }
                else
                {
                    burc="Boğa";
                }
            }
            else{
                isError=true;

            }

        }
        else if (month==5)
        {
            if(day>=1 && day<=31)
            {
                if(day<21)
                {
                    burc="Boğa";
                }
                else
                {
                    burc="İkizler";
                }
            }
            else{
                isError=true;

            }

        }
        else if (month==6)
        {
            if(day>=1 && day<=30)
            {
                if(day<22)
                {
                    burc="İkizler";
                }
                else
                {
                    burc="Yengeç";
                }
            }
            else{
                isError=true;

            }

        }
        else if (month==7)
        {
            if(day>=1 && day<=31)
            {
                if(day<23)
                {
                    burc="Yengeç";
                }
                else
                {
                    burc="Aslan";
                }
            }
            else{
                isError=true;

            }

        }
        else if (month==8)
        {
            if(day>=1 && day<=31)
            {
                if(day<24)
                {
                    burc="Aslan";
                }
                else
                {
                    burc="Başak";
                }
            }
            else{
                isError=true;

            }

        }
        else if (month==9)
        {
            if(day>=1 && day<=30)
            {
                if(day<24)
                {
                    burc="Başak";
                }
                else
                {
                    burc="Terazi";
                }
            }
            else{
                isError=true;

            }

        }
        else if (month==10)
        {
            if(day>=1 && day<=31)
            {
                if(day<24)
                {
                    burc="Terazi";
                }
                else
                {
                    burc="Akrep";
                }
            }
            else{
                isError=true;

            }

        }
        else if (month==11)
        {
            if(day>=1 && day<=30)
            {
                if(day<23)
                {
                    burc="Akrep";
                }
                else
                {
                    burc="Yay";
                }
            }
            else{
                isError=true;

            }

        }
        else if (month==12)
        {
            if(day>=1 && day<=31)
            {
                if(day<22)
                {
                    burc="Yay";
                }
                else
                {
                    burc="Oğlak";
                }
            }
            else{
                isError=true;

            }

        }

        if (isError){
            System.out.println("Hatalı giriş yaptınız tekrar deneyiniz.");
        }
        else {
            System.out.println("Burcunuz : " + burc);
        }





    }
}