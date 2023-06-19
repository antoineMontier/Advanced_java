package Exam_2022;

class Personne
{
	public String 	nom, prenom;
	public int 		dteNaiss;   

	public Personne(String Nom, String Prenom, int DteNaiss)
	{
		nom 		= Nom;
		prenom 		= Prenom;
		dteNaiss 	= DteNaiss;
	}

	public boolean equals(Object o)
	{
		if  ( o == null || !(o instanceof Personne)) return false;
		Personne q = (Personne)o;
		return q.nom.equals(nom) && q.prenom.equals(prenom) && q.dteNaiss == dteNaiss;
	}
}
