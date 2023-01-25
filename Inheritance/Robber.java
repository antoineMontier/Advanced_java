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

    public void kidnap(Woman victim){
        victim.kidnap();
        talk("I kidnapped you " + victim.getName());
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

}