package Exam2022_03;

public class EntNat {

    private int N;

    public EntNat(int n) throws ErrConst {
        if( n < 0) throw new ErrConst("Pas de nombre négatifs dans le constructeur !", n);
        N = n;
    }

    public int getN() {return N;}

    public void setN(int n) throws ErrModif {
        if(n < 0) throw new ErrModif("Pas de nombre négatifs dans le setN() !", n);
        N = n;
    }

    public void decremente()throws ErrModif {
        if(N == 0) throw new ErrModif("Pas de nombre négatif !", N);
        N--;
    }
}
