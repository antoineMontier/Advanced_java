package Exam2022;

public class Produit {
    
    private String nom;
    private double prixHT, tva;

    public Produit(String nom, double prixHT, double tva){
        this.nom = nom;
        this.prixHT = prixHT;
        this.tva = tva;
    }

    public String toString(){return nom + " " + prixHT + "€ " + tva  + "%";}
    public String toCSV(){return nom + ";" + prixHT + ";" + tva;}

    public String getNom(){return nom;}
    public double getPrixHT(){return prixHT;}
    public double getTVA(){return tva;}
    public double getPrixTTC(){return prixHT*(1+tva/100);}

    public void setNom(String nom){this.nom = nom;}
    public void setPrixHT(double prixHT){this.prixHT = prixHT;}
    public void setTVA(double tva){this.tva = tva;}
}
