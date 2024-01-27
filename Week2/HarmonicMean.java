package Week2;

public class HarmonicMean {
    public static void main(String[] args) {
        int[] list = {5,4,7,65,32,1566};
        double harmonic = 0;
        for(int i =0;i<list.length;i++){

            harmonic+=1/(double)list[i];
        }
        System.out.println("Harmonic value; "+harmonic);
        System.out.println("Harmonic mean; " +(list.length/harmonic));

    }
}

