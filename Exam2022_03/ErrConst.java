package Exam2022_03;

public class ErrConst extends ErrNat {
    public ErrConst(String message, int n){
        super("erreure de construction de l'EntNat " + n + " : " + message);
    }
}
