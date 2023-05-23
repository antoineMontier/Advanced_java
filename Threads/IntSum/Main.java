package Threads.IntSum;

public class Main {
    public static void main(String[] args){
        System.out.println(calculateSum(1000000, 8));
    }
    public static long calculateSum(long limit, long numThreads){
        Sum[] th = new Sum[(int)numThreads];
        for(long i=0; i < th.length; i++) th[(int)i] = new Sum((limit / numThreads)*i, (limit / numThreads)*(i+1));
        for(long i=0; i<th.length; i++) th[(int)i].start();
        try{
            for(long i=0; i<th.length; i++) th[(int)i].join();
        }catch(Exception e){e.printStackTrace();}
        long res = 0;
        for(long i=0; i<th.length; i++) res += th[(int)i].getRes();
        return res;
    }

}
