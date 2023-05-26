package Threads.MatrixMult;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        int[][] matrixA = {{1, 2}, {3, 4}};
        int[][] matrixB = {{5, 6}, {7, 8}};

        int[][] result = multiplyMatrices(matrixA, matrixB);
        System.out.println("Result:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB){
        int linesA = matrixA[0].length, colsB = matrixB.length;
        if (linesA != colsB) throw new IllegalArgumentException("lines of A must be = to colsB ");
        MatrixRes[][] mrT = new MatrixRes[linesA][colsB];
        for(int i = 0 ; i < mrT.length; i++) for(int j = 0 ; j < mrT[i].length ; j++) mrT[i][j] = new MatrixRes(i, j, matrixA, matrixB);
        for(int i = 0 ; i < mrT.length; i++) for(int j = 0 ; j < mrT[i].length ; j++) mrT[i][j].start();
        try{
            for(int i = 0 ; i < mrT.length; i++) for(int j = 0 ; j < mrT[i].length ; j++) mrT[i][j].join();
        }catch(Exception e){e.printStackTrace();}
        int[][] res = new int[linesA][colsB];
        for(int i = 0 ; i < mrT.length; i++) for(int j = 0 ; j < mrT[i].length ; j++) res[i][j] = mrT[i][j].res();
        return res;
    }

}
