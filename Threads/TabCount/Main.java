package Threads.TabCount;
import java.util.Random;

public class Main{
    public static void main(String[] args){
        int[] tab = randTab(100000000, 50);
        long start = System.nanoTime();
        int count = count(tab, 20);
        long end = System.nanoTime();

        System.out.println("Linear in " + (end - start) + " ns res = " + count + "");

        start = System.nanoTime();
        count = count(tab, 20, 10);
        end = System.nanoTime();

        System.out.println("Thread in " + (end - start) + " ns res = " + count + "");

        System.out.println();
        System.out.println();
    }

    public static int[] randTab(int size, int max){
        int tab[] = new int[size];
        Random rand = new Random(); rand.setSeed(System.currentTimeMillis());
        for(int i=0; i<size; i++) tab[i] = rand.nextInt(max);
        return tab;
    }

    public static String tabStr(int[] tab){
        String res = "[";
        for(int i=0; i<tab.length-1; i++) res += tab[i] + ", ";
        return res += tab[tab.length - 1] + "]";
    }

    public static int count(int[] tab, int to_find){int count = 0; for(int i = 0 ; i < tab.length ; i++) if(tab[i] == to_find) ++count; return count;}
    public static int count(int[] tab, int to_find, int start, int end){int count = 0; for(int i = start ; i < end ; i++) if(tab[i] == to_find) ++count; return count;}

    public static int count(int[] tab, int to_find, int nb_thread){
        int portion = tab.length / nb_thread;
        TabCount[] counter = new TabCount[nb_thread];
        for(int i = 0; i < nb_thread; i++) counter[i] = new TabCount(tab, i*portion, (i+1)*portion, to_find);
        for(int i = 0; i < nb_thread; i++) counter[i].start();
        int count = 0;
        if(tab.length % nb_thread != 0) count += count(tab, to_find, tab.length - (tab.length % count), tab.length);
        try{
            for(int i = 0; i < nb_thread; i++) counter[i].join();
        }catch(Exception e){
            e.printStackTrace();
        }
        for(int i = 0; i < nb_thread; i++) count += counter[i].getCount();
        return count;
    }
}