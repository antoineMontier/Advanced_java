package Inheritance;

public class Robber extends Human {

    String look;
    int women_captured;
    double reward_of_capture;
    boolean jail;

    public Robber(String name, String fav_drink, double reward) {
        super(name, fav_drink);
        look = "Naughty";
        reward_of_capture = reward;
        jail = false;
        women_captured = 0;
    }

    public Robber(String name, double reward) {
        super(name, "Tord-boyaux");
        look = "Naughty";
        reward_of_capture = reward;
        jail = false;
        women_captured = 0;
    }

    public void kidnap(Woman victim){
        victim.kidnapBy(this);
        talk("I kidnapped you " + victim.getName());
        women_captured++;
    }

    public void toJail(Cowboy hero){
        if(jail)
            return;
        jail = true;
        talk(hero.getName() + " you got me in jail ");
    }

    public double getReward(){
        return reward_of_capture;
    }

    @Override
    public String getName(){
        return (super.getName() + " the " + look);
    }

    @Override 
    public void presentation(){
        super.presentation();
        talk("I'm "+ look + " and I've already captured "  +  women_captured + " women !");
        talk("The reward for my head is "+reward_of_capture);
    }

}