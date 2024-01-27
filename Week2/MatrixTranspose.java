package Week2;

public class MatrixTranspose {
    public static void main(String[] args) {
        int[][] matrisA ={                   // transpose {1,4}
                {1,2,3},                     //           {2,5}
                {4,5,6}                      //           {3,6}
        };

        int[][] matrisB=new int [matrisA[0].length][matrisA.length];

        System.out.println("Matrix : ");

        for (int i=0;i< matrisA.length;i++){
            for(int j=0;j<matrisA[i].length;j++){
                System.out.print(matrisA[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Transpoze : ");
        for (int i=0;i< matrisB.length;i++){
            for(int j=0;j< matrisA.length;j++){
                matrisB[i][j]=matrisA[j][i];
                System.out.print(matrisB[i][j]+" ");
            }
            System.out.println();
        }

    }
}

