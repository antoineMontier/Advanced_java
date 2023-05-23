package Threads.Fibonacci;

public class Fibo extends Thread {

    private int n;
    private int res;
    private int nb_th;
    public Fibo (int n, int nb_thread) {
        this.n = n;
        nb_th = nb_thread;
    }

    public void run(){
        if(n < 2) {res = n; return;}
        if(nb_th / 2 > 0){
            Fibo one = new Fibo(n-1, nb_th/2);
            Fibo two = new Fibo(n-2, nb_th/2);
            one.start(); two.start();

            try{
                one.join();two.join();
            }catch(Exception e){
                e.printStackTrace();
            }
            res = one.getRes() + two.getRes();
        }
        else res = fibo(n - 1) + fibo(n - 2);
    }

    public static int fibo(int n){
        if(n < 2) return n;
        return fibo(n-1) + fibo(n-2);
    }

    public int getRes(){
        return res;
    }
}