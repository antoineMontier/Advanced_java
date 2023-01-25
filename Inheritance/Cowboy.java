package Inheritance;

public class Cowboy extends Human {

    int popularity;
    String adjective;

    public Cowboy(String name, String fav_drink){
        super(name, fav_drink);
        popularity = 0;
        adjective = "brave";
    }

    public Cowboy(String name){
        super(name, "whisky");
        popularity = 0;
        adjective = "brave";
    }

    public void shot(Robber victim){
        System.out.println("the " + adjective + " " + getName() + " shoot " + victim.getName() + " !");
        talk("I shoot you !");
    }

    public void free(Woman toFree){
        talk(toFree.getName() + ", I free you !");
        toFree.free(this);
        popularity++;
    }

    @Override
    public String getName(){
        return (super.getName());
    }



}