package Abstraction;

abstract class Numerical_seq {

    private double U0;

    public abstract double next(double previous_term);
    public abstract double valueOf(int term);
    public abstract double sum(int term);

}
