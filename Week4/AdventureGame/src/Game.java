package Week4.AdventureGame.src;
import java.util.Scanner;
public class Game {
    private Scanner input =new Scanner(System.in);
    public void start(){
        System.out.println("Macera oyununa hoşgeldiniz.");
        System.out.println("Oyunun amacı Mağara'dan yemeği, Orman'dan odunu ve Nehir'den suyu alıp güvenli eve dönebilmek. " +
                "\nGittiğin bölgede bulunan yaratıkları öldürerek altın kazanabilirsin. " +
                "\nBu altınlarla hasarını arttıracak silah ya da savunmanı arttıracak zırh alabilirsin." +
                "\nİstersen madendeki yılanları öldürerek silah, zırh ya da altın kazanabilirsin." +
                "\nBoşa konuşuyorum... Gidenler hiçbir zaman geri dönemedi." +
                "\nEee... Sen gitmeyi düşünmüyorsun değil mi ??" +
                "\nEn iyisi sana bir kahve ısmarlayayım ☕.. şey ismin ne demiştin ?");
        System.out.print("Lütfen bir isim giriniz : ");
        String playerName=input.nextLine();
        Player player = new Player(playerName);
        System.out.println(player.getName()+" Hoşgeldiniz ! ");
        player.selectChar();

        Location location=null;
        boolean isWin=false;
        while(true){
            player.playerInfo();
            System.out.println("Bölgeler:");
            Location[] locations= {new SafeHouse(player),new ToolStore(player),new Cave(player),new Forest(player),
                    new River(player),new Mine(player)};
            System.out.println("0\tÇıkış Yap");
            for (Location loc : locations ){
                System.out.println(+loc.getId()+"\tMekan adı: "+loc.getName());
            }
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz: ");
            int selectLoc=input.nextInt();
            switch (selectLoc){
                case 0:
                  location=null;
                  break;
                case 1:
                    location = new SafeHouse(player);
                    if(location.getPlayer().getInventory().getWater().equals("Water\uD83D\uDCA7")&&
                            location.getPlayer().getInventory().getFirewood().equals("Firewood\uD83E\uDDF1")&&
                            location.getPlayer().getInventory().getFood().equals("Food\uD83C\uDF56")){
                        isWin=true;
                    }
                    break;
                case 2:
                    location=new ToolStore(player);

                    break;
                case 3:
                    location=new Cave(player);
                    if(location.getPlayer().getInventory().getFood().equals("Food\uD83C\uDF56")){
                        System.out.println("Buradan daha önce ödül aldınız artık Mağarada canavar yok\uD83C\uDFC1");
                        continue;
                    }
                        break;

                case 4:
                    location = new Forest(player);
                    if(location.getPlayer().getInventory().getFirewood().equals("Firewood\uD83E\uDDF1")) {
                        System.out.println("Buradan daha önce ödül aldınız artık Mağarada canavar yok\uD83C\uDFC1");
                        continue;
                    }
                        break;

                case 5:
                    location = new River(player);
                    if(location.getPlayer().getInventory().getWater().equals("Water\uD83D\uDCA7")) {
                        System.out.println("Buradan daha önce ödül aldınız artık Mağarada canavar yok\uD83C\uDFC1");
                        continue;
                    }
                        break;
                case 6:

                    location=new Mine(player);
                    break;

                default:
                    location = new SafeHouse(player);
                    //System.out.println("Lütfen geçerli bir bölge giriniz");
            }
            if(isWin){
                System.out.println("TEBRİKLER OYUNU KAZANDINIZ.\uD83E\uDD47");
                location=null;
                break;
            }
            if(location==null){
                System.out.println("Oyun bitti");
                break;
            }
            if(!location.onLocation()){
                System.out.println("Öldünüz!\uD83D\uDC80");
                break;
            }
        }


    }

}
