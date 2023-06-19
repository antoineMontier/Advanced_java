package Exam_2022;

class Livre 
{
    public String       titre;
    public Personne[]   scenaristes, dessinateurs;

    public Livre(String Titre)
    {
        titre = Titre;
        scenaristes = new Personne[0];
        dessinateurs = new Personne[0];
    }

    public boolean ajouterScenariste(Personne p)
    {
        return ajouterDansTab(scenaristes, p);
    }

    public boolean ajouterDessinateur(Personne p)
    {
        return ajouterDansTab(dessinateurs, p);
    }

    private boolean ajouterDansTab(Personne[] tab, Personne p)
    {
        // vérifier que la personne n'est pas présente
        for(Personne pers : tab) if(pers == p) return false;
        
        Personne[] nouveauTab = new Personne[tab.length + 1]; // créer le nouveau tableau

        for(int i = 0; i < tab.length; ++i) nouveauTab[i] = tab[i]; // copier

        nouveauTab[nouveauTab.length - 1] = p; // ajouter

        tab = nouveauTab; // changer la référence

        return true;
    }
}
