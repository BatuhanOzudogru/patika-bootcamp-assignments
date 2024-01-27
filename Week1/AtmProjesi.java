package Week1;

import java.util.Scanner;

public class AtmProjesi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userName,password;
        int rights=3;
        int select;
        int balance=1500;
        int price;

        while(rights>0) {
            System.out.print("Kullanıcı Adını Giriniz : ");
            userName= input.nextLine();
            System.out.print("Şifreyi Giriniz : ");
            password= input.nextLine();
            if (userName.equals("1") && password.equals("1")) {

                System.out.println("X Bankasına Hoşgeldiniz.");

                do {
                    System.out.println("Yapmak istediğiniz işlemi seçiniz.\n1-Para Çekme\n2-Para Yatırma\n3-Bakiye Sorgulama\n4-Çıkış Yap");
                    select=input.nextInt();
                    switch(select){
                        case 1:
                            System.out.print("Çekilecek para tutarını giriniz: ");
                            price=input.nextInt();
                            if (balance>price)
                            {
                                balance-=price;
                            }
                            else
                            {
                                System.out.println("Bakiye yetersiz lütfen tekrar deneyin.");
                            }
                            break;

                        case 2:
                            System.out.print("Yatırılacak para tutarını giriniz: ");
                            price=input.nextInt();
                            balance+=price;
                            break;

                        case 3:
                            System.out.println("Bakiyeniz : "+balance);
                            break;
                        default:
                            break;

                    }
                } while (select!=4);
                System.out.println("Görüşmek üzere.");
                break;
            }
            else {
                rights--;
                System.out.println("Kullanıcı Adı veya Şifre Yanlış. Tekrar deneyiniz.");
                System.out.println("Kalan Hak :"+rights);
                if(rights==0)
                {
                    System.out.println("Hesabınız bloke oldu. Lütfen banka ile iletişime geçin");
                }
            }
        }








    }
}
