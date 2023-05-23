package Threads.Fibonacci;

public class Main{
    public static void main(String[] args){
        int term = 40;

        long start = System.nanoTime();
        long res = fibo(term);
        long end = System.nanoTime();

        System.out.println("Recursive in \t\t" + (end - start)/1000 + " micr.s res = " + res + "");

        start = System.nanoTime();
        res = fiboT(term, 10);
        end = System.nanoTime();

        System.out.println("Recursive Thread in \t" + (end - start)/1000 + " micr.s res = " + res + "");

        System.out.println();
    }

    public static int fibo(int n){
        if(n < 2) return n;
        return fibo(n-1) + fibo(n-2);
    }

    public static int fiboT(int n, int nb_threads){
        if(n < 2) return n;
        Fibo one = new Fibo(n-1, nb_threads/2);
        Fibo two = new Fibo(n-2, nb_threads/2);

        one.start(); two.start();

        try{
            one.join();two.join();
        }catch(Exception e){
            e.printStackTrace();
        }

        return one.getRes() + two.getRes();
    }
}