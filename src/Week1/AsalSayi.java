package Week1;

public class AsalSayi {
    public static void main(String[] args) {

        for(int i =2 ;i<=100; i++){    //1 asal olmadıgı için for döngüsü 2 den başlıyor.
            boolean checkAsal = true;  // öncelikle her sayıya asal değeri için doğru döndürüyoruz.
            for(int k=2; k<i;k++)
            {
                if(i%k==0){          //eğer bir sayı kendinden ve 2 den başka bir sayıya bölünüyorsa onu cıkartıyoruz.
                    checkAsal=false;
                }
            }
            if(checkAsal){   //kalanları ekrana bastırıyoruz.
                System.out.print(i+" ");
            }

        }
    }
}
