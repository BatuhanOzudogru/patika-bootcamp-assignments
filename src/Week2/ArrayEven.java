package Week2;
public class ArrayEven {
    static boolean isHas(int[] arr, int value){
        for(int i : arr) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] list = {3,5,2,4,5,6,9,6,3,10,2,2,3,4};
        int[] duplicateEven = new int [list.length];
        int startIndex = 0;
        for (int i =0;i<list.length;i++){
            for(int j=0;j<list.length;j++){
                if(list[i]%2==0){
                    if((i!=j) && (list[i]==list[j])){
                        if(!isHas(duplicateEven,list[j])) {
                            duplicateEven[startIndex++] = list[i];

                        }
                        break;
                    }
                }

            }
        }
        for (int i : duplicateEven){
            if(i!=0){
                System.out.print(i+" ");
            }
        }
    }
}


