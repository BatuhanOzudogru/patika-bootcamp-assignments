package Week4.AdventureGame.src;
import java.util.Scanner;
public class Player {
    private Inventory inventory;
    private int damage;
    private int health;
    private int block;
    private int money;
    private String name;
    private String charName;
    private int orjinalHealth;
    public String getCharName() {
        return charName;
    }

    private Scanner input =new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory=new Inventory();
        this.block=0;
    }

    public void selectChar(){
        GameChar[] charList = {new Samurai(),new Archer(),new Knight()};
        System.out.println("-----------------------Karakterler-----------------------");
        for(GameChar gameChar: charList){
            System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
            System.out.println("ID : "+gameChar.getId()+
                    " \t Karakter: "+gameChar.getName()+
                    " \t Hasar:\uD83C\uDFAF "+gameChar.getDamage()+
                    " \t Sağlık:❤\uFE0F "+gameChar.getHealth()+
                    " \t Para:\uD83D\uDFE1 "+gameChar.getMoney());
        }
        System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
        System.out.print("Bir karakter seçin: ");
        int selectChar=input.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
    }

    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOrjinalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }
    public void playerInfo(){
        System.out.println("Silahınız⚔\uFE0F : "+this.getInventory().getWeapon().getName()+
                " / Zırhınız\uD83D\uDEE1\uFE0F : "+this.getInventory().getArmor().getName()+
                " / Hasar Azaltmanız\uD83D\uDD30 : "+this.getBlock()+
                " / Hasarınız\uD83D\uDCA5 : "+this.getTotalDamage()+
                " / Sağlığınız❤\uFE0F : "+this.getHealth()+
                " / Paranız \uD83D\uDFE1: "+this.getMoney());
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getTotalDamage(){
        return damage+this.getInventory().getWeapon().getDamage();
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getBlock() {
        return block+this.getInventory().getArmor().getBlock();
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if(health<0){
            health=0;
        }
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
