package Week2;
import java.util.Scanner;
public class Calculator {
    static void sum (int a,int b)
    {
        int result = a+b;
        System.out.println("Toplam : "+ result);
    }
    static void minus (int a,int b)
    {
        int result=a-b;
        System.out.println("Çıkarma : " + result);
    }
    static void multi(int a,int b)
    {
        int result=a*b;
        System.out.println("Çarpım : "+result);
    }
    static void division(int a,int b)
    {
        if (b==0){
            System.out.println("İkinci sayı 0 olamaz");
        }else{
            double result=(double) a/(double)b;
            System.out.println("Bölme : " + result);
        }
    }
    static void expo(int a,int b)
    {
        int result=1;
        for(int i =1; i<=b; i++){
            result*=a;
        }
        System.out.println("Üs alma : "+result);
    }
    static void mod (int a,int b)
    {
        int result=a%b;
        System.out.println("Mod işlemi : "+result);
    }

    static void rect(int a , int b)
    {
        int alan=a*b;
        int cevre=2*(a+b);
        System.out.println("Dikdörtgen alan : "+alan);
        System.out.println("Dikdörtgen çevre : "+cevre);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String menu = "1-Toplama\n2-Çıkarma\n3-Çarpma\n4-Bölme\n5-Üs Alma\n6-Mod Alma" +
                "\n7-Dikdörtgen Alan ve Çevre\n8-Çıkış Yap\n";
        int secim;
        System.out.print(menu);
        do {
            System.out.print("Seçiminizi yapınız : ");
            secim = input.nextInt();

            System.out.print("İlk sayıyı giriniz : ");
            int a = input.nextInt();
            System.out.print("İkinci sayıyı giriniz : ");
            int b = input.nextInt();
            switch (secim) {
                case 1:
                    sum(a, b);
                    break;
                case 2:
                    minus(a, b);
                    break;
                case 3:
                    multi(a, b);
                    break;
                case 4:
                    division(a, b);
                    break;
                case 5:
                    expo(a, b);
                    break;
                case 6:
                    mod(a, b);
                    break;
                case 7:
                    rect(a, b);
                    break;
                default:
                    System.out.println("Yanlış bir değer girdiniz.");


            }



        }while (secim != 8) ;

        System.out.println("Güle güle");
    }
}
