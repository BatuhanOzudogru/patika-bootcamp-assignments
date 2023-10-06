package Week4.AdventureGame.src;
import java.util.Scanner;
public abstract class Location {
    public static Scanner input=new Scanner(System.in);
    private Player player;
    private String name;

    public int getId() {
        return id;
    }
    private int id;


    public Location(Player player,String name,int id){
        this.player=player;
        this.name=name;
        this.id=id;

    }

    public Player getPlayer(){
        return player;
    }
    public void setPlayer(Player player){
        this.player=player;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }



    public abstract boolean onLocation();
}
