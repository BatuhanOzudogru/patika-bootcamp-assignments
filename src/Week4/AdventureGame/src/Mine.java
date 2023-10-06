package Week4.AdventureGame.src;
import java.util.Random;
public class Mine extends BattleLocation {
    public Mine(Player player) {
        super(player, "Maden\uD83D\uDC8E", 6, new Viper(), "random", 5);
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("Şuan buradasınız: " + this.getName());
        System.out.println("Dikkatli ol ! Burada " + obsNumber + " tane " + this.getObstacle().getName() + " yaşıyor!");
        System.out.print("<S>avaş⚔\uFE0F veya <K>aç\uD83C\uDFC3  : ");
        String selectCase = input.nextLine().toUpperCase();
        if (selectCase.equals("S") && combat(obsNumber)) {
            System.out.println(this.getName() + " tüm düşmanları yendiniz.");


            return true;
        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("ÖLDÜNÜZ");
            return false;
        }
        return true;
    }

    public int randomViperDmg() {
        Random randomDmg = new Random();
        int a = randomDmg.nextInt(4) + 3;
        return a;
    }
    @Override
    public void obstacleStats(int i){
        System.out.println(i+"."+this.getObstacle().getName()+ "değerleri");

        System.out.println("Sağlık❤\uFE0F: " + this.getObstacle().getHealth());
        System.out.println("Hasar\uD83D\uDCA5: 3-6" );
        System.out.println("Ödül: Bilinmiyor");
        System.out.println();
    }
    @Override
    public boolean combat(int obsNumber) {
        for (int i = 1; i <= obsNumber; i++) {

            this.getObstacle().setHealth(this.getObstacle().getOrjinalHealth());
            playerStats();
            obstacleStats(i);
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.print("<V>ur\uD83E\uDD4A veya <K>aç\uD83C\uDFC3 :");
                int viperDmg = this.getObstacle().getDamage() + randomViperDmg();
                String selectCombat = input.nextLine().toUpperCase();
                if (selectCombat.equals("V")) {
                    if(coinFlip()){
                        System.out.println("Siz vurdunuz");
                        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();
                        if (this.getObstacle().getHealth() > 0) {
                            System.out.println();
                            System.out.println("Canavar size vurdu !");
                            int obstacleDamage = viperDmg - this.getPlayer().getInventory().getArmor().getBlock();
                            if (obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            afterHit();
                        }
                    }else{
                        if (this.getObstacle().getHealth() > 0) {
                            System.out.println();
                            System.out.println("Canavar size vurdu !");
                            int obstacleDamage = viperDmg - this.getPlayer().getInventory().getArmor().getBlock();
                            if (obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            afterHit();
                        }
                        System.out.println("Siz vurdunuz");
                        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();
                    }

                } else {
                    return false;
                }
            }
            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("düşmanı yendiniz");
                randomPrize();

            } else {
                return false;
            }
        }
        return true;
    }

    public void randomPrize() {
        int randomF = (int) ((Math.random()) * 100);
        int randomS = (int) ((Math.random()) * 100);

        if (randomF > 0 && randomF < 16) {
            if (randomS > 0 && randomS < 21) {             //tüfek
                System.out.println("Tüfek kazandınız");
                getPlayer().getInventory().setWeapon(Weapon.getWeaponOnjByID(3));
            } else if (randomS > 20 && randomS < 51) {             //kılıç
                if (getPlayer().getInventory().getWeapon().getId() > 2) {
                    System.out.println("Kılıç kazandınız fakat sizde daha iyisi var.");
                } else {
                    System.out.println("Kılıç kazandınız !");
                    getPlayer().getInventory().setWeapon(Weapon.getWeaponOnjByID(2));
                }
            } else {            //tabanca
                if (getPlayer().getInventory().getWeapon().getId() > 1) {
                    System.out.println("Tabanca kazandınız fakat sizde daha iyisi var.");
                } else {
                    System.out.println("Tabanca kazandınız");
                    getPlayer().getInventory().setWeapon(Weapon.getWeaponOnjByID(1));
                }
            }

        } else if (randomF > 15 && randomF < 31) {//zırh
            if (randomS > 0 && randomS < 21) {           //agır
                System.out.println("Ağır zırh kazandınız");
                getPlayer().getInventory().setArmor(Armor.getArmorOnjByID(3));
            } else if (randomS > 20 && randomS < 51) {
                //orta
                if (getPlayer().getInventory().getArmor().getId() > 2) {
                    System.out.println("Orta zırh kazandınız fakat sizde daha iyisi var.");
                } else {
                    System.out.println("Orta zırh kazandınız");
                    getPlayer().getInventory().setArmor(Armor.getArmorOnjByID(2));
                }
            } else {//hafif
                if (getPlayer().getInventory().getArmor().getId() > 1) {
                    System.out.println("Hafif zırh kazandınız fakat sizde daha iyisi var.");
                } else {
                    System.out.println("Hafif zırh kazandınız");
                    getPlayer().getInventory().setArmor(Armor.getArmorOnjByID(1));
                }
            }
        } else if (randomF > 30 && randomF < 56) {  //para
            if (randomS > 0 && randomS < 21) {
                System.out.println("10 altın kazandınız");  //10g
                getPlayer().setMoney(getPlayer().getMoney() + 10);
                System.out.println("Toplam altın : " + this.getPlayer().getMoney());
            } else if (randomS > 20 && randomS < 51) {
                System.out.println("5 altın kazandınız"); //5g
                getPlayer().setMoney(getPlayer().getMoney() + 5);
                System.out.println("Toplam altın : " + this.getPlayer().getMoney());
            } else {
                System.out.println("1 altın kazandınız"); //1g
                getPlayer().setMoney(getPlayer().getMoney() + 1);
                System.out.println("Toplam altın : " + this.getPlayer().getMoney());
            }
        } else {
            System.out.println("Bu yılanın içinde bir şey yok !");
        }


    }
}
