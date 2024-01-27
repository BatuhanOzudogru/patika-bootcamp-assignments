package Week1;
import java.util.Scanner;
public class KullaniciGirisi {
    public static void main(String[] args) {
        String userName,password,newPassword;
        int secim;
        Scanner input = new Scanner(System.in);

        System.out.print("Kullanıcı adını giriniz: ");
        userName=input.nextLine();
        System.out.print("Şifrenizi giriniz: ");
        password=input.nextLine();

        if(userName.equals("patika"))
        {
            if(password.equals("java123"))
            {
                System.out.println("Giriş başarılı!");
            }
            else{
                System.out.println("Şifreniz yanlış! Şifreyi sıfırlamak ister misiniz? \n1-Evet\n2-Hayır");
                secim=input.nextInt();
                input.nextLine();
                if (secim==1)
                {
                    System.out.print("Yeni şifrenizi giriniz: ");
                    newPassword=input.nextLine();

                    if (newPassword.equals("java123"))
                    {
                        System.out.println("Yeni şifre eskisiyle aynı olamaz.Tekrar deneyiniz.");
                    }
                    else
                    {
                        System.out.println("Şifre oluşturuldu.");
                    }

                }
                else if (secim==2)
                {
                    System.out.println("Giriş bilgilerinizi tekrar deneyiniz.");
                }
                else
                {
                    System.out.println("Seçiminiz hatalı lütfen tekrar deneyiniz.");
                }
            }
        }
        else
        {
            System.out.println("Böyle bir kullanıcı adı bulunamadı!");
        }





    }
}

