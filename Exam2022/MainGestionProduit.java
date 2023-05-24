package Exam2022;
import java.util.ArrayList;
import java.util.Iterator;


public class MainGestionProduit {
    private ArrayList<Produit> produits;

    public MainGestionProduit(){produits=null;}

    public void lireStock(String file){
        LireFichierProduit liseur = new LireFichierProduit(file);
        liseur.lire();
        produits = liseur.getListeProduits();
    }

    public double prixMoyenFOR(){
        if(produits == null || produits.size() == 0) return 0;
        double sum = 0;
        for(Produit p : produits) sum += p.getPrixTTC();
        return sum / produits.size();
    }

    public double prixMoyenIT(){
        if(produits == null || produits.size() == 0) return 0;
        double sum = 0;
        Iterator<Produit> it = produits.iterator();
        while(it.hasNext()) sum += it.next().getPrixTTC();
        return sum / (double)produits.size();
    }

    public double prixMoyenSTREAM(){
        if(produits == null || produits.size() == 0) return 0;
        return produits
                .stream()
                .mapToDouble(p -> p.getPrixTTC())
                .average()
                .orElse(0.0);
    }

    public void afficheListe(double taxe, double max_prixTTC){
        if(produits == null || produits.size() == 0) System.out.println("[-]");
        produits.stream()
                .filter(p -> (p.getPrixTTC() <= max_prixTTC))
                .filter(p -> (p.getTVA() == taxe))
                .forEach(System.out::println);
    }


}
