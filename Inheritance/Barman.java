package Inheritance;

public class Barman extends Human {
    
    String bar_name;

    public Barman(String Name, String fav_drink, String bar){
        super(Name, fav_drink);
        bar_name = bar;
    }

    public Barman(String Name, String fav_drink){
        super(Name, fav_drink);
        bar_name = Name + "'s Bar";
    }

    public Barman(String Name){
        super(Name, "Wine");
        bar_name = Name + "'s Bar";
    }

    @Override
    public void talk(String mesString){
        super.talk(mesString + " Coco");
    }

    @Override
    public void presentation(){
        talk("I'm " + getName() + " my bar is " + bar_name);
    }

    public void serve(Human customer){
        talk("Here is some " + customer.getDrink() + " for you " + customer.getName() + " !");
    }

}
