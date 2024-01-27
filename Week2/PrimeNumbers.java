package Week2;
import java.util.Scanner;
public class PrimeNumbers {
    static boolean isPrime(int number,int divNumber){   //recursive metodumuzu yazıyoruz. eğer sonuç vermez ise sonuç verene kadar kendini çağıracak.
        if(number==divNumber){
            return true;
        }
        if (number%divNumber==0||number<=1){
            return false;
        }
        return isPrime(number,divNumber+1);
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Bir sayı giriniz : ");
        int number = input.nextInt();

        if(number<=1){
            System.out.println(number+" sayısı asal değildir.");
        }else{
            boolean prime = isPrime(number,2);          //eğer yukarıdaki metotda dönün işlem true ise asal
            if(prime){                                            //false ise asal değildir.
                System.out.println(number+" asaldır.");
            }else {
                System.out.println(number+" asal değildir.");
            }
        }

    }
}
