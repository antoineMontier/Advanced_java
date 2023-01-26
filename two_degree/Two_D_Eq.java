package two_degree;

public class Two_D_Eq{

    private double a, b, c;

    public Two_D_Eq(double x2, double x1, double x0){
        a = x2;
        b = x1;
        c = x0;
    }

    @Override
    public String toString(){
        return (a + "x² " + " + " + b + "x¹" + " + " + c);
    }

    private double delta(){return b*b - 4*a*c;}

    public double getX1(){
        if(delta() < 0)
            throw new IllegalAccessError();
        return (b - Math.sqrt(delta())) / 2*a;
    }

    public double getX2(){
        if(delta() < 0)
            throw new IllegalAccessError();
        return (b + Math.sqrt(delta())) / 2*a;
    }

}