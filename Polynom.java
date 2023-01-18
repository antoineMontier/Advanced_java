import java.util.Scanner;

public class Polynom{
    private int COEF_NUMBER = 20;
    private double precision = 0.00001;

    private double[] coef;
    private int size;


    public Polynom(){
        coef = new double[COEF_NUMBER];
        size = 0;
    }

    private boolean equals(double x, float y){
        return (x < y + precision) && (x > y - precision);
    }

    public void readPolynom(){
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while(sc.hasNext()){
            coef[i] = sc.nextDouble();
            i++;
        }
        sc.close();
    }

    public int degree(){
        return size -1;
    }

    public void addMonom(double a, int deg){
        if(deg < 0 && deg > COEF_NUMBER)
            throw new IllegalArgumentException("degree of a monom must be between 0 and " + COEF_NUMBER);
        if(coef[deg] == 0)
            size++;
        coef[deg] = coef[deg] + a;
    }


    public double coef(int deg){
        if(deg < 0 && deg > COEF_NUMBER)
            throw new IllegalArgumentException("degree of the polynom are between 0 and " + COEF_NUMBER);
        return coef[deg];
    }

    @Override
    public String toString(){
        if(size == 0)
            return "0";
        String res ="";
        for(int i=0; i< COEF_NUMBER; i++){
            if(coef[i] != 0){
                if(coef[i] > 0){
                    if(i == 0)
                        res += " + " + coef[i];
                    else if (i == 1)
                        res += " + " + coef[i] + "x";
                    else
                        res += " + " + coef[i] + "x^"+i;
                }else{//coef[i] < 0
                    if(i == 0)
                        res += " - " + (-coef[i]);
                    else if (i == 1)
                        res += " - " + (-coef[i]) + "x";
                    else
                        res += " - " + (-coef[i]) + "x^"+i;
                }


            }
        }
        return res;
    }



    public String toTab(){
        String res = "[" + coef[0];
        for(int i = 1; i < COEF_NUMBER-1 ; i++)
            res += ", " + coef[i];
        res += ", " + coef[COEF_NUMBER-1] + "]";
        return res;
    }


}