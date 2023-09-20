package Week2.Boxing.src;

public class Ring {
    int maxWeight;
    int minWeight;

    Fighter fighter1;
    Fighter fighter2;

    Ring(int maxWeight,int minWeight,Fighter fighter1, Fighter fighter2){
        this.maxWeight=maxWeight;
        this.minWeight=minWeight;
        this.fighter1=fighter1;
        this.fighter2=fighter2;
    }

    public boolean isCheck(){
        return (((this.fighter1.weight>=this.minWeight)&&(this.fighter1.weight<=this.maxWeight))&&((this.fighter2.weight>=this.minWeight)&&(this.fighter2.weight<=this.maxWeight)));
    }
    public void start(){
        if(isCheck()){
            System.out.println(this.fighter1.name+" (DMG:"+(this.fighter1.damage)+"/HP"+this.fighter1.health+"/Dodge"+this.fighter1.dodge+")"+" VS "+this.fighter2.name+" (DMG:"+(this.fighter2.damage)+"/HP"+this.fighter2.health+"/Dodge"+this.fighter2.dodge+")");
            if(coinFlip()) {
                while (fighter1.health > 0 && fighter2.health > 0) {
                    fighter2.health = fighter1.hit(fighter2);
                    if (isWin()) {
                        break;
                    }
                    fighter1.health = fighter2.hit(fighter1);
                    if (isWin()) {
                        break;
                    }
                    roundScore();
                }
            } else {
                while(fighter1.health>0&&fighter2.health>0){
                fighter1.health=fighter2.hit(fighter1);
                if(isWin()){
                    break;
                }
                fighter2.health=fighter1.hit(fighter2);
                if(isWin()){
                    break;
                }
                roundScore();
            }

            }


        }else {
            System.out.println("The weight category of the 2 players do not match");
        }
    }
    public boolean isWin(){
        if(fighter1.health==0){
            System.out.println("Winner is : "+fighter2.name);
            return true;
        }
        if(fighter2.health==0){
            System.out.println("Winner is : "+fighter1.name);
            return true;
        }
        return false;
    }
    public void roundScore(){
        System.out.println("**"+fighter1.name+" HP: "+fighter1.health+" - "+fighter2.name+" HP: "+fighter2.health+"**");
    }
    public boolean coinFlip(){
        double randomValue = Math.random() * 100;
        if (randomValue>50){
            return true;
        }
        return false;
    }


}
