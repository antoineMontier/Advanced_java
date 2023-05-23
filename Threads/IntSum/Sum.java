package Threads.IntSum;

public class Sum extends Thread {
    long from, to, res;
    public Sum(long from, long to){
        this.from = from;
        this.to = to;
        res = 0;
    }

    public void run(){
        for(long i = from; i < to; i++) res += i;
    }

    public long getRes(){return res;}
}
