package Inheritance;

public class Woman extends Human {

    private String color;

    private Boolean free;

    public Woman(String name, String fav_drink, String dress_color, Boolean freee){
        super(name, fav_drink);
        color = dress_color;
        free = freee;
    }

    public void kidnapBy(Robber r){
        if(!free)
            return;
        free = false;
        talk("AAAAAhhh " + r.getName() + " you kidnapped me :( ");
    }

    public void free(Cowboy saver){
        if(free)
            return;
        free = true;
        talk("Thank you " + saver.getName() + " !");
    }

    public void changeDress(String new_color){
        color = new_color;
        talk("Hey look at my new "+color+" dress !");
    }

}