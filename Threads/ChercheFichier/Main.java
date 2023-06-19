package Threads.ChercheFichier;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        String res = trouve_fichier("/home", "Main.java", 8);

        System.out.println("\n\nres = \n" + res + "");

    }

    public static String trouve_fichier( String chemin_repertoire, String fichier_a_trouver, int nb_threads )
    {
        Chercheur fs = new Chercheur(new File(chemin_repertoire), new File(fichier_a_trouver));
        fs.setNombreThread(nb_threads);
        Thread t = new Thread(fs);
        t.start();
        try{
            t.join();
        }catch(Exception e){e.printStackTrace();}
        return fs.getCheminRes();

    }

}