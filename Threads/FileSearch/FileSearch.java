package Threads.FileSearch;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileSearch implements java.lang.Runnable{
    
    public File currentDirectory;
    public File search;
    public static int nb_th;
    String path;

    public FileSearch(File dir, File to_find){
        currentDirectory = dir;
        search = to_find;
        path = "";
        // System.out.println("created new thread " + nb_th);
    }

    public void run() {
        if(currentDirectory.isDirectory() == false) System.out.println(currentDirectory + " is not a directory");
        List<Thread> threads = new ArrayList<>();
        List<FileSearch> filest = new ArrayList<>();
        List<FileSearch> filesr = new ArrayList<>();

        File[] flist = currentDirectory.listFiles();
        if(flist == null){
            System.out.println("error in listing files in directory " + currentDirectory + "\n\n");
            return;
        }
        // System.out.println("dir = " + currentDirectory + " list = " + Arrays.toString(flist) + "\nthread_num = " + nb_th);
        for(int i = 0; i < flist.length; i++) {
            if(flist[i].toString().contains(search.toString())) {path = flist[i].getAbsolutePath(); break;}
            if(flist[i].isDirectory()){
                // System.out.println(" file " + file + " is a directory");
                if(nb_th > 0){ // launch a new thread
                    nb_th--;
                    FileSearch fs = new FileSearch(flist[i], search);
                    System.out.println("launching search thread in " + flist[i]);
                    Thread t = new Thread(fs);
                    t.start();
                    threads.add(t);
                    filest.add(fs);
                } else{
                    FileSearch fs = new FileSearch(flist[i], search);
                    fs.run(); // launch without a thread
                    filesr.add(fs);
                }
            }
        }
        for(int i = 0 ; i < threads.size() ; i++)
            try{
                threads.get(i).join();
                nb_th++;
                if(filest.get(i).path != "")
                    path += filest.get(i).path + "\n";
            }catch(Exception e){e.printStackTrace();}
        for(int i = 0 ; i < filesr.size() ; i++) if(filesr.get(i).path != "") path += filesr.get(i).path + "\n";
    }
}
