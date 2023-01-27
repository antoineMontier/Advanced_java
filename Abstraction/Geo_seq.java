package Abstraction;

public class Geo_seq extends Numerical_seq{
    
    private double q;
    private double U0;

    public Geo_seq(double first_term, double reason){
        U0 = first_term;
        q = reason;
    }


    public double next(double previous_term){
        return q * previous_term;
    }

    public double valueOf(int term){
        return U0*Math.pow(q, term);
    }

    public double sum(int term){
        if(q == 1)
            return (term+1) * U0;
        return U0*(1- Math.pow(q, term+1)) / (1-q);
    }


}
