package Week1;
import java.util.Scanner;
public class TersUcgen {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n;
        System.out.print("Basamak sayısını giriniz: ");  //basamak sayısını kullanıcıdan alıyoruz.
        n=input.nextInt();

        for(int i=1;i<=n;i++){

            for(int b=1;b<=(i-1);b++){   //her basamak için boşluk sayımız i den 1 eksik oluyor.
                System.out.print(" ");
            }
            for (int y=1;y<=(((n-i)*2)+1);y++){  // her basamak için yıldız degerimiz ((n-i)*2)+1 kadar oluyor.
                System.out.print("*");
            }
            System.out.println();
        }

    }
}