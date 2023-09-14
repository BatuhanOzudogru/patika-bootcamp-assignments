package Week1;
import java.util.Scanner;
public class DortveBesinKuvvetleri {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Java döngüler ile girilen sayıya kadar olan 4 ve 5'in kuvvetlerini ekrana yazdıran programı yazıyoruz.

        int k;

        System.out.print("Sayı giriniz: ");
        k=input.nextInt();
        for (int i =1;i<k;i=i*4)
        {
            System.out.println("Dörtün Kuvvetleri : "+i);
        }
        for (int i =1;i<k;i=i*5)
        {
            System.out.println("Beşin Kuvvetleri : "+i);
        }
    }
}
