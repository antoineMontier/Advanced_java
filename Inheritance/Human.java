package Inheritance;

public class Human {
    
    private String name;

    private String fav_drink;

    public Human(String new_name, String new_fav_drink){
        name = new_name;
        fav_drink = new_fav_drink;
    }

    public String getName(){
        return name;
    }

    public String getDrink(){
        return fav_drink;
    }

    public Human(String new_name){
        name = new_name;
        fav_drink = "water";
    }

    public void talk(String text){
        System.out.println("(" + getName() + ") : " + text);
    }

    public void presentation(){
        talk("Hey, my name is " + getName() + " and I like " + fav_drink + " !");
    }

    public void drink(){
        talk("A big glass of " + fav_drink + " ! ");
    }
}
