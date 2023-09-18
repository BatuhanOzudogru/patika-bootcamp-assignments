package Week2;
import java.util.Scanner;
public class DesenMethod  {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Sayıyı giriniz: ");
        int n= input.nextInt(); // Kullanıcıdan alınan değer
        System.out.println("N Sayısı : "+n);
        System.out.print("Çıktısı : ");
        desenMetot(n);
    }

    public static void desenMetot(int n) {
        System.out.print(n+" ");

        if (n <= 0) {
        return;
        } else {
            desenMetot(n - 5);
            System.out.print(n+" ");
        }
    }
}