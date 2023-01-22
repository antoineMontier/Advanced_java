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



}