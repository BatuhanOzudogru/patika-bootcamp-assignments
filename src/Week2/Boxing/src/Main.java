public class Main {
    public static void main(String[] args) {
        Fighter f1 =new Fighter("Boxer 1",10,85,85,10);
        Fighter f2 =new Fighter("Boxer 2",10,85,125,10);

        Ring ringA=new Ring(130,80,f1,f2);
        ringA.start();
    }
}