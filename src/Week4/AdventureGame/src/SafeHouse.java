package Week4.AdventureGame.src;
public class SafeHouse extends NormalLocation{
    public SafeHouse(Player player) {
        super(player, "Güvenli Ev\uD83C\uDFDA\uFE0F",1);
    }
    @Override
     public boolean onLocation(){
        System.out.println("Güvenli evdesiniz \n Canınız yenilendi.\uD83E\uDE78");
        this.getPlayer().setHealth(this.getPlayer().getOrjinalHealth());
        return true;
    }
}
