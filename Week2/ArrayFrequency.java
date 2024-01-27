package Week2;

public class ArrayFrequency {

        public static void main(String[] args) {
        int[] list = {10, 20, 20, 10, 10, 20, 5, 20};

        int[] repeats=new int[list.length];

        for(int i=0;i<list.length;i++){
            int element = list[i];
            boolean isRepeated = false;
            for(int j=0;j<i;j++){
                if(list[j]==element){
                    isRepeated = true;
                    break;
                }
            }
            if(!isRepeated){
                int repeatedNumber=1;
                for(int j=i+1;j< list.length;j++){
                    if(list[j]==element){
                        repeatedNumber++;
                    }
                }
                repeats[i]=repeatedNumber;
            }
        }
        for (int i = 0; i < list.length; i++) {
            if (repeats[i] > 0) {
                System.out.println(list[i] + " sayısı " + repeats[i] + " kere tekrar edildi.");
            }
        }
    }

}

