package Week4.AdventureGame.src;
public class ToolStore extends NormalLocation{
    public ToolStore(Player player) {
        super(player, "Eşya Dükkanı\uD83D\uDED2",2);
    }
    @Override
    public boolean onLocation(){
        System.out.println("Eşya Dükkanına hoşgeldiniz.");
        boolean showMenu=true;
        while(showMenu){
            System.out.println("1-Silahlar\uD83D\uDDE1");
            System.out.println("2-Zırhlar\uD83D\uDEE1\uFE0F");
            System.out.println("3-Çıkış Yap");
            System.out.print("Seçiminiz: ");
            int selectCase= input.nextInt();
            while(selectCase<1 || selectCase>3){
                System.out.print("Geçersiz değer tekrar giriniz: ");
                selectCase= input.nextInt();
            }
            switch (selectCase){
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Hoşçakalın.");
                    showMenu=false;
                   break;
            }
        }
        return true;
    }



    public void printWeapon(){
        System.out.println("Silahlar\uD83D\uDDE1");
        System.out.println("0-Çıkış Yap");
        for(Weapon w: Weapon.weapons()){
            System.out.println(w.getId()+"-"+w.getName()+" / Hasar "+w.getDamage()+" "+"- Para\uD83D\uDFE1 "+w.getPrice());
        }
        System.out.print("Seçiminiz: ");

    }
    public void buyWeapon(){
        int selectW=input.nextInt();
        while(selectW<0||selectW>Weapon.weapons().length){
            System.out.println("Geçersiz değer tekrar giriniz");
            selectW= input.nextInt();
        }
        if(selectW!=0){
            Weapon selectedWeapon=Weapon.getWeaponOnjByID(selectW);
            if(selectedWeapon!=null){
                if(selectedWeapon.getPrice()>this.getPlayer().getMoney()){
                    System.out.println("Altın yetmedi!!");
                }else{
                    System.out.println(selectedWeapon.getName()+" silahını satın aldınız.");
                    int balance = this.getPlayer().getMoney()-selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan para\uD83D\uDFE1 "+this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                }
            }
        }
    }
    public void printArmor(){
        System.out.println("Zırhlar\uD83D\uDEE1\uFE0F");
        System.out.println("0-Çıkış Yap");
        for(Armor a: Armor.armors()){
            System.out.println(a.getId()+"-"+a.getName()+" / Zırh Değeri : "+a.getBlock()+" "+"- Para\uD83D\uDFE1 "+a.getPrice());
        }
        System.out.print("Seçiminiz: ");
    }
    public void buyArmor(){
        int selectA=input.nextInt();
        while(selectA<0||selectA>Armor.armors().length){
            System.out.println("Geçersiz değer tekrar giriniz");
            selectA= input.nextInt();
        }
        if(selectA!=0){
            Armor selectedArmor=Armor.getArmorOnjByID(selectA);
            if(selectedArmor!=null){
                if(selectedArmor.getPrice()>this.getPlayer().getMoney()){
                    System.out.println("Altın yetmedi!!");
                }else{
                    System.out.println(selectedArmor.getName()+" zırh satın aldınız.");
                    int balance = this.getPlayer().getMoney()-selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan para\uD83D\uDFE1 "+this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                }
            }
        }
    }

}
