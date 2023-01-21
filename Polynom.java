import java.util.Scanner;

public class Polynom{
    private int COEF_NUMBER = 20;
    private final double precision = 0.00001;

    private double[] coef;
    private int size;


    public Polynom(){
        coef = new double[COEF_NUMBER];
        size = 0;
    }

    public Polynom(Polynom p){
        if(p == null) throw new IllegalArgumentException("The given polynom is null");
        coef = new double[COEF_NUMBER];
        for(int i=0; i < COEF_NUMBER; i++)
            coef[i] = p.coef(i);
        updateSize();
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
        updateSize();
        return size -1;
    }

    public void addMonom(double a, int deg){
        if(a!=0&&deg < 0 && deg >= COEF_NUMBER)
            throw new IllegalArgumentException("degree of a monom must be between 0 and " + COEF_NUMBER);
        if(coef[deg] == 0)
            size++;
        coef[deg] = coef[deg] + a;
    }

    public void reset(){
        for(int i=0; i<COEF_NUMBER; i++) coef[i] = 0.0;
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

    private void updateSize(){
        size = 0;
        for(int i = 0; i < COEF_NUMBER ; i++)
            if(coef[i] != 0)
                size++;
    }

    public Polynom plus(Polynom other){
        Polynom res = new Polynom();
        for(int i = 0 ; i < COEF_NUMBER ; i++)
            res.addMonom(this.coef(i) + other.coef(i), i);
        res.updateSize();
        return res;
    }

    public Polynom minus(Polynom other){
        Polynom res = new Polynom();
        for(int i = 0 ; i < COEF_NUMBER ; i++)
            res.addMonom(this.coef(i) - other.coef(i), i);
        res.updateSize();
        return res;
    }

    public boolean equals(Polynom other){
        for(int i = 0; i < COEF_NUMBER ; i++)
            if(coef[i] != other.coef(i))
                return false;
        return true;
    }

    public Polynom mult(Polynom other){
        Polynom res = new Polynom();
        if(size == 0 || other.equals(res))//0 exception
            return res;
        for(int i = 0; i < COEF_NUMBER ; i++)
            for(int j = 0; j < COEF_NUMBER ; j++)
                if(i+j < COEF_NUMBER)
                    res.addMonom(coef[i]*other.coef(j), j+i);
        other.updateSize();
        return res;
    }

    public Polynom derivate(){
        Polynom res = new Polynom();
        for(int i = 1; i < COEF_NUMBER  ; i++)
            res.addMonom(i*coef[i], i-1);
        return res;
    }

    public Polynom divisionRest(Polynom p, Polynom q){
        if(q.degree() == 0 && q.coef(0) == 0)
            throw new IllegalArgumentException("the division cannot be operated with a null polynom");
        else if(p.degree() == 0 && p.coef(0) == 0)
            return new Polynom(); // the 0 polynom
        Polynom quotient = euclidian_division(p, q);
        Polynom res = new Polynom();
        res = p.minus(q.mult(quotient));
        return res;
    }

    public double getGreaterCoef(){
        for(int i=COEF_NUMBER-1;i>=0;i--)
            if(coef[i] != 0)
                return coef[i];
        return 0;
    }

    public Polynom pgcd(Polynom p, Polynom q){
        if(p.degree() == 0 && q.degree() == 0)
            return new Polynom(); // the 0 polynom
        if(p.degree() == 0)
            return new Polynom(q);
        else if(q.degree() == 0)
            return new Polynom(p);


        if(p.degree() >= q.degree())
            return divisionRest(p, q);
        else(q.degree() < p.degree())
            return divisionRest(q, p);
    }

    public static Polynom euclidian_division(Polynom p, Polynom q) {
        if(q.degree() == 0 && q.coef(0) == 0)
            throw new IllegalArgumentException("the divisor cannot be null !");
        Polynom _p = new Polynom(p);
        Polynom _q = new Polynom(q);
        Polynom res = new Polynom();
        Polynom tmp_res = new Polynom();
        while(_p.degree() >= _q.degree()){
            System.out.println("p= " + _p + "      q = " + _q );
            //find the coefficient of the biggest degree in p and q
            double p_d = _p.getGreaterCoef(), q_d = _q.getGreaterCoef();
            tmp_res.addMonom(p_d / (double) q_d, _p.degree() - _q.degree());
            System.out.println("tmp= " + tmp_res);
            // substract
            _p = _p.minus(tmp_res.mult(_q));
            // save the founded value
            res = res.plus(tmp_res);
            tmp_res.reset();
            System.out.println("p= " + _p + "      q = " + _q );
        }
        return res;
    }

    public static Polynom euclidian_rest(Polynom p, Polynom q){
        return p.minus(q.mult(Polynom.euclidian_division(p, q)));
    }


}