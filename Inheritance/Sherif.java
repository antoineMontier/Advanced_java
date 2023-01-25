package Inheritance;

class Sherif extends Cowboy {

    int robber_arrested;

    public Sherif(String name, String fav_drink){
        super(name, fav_drink);
        robber_arrested = 0;
        setAdjective("Honest");
    }


    public Sherif(String name){
        super(name);
        robber_arrested = 0;
        setAdjective("Honest");
    }

    public void arrestRobber(Robber prisonner){
        talk("I arrest you !");
        prisonner.toJail(this);
        robber_arrested++;
    }

    public int getArrested(){return robber_arrested;}

    public void searchFor(Robber toJail){
        talk("Looking for " + toJail.getName() + " reward of " + toJail.getReward() + " !");
    }

    @Override
    public String getName(){
        return "Sherif " + super.getName();
    }

}