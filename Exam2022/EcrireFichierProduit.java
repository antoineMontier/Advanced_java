package Exam2022;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EcrireFichierProduit {
    
    private File fichier;
    private ArrayList<Produit> products;

    public EcrireFichierProduit(String file){
        fichier = new File(file);
        products = new ArrayList<>();
    }

    public void loadInMemory(Produit p){
        products.add(p);
    }

    public void saveInMemory(){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(fichier));
            for(int i = 0 ; i < products.size() ; ++i) {bw.append(products.get(i).toCSV()); bw.newLine();}
            bw.flush();
            bw.close();
        }catch(IOException e){e.printStackTrace();}
    }
    
}
