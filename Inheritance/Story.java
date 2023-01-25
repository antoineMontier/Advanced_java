package Inheritance;

public class Story {
    public static void main(String[] args){
        Cowboy luc = new Cowboy("LuckyLuc", "orange");
        Robber don = new Robber("Don", "Vodka", 150.0);
        Woman lila = new Woman("Lila", "sirop", "Violet", true);
        Barman john = new Barman("John");
        Sherif nicolas = new Sherif("Nicolas", "peach sirop");
        nicolas.presentation();
        john.serve(nicolas);

    }
}
