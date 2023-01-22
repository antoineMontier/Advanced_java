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

    public Matrix plus(Matrix other){
        if(other.width() != width() || other.height() != height())
            throw new IllegalArgumentException("both matrixs must have the same width and height to be added");
        Matrix res = new Matrix(height(), width());
        for(int i = 0; i < width(); i++)
            for(int j = 0; j < height(); j++)
                res.set(i, j, other.get(i, j) + m[i][j]);
        return res;
    }

    public Matrix minus(Matrix other){
        if(other.width() != width() || other.height() != height())
            throw new IllegalArgumentException("both matrixs must have the same width and height to be substracted");
        Matrix res = new Matrix(height(), width());
        for(int i = 0; i < width(); i++)
            for(int j = 0; j < height(); j++)
                res.set(i, j, - other.get(i, j) + m[i][j]);
        return res;
    }

    public Matrix mult(double a){
        Matrix res = new Matrix(height(), width());
        for(int i = 0; i < width(); i++)
            for(int j = 0; j < height(); j++)
                res.set(i, j, a * m[i][j]);
        return res;
    }
}