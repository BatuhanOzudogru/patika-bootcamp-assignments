package Week4.AdventureGame.src;
public class Weapon {
    String name;
    int id;
    int damage;
    int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getId(){
        return id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Weapon(String name, int damage, int price,int id) {
        this.id=id;
        this.name = name;
        this.damage = damage;
        this.price = price;
    }
    public static Weapon[] weapons(){
        Weapon[] weaponList =new Weapon[3];
        weaponList[0]= new Weapon("Tabanca\uD83D\uDD2B",2,20,1);
        weaponList[1]= new Weapon("Kılıç\uD83D\uDDE1\uFE0F",3,35,2);
        weaponList[2]= new Weapon("Tüfek\uD83D\uDE80",7,45,3);
        return weaponList;
    }
    public static Weapon getWeaponOnjByID(int id){
        Weapon weapon =null;
        for(Weapon w : Weapon.weapons()){
            if(w.getId()==id){
                return w;
            }
        }
        return null;
    }


}
