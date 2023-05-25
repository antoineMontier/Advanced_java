package Exam2022;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LireFichierProduit {
    
    private File fichier;
    private ArrayList<Produit> produits;
    
    public LireFichierProduit(String fichier_nom) {
        fichier = new File(fichier_nom);
        produits = new ArrayList<Produit>();
    }

    public boolean lire(){
        if(!fichier.exists() || fichier.isDirectory()) return false;
        try{
            BufferedReader br = new BufferedReader(new FileReader(fichier));
            String line;
            while((line = br.readLine()) != null){
                String[] infos = line.split(";");
                produits.add(new Produit(infos[0], Double.parseDouble(infos[1]), Double.parseDouble(infos[2])));
            }
            br.close();
        }catch(IOException e){e.printStackTrace(); return false;}
        return true;
    }

    public ArrayList<Produit> getListeProduits(){ return produits; }
}
