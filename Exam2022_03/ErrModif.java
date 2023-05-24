package Exam2022_03;

public class ErrModif extends ErrNat {
    public ErrModif(String message, int n){
        super("erreure de modification de l'EntNat " + n + " : " + message);
    }
}
