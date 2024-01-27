package Week1;
import java.util.Scanner;
public class MukemmelSayi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Bir sayının kendisi hariç pozitif tam sayı çarpanları (kalansız bölen sayıların) toplamı kendisine eşit olan sayıya mükemmel sayı denir.
        int n,toplam=0;  //değişkenler
        System.out.print("Bir sayı giriniz: ");
        n=input.nextInt();

        for(int i=1;i<n;i++){        //burada for döngüsüyle sayının KENDİNDEN KÜÇÜK çarpanlarını topluyoruz.
            if(n%i==0){
                toplam=toplam+i;
            }
        }
        if(toplam==n){             //eğer topladığımız sayı kendisine eşitse bu sayı mükemmel sayıdır.
            System.out.println(n+" Mükemmel Sayıdır !");
        }else{
            System.out.println(n+" Mükemmel sayı değildir.");
        }

    }
}
