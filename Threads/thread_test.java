package Threads;

public class thread_test {
    public static void main(String[] args){
        MyThread mt = new MyThread(1);
        MyThread mtt = new MyThread(2);
        System.out.println("\t\tbefore>>|" + mt.getState() + "|" + mtt.getState());

        mt.start();
        mt.interrupt();
        mtt.start();
        System.out.println("\t\tmiddle>>|" + mt.currentThread() + "|" + mtt.currentThread());
        try{
            mt.join();
            mtt.join();
        }catch(Exception e){}
        System.out.println("\t\tafter>>|" + mt.getState() + "|" + mtt.getState());

    }
}
