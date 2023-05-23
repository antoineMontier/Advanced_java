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
        int[][] C = new int[matrixA.length][matrixB[0].length];

        MatrixRes[] mr = new MatrixRes[matrixA.length*
        // preparation
        for(int i = 0 ; i < C.length; i++)
            for(int j = 0 ; j < C[i].length ; j++)

            
    }

}
