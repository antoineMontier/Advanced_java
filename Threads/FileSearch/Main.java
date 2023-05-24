package Threads.FileSearch;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        // System.out.println(Arrays.toString(new File("/").listFiles()));
        String res = searchFiles("/home", "Main.java", 40);
        System.out.println("\n\nres = \n" + res + "");
    }

    public static String searchFiles(String directoryPath, String to_find, int numThreads){
        FileSearch fs = new FileSearch(new File(directoryPath), new File(to_find));
        fs.nb_th = numThreads;
        Thread t = new Thread(fs);
        t.start();
        try{
            t.join();
        }catch(Exception e){e.printStackTrace();}
        return fs.path;
    }

}
