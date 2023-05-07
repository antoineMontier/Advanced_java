package Threads;

public class MyThread extends Thread{
    private int id;
    public MyThread(int idd){id = idd;}

    public void run(){
        for(int i = 0 ; i < 10 ; ++i)
            System.out.println("T>"  + id + ":" + i + "");
    }
}
