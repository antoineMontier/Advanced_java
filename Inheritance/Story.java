package Inheritance;

public class Story {
    public static void main(String[] args){
        Cowboy luc = new Cowboy("LuckyLuc", "orange");
        Robber don = new Robber("Don", "Vodka", 150.0);
        Woman lila = new Woman("Lila", "sirop", "Violet", true);
        don.kidnap(lila);
        don.presentation();
        lila.presentation();
        lila.changeDress("pink");
        don.drink();
        luc.presentation();
        luc.shot(don);
        luc.free(lila);

    }
}
