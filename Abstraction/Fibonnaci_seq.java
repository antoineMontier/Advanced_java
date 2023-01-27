package Abstraction;

public class Fibonnaci_seq extends Numerical_seq{
    private int U0 = 1, U1 = 1;


    public double next(double previous_term){
        return previous_term + previous_term / 1.609; // approx with the golden number
    }

    public double valueOf(int term){
        if(term < 0) return 0; // error
        if(term == 0) return U0;
        if(term == 1) return U1;
        return valueOf(term-1) + valueOf(term-2);
    }

    public double sum(int term){
        if(term < 0) return 0; // error
        if(term == 0) return U0;
        if(term == 1) return U1 + U0;
        int res = (int)(sum(1));
        int a = U1;
        int b = U0;
        int c = U1;
        for(int i = 2 ; i < term; i++){
            a = b + c;
            b = c;
            c = a;
            res += a;
        }
        return res;
    }


}
