package Matrix;


public class Matrix{


    private double[][] m;
    
    public Matrix(int size){
        m = new double[size][size];

    }

    public Matrix(int h, int w){
        m = new double[h][w];
    }

    @Override
    public String toString(){
        if(m.length == 0)
            return "[]";
        String res = "";
        for(int i = 0 ; i < m.length; i++){
            res += "[ ";
            for(int j = 0 ; j < m[i].length; j++)
                res += m[i][j] + " ";
            res += "]\n";
        }
        return res;
    }

    public int width(){
        return m[0].length;
    }

    public int height(){
        return m.length;
    }

    public double get(int i, int j){
        if(i < 0 || i >= m.length || j < 0 || j >= m[0].length)
            throw new IllegalArgumentException("invalid index argument in get(int, int) Matrix");
        return m[i][j];
    }   

    public void set(int i, int j, double value){
        if(i < 0 || i >= m.length || j < 0 || j >= m[0].length)
            throw new IllegalArgumentException("invalid index argument in get(int, int) Matrix");
        m[i][j] = value;
    } 

}