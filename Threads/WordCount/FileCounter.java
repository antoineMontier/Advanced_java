package Threads.WordCount;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class FileCounter implements java.lang.Runnable {

    private File f;
    private int count;
    
    public FileCounter(File file) throws FileException {
        if(!file.exists() || !file.isFile()) throw new FileException("file " + file + " is not a valid file");
        f = file; count = 0;
    }

    public void run(){
        try{
            FileReader fr = new FileReader(f);
            Scanner sc = new Scanner(fr);
            while(sc.hasNextLine()) count += sc.nextLine().split(" ").length;
            sc.close();
            fr.close();
        }catch(Exception e){e.printStackTrace();}
    }

    public int getCount(){return count;}

    public File getFile(){return f;}

}
