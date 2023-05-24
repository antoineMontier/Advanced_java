package Exam2022;

public class Main {
    public static void main(String[] args){
        MainGestionProduit mgp = new MainGestionProduit();
        mgp.lireStock("Exam2022/Stock.csv");

        System.out.println("prix moyen FOR = " + mgp.prixMoyenFOR());
        System.out.println("prix moyen IT  = " + mgp.prixMoyenIT());
        mgp.afficheListe(5.5, 100);
    }
}
