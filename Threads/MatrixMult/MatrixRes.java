package Threads.MatrixMult;

public class MatrixRes extends Thread{
    int i, j, r;
    int[][] a, b;
    public MatrixRes(int i, int j, int[][] a, int[][] b){
        this.i = i;
        this.j = j;
        this.a = a;
        this.b = b;
        r = 0;
    }

    public void run (){
        for(int k = 0 ; k < b.length ; k++) r += a[i][k] * b[k][j];
    }

    public int res() {
        return r;
    }

}
