package two_degree;

public class Two_D_Eq{

    private double a, b, c;
    private boolean complexe;

    public Two_D_Eq(double x2, double x1, double x0){
        a = x2;
        b = x1;
        c = x0;
        complexe = (delta() < 0);
    }

    @Override
    public String toString(){
        return (a + "x² " + " + " + b + "x¹" + " + " + c);
    }

    private double delta(){return b*b - 4*a*c;}

    public String getX1(){
        if(!complexe)
            return "x1 = "  + (b - Math.sqrt(delta())) / 2*a;
        else    
            return "x1 = "  + ( b/2*a ) + " - " + (Math.sqrt(-delta()) / 2*a ) + "i";


    }

    public String getX2(){
        if(!complexe)
            return "x2 = "  + (b + Math.sqrt(delta())) / 2*a;
        else
            return "x2 = "  + ( b/2*a ) + " + " + (Math.sqrt(-delta()) / 2*a ) + "i";

    }

}