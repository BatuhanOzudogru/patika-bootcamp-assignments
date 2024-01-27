package Week1;
import java.util.Scanner;
public class HarmonikSayi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n;             //kullanıcıdan değeri alıyoruz.
        System.out.print("Bir sayı giriniz: ");
        n=input.nextInt();
        double result=0;

        for(double i = 1;i<=n;i++)   //harmonik sayı formulü (1/1 + 1/2 + 1/3 + ... + 1/n)
        {
            result=result+(1/i);
        }
        System.out.println("Harmonik değer: "+result);
        input.close();

    }
}
