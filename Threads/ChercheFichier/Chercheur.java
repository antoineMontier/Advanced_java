package Threads.ChercheFichier;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Chercheur implements java.lang.Runnable{
	
	private File 		repertoire_courant;
	private File 		fichier_recherche;
	private static int 	nombre_threads;
	private String		chemin;

	public Chercheur ( File dir, File a_trouver )
	{
		repertoire_courant 	= dir;
		fichier_recherche  	= a_trouver;
		chemin 				= "";
	}

	public void setNombreThread( int n )
	{
		if ( n < 0 ) return;
		nombre_threads = n;
	}

	public String getCheminRes()
	{
		return chemin;
	}



	public void run () 
	{
		if ( !repertoire_courant.isDirectory()) System.out.println ( repertoire_courant + " n'est pas un repertoire");

		List<Thread>    threads_lances 		= new ArrayList<>();
		List<Chercheur> fichiers_threads 	= new ArrayList<>();
		List<Chercheur> fichiers_recursion 	= new ArrayList<>();

		File[] tab_fichiers = repertoire_courant.listFiles();

		if ( tab_fichiers == null )
		{
			System.out.println("erreur dans le listage des fichiers du repertoire " + repertoire_courant + "\n\n");
			return;
		}
		for ( int i = 0; i < tab_fichiers.length; i++ ) 
		{

			if ( tab_fichiers[i].toString().contains( fichier_recherche.toString() ) )
			{
				chemin = tab_fichiers[i].getAbsolutePath();
				break;
			}

			if ( tab_fichiers[i].isDirectory() )
			{
				if ( nombre_threads > 0 ) // lancer avec un thread
				{ 
					nombre_threads--;
					Chercheur fs = new Chercheur(tab_fichiers[i], fichier_recherche);
					// System.out.println("lancement du thread dans " + tab_fichiers[i]);
					Thread t = new Thread(fs);
					t.start();
					threads_lances	.add(t);
					fichiers_threads.add(fs);
				} 
				else // lancer sans thread
				{ 
					Chercheur fs = new Chercheur(tab_fichiers[i], fichier_recherche);
					fs.run(); 
					fichiers_recursion.add(fs);
				}
			}

		}


		// arreter les threads
		for ( int i = 0 ; i < threads_lances.size() ; i++ )
			try
			{
				threads_lances.get(i).join();
				nombre_threads++;
				if ( fichiers_threads.get(i).chemin != "" )
					chemin += fichiers_threads.get(i).chemin + "\n";
			}
			catch ( Exception e ) {e.printStackTrace();}

		for ( int i = 0 ; i < fichiers_recursion.size() ; i++ ) 
			if( fichiers_recursion.get(i).chemin != "" ) 
				chemin += fichiers_recursion.get(i).chemin + "\n";
	}
}

