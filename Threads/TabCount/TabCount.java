package Threads.TabCount;

public class TabCount extends Thread {

    private int[] tab;
    private int start, end, to_find, count;
    public TabCount (int[] tab, int start, int end, int to_find) {
        this.start = start;
        this.tab = tab;
        this.end = end;
        this.to_find = to_find;
        count = 0;
    }

    public void run(){
        for(int i = start; i < end; i++) if(tab[i] == to_find) ++count;
    }

    public int getCount(){
        return count;
    }
}