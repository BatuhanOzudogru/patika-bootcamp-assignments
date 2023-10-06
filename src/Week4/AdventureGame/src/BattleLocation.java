import java.util.Random;

public abstract class BattleLocation extends Location {

    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLocation(Player player, String name, int id, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name, id);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;


    }
    public boolean coinFlip(){
        double randomValue = Math.random() * 100;
        if (randomValue>50){
            return true;
        }
        return false;
    }
    @Override
    public boolean onLocation() {
        int obsNumber=this.randomObstacleNumber();
        System.out.println("Şuan buradasınız: " + this.getName());
        System.out.println("Dikkatli ol ! Burada " + obsNumber+" tane "+this.getObstacle().getName() + " yaşıyor!");
        System.out.print("<S>avaş⚔\uFE0F veya <K>aç\uD83C\uDFC3  : ");
        String selectCase=input.nextLine().toUpperCase();
        if(selectCase.equals("S")&&combat(obsNumber)){
            System.out.println(this.getName()+" tüm düşmanları yendiniz.");
            System.out.println(this.award+" aldınız artık burada canavar yok");
            switch (getId()){
                case 3:
                    this.getPlayer().getInventory().setFood(this.award);
                    break;
                case 4:
                    this.getPlayer().getInventory().setFirewood(this.award);
                    break;
                case 5:
                    this.getPlayer().getInventory().setWater(this.award);
                    break;
            }
            return true;
        }
        if(this.getPlayer().getHealth()<=0){
            System.out.println("ÖLDÜNÜZ");
            return false;
        }
        return true;
    }


    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public boolean combat(int obsNumber){
        for(int i=1;i<=obsNumber;i++){
            this.getObstacle().setHealth(this.getObstacle().getOrjinalHealth());
            playerStats();
            obstacleStats(i);
            while(this.getPlayer().getHealth()>0&&this.getObstacle().getHealth()>0){
                System.out.print("<V>ur\uD83E\uDD4A veya <K>aç\uD83C\uDFC3 :");
                String selectCombat=input.nextLine().toUpperCase();
                if(selectCombat.equals("V")){
                    if(coinFlip()){
                        System.out.println("Siz vurdunuz");
                        this.getObstacle().setHealth(this.obstacle.getHealth()-this.getPlayer().getTotalDamage());
                        afterHit();
                        if(this.getObstacle().getHealth()>0){
                            System.out.println();
                            System.out.println("Canavar size vurdu !");
                            int obstacleDamage=this.getObstacle().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();
                            if(obstacleDamage<0){
                                obstacleDamage=0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth()-obstacleDamage);
                            afterHit();
                        }
                    }else{
                        if(this.getObstacle().getHealth()>0){
                            System.out.println();
                            System.out.println("Canavar size vurdu !");
                            int obstacleDamage=this.getObstacle().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();
                            if(obstacleDamage<0){
                                obstacleDamage=0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth()-obstacleDamage);
                            afterHit();
                        }
                        System.out.println("Siz vurdunuz");
                        this.getObstacle().setHealth(this.obstacle.getHealth()-this.getPlayer().getTotalDamage());
                        afterHit();
                    }

                }else{
                    return false;
                }
            }
            if(this.getObstacle().getHealth()<this.getPlayer().getHealth()){
                System.out.println("düşmanı yendiniz");
                System.out.println(this.getObstacle().getAward()+" para kazandınız");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
                System.out.println("Güncel paranız: "+this.getPlayer().getMoney());
            }else{
                return false;
            }
        }
        return true;
    }



    public void playerStats(){
        System.out.println("Oyuncu Değerleri");
        System.out.println("-----------------");
        System.out.println("Sağlık❤\uFE0F: " + this.getPlayer().getHealth());
        System.out.println("Silah⚔\uFE0F: "+this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Hasar\uD83D\uDCA5: "+this.getPlayer().getTotalDamage());
        System.out.println("Zırh\uD83D\uDEE1\uFE0F: "+this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Hasar Azaltma\uD83D\uDD30: "+this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Para\uD83D\uDFE1 : "+this.getPlayer().getMoney());
        System.out.println();
    }
    public void afterHit(){
        System.out.println("Canınız❤\uFE0F: "+this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName()+" canı : "+ this.getObstacle().getHealth());
        System.out.println("******************");
    }

    public void obstacleStats(int i){
        System.out.println(i+"."+this.getObstacle().getName()+ "değerleri");
        System.out.println("//////////////////////");
        System.out.println("Sağlık❤\uFE0F: " + this.getObstacle().getHealth());
        System.out.println("Hasar\uD83D\uDCA5: " + this.getObstacle().getDamage());
        System.out.println("Ödül\uD83D\uDFE1: " + this.getObstacle().getAward());
        System.out.println();
    }




    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}
