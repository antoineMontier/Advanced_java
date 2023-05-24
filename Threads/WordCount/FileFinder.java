package Threads.WordCount;

import java.io.File;
import java.util.ArrayList;

public class FileFinder implements java.lang.Runnable {
    private File o;
    public static ArrayList<File> f;
    public static String file_ext;

    public FileFinder(File origin){
        o = origin;
    }

    public void run(){
        if(!o.exists() || !o.isDirectory()) return;
        File[] subfiles = o.listFiles();
        if(subfiles == null || subfiles.length == 0) return;
        ArrayList<FileFinder> ff = new ArrayList<>();
        ArrayList<Thread> t = new ArrayList<>();
        for(File sf : subfiles){
            if(sf.isDirectory()){
                FileFinder fff = new FileFinder(sf);
                Thread ttt = new Thread(fff);
                ff.add(fff);
                t.add(ttt);
                ttt.start();
            }
            if(sf.isFile() && sf.getName().contains(file_ext) && !sf.getName().substring(0, sf.getName().length() - 2).contains(file_ext)) f.add(sf);
        }
        try{
            for(int  i = 0 ; i < t.size() ; i++)
                t.get(i).join();
        }catch(Exception e){e.printStackTrace();}
    }
}
