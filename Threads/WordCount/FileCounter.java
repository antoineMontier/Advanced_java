package Threads.WordCount;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileCounter implements java.lang.Runnable {

    private File f;
    private int count;
    
    public FileCounter(File file) throws FileException {
        if(!file.exists() || !file.isFile()) throw new FileException("file " + file + " is not a valid file");
        f = file; count = 0;
    }

    public void run(){
        try{
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            while((line = br.readLine()) != null) count += line.split(" ").length;
            br.close();
        }catch(Exception e){e.printStackTrace();}
    }

    public int getCount(){return count;}

    public File getFile(){return f;}

}
