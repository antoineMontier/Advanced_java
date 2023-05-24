/**
 * @author Antoine Montier
 * 
 * Exercise:
 * You are tasked with creating a Java program that processes a directory containing text files. The program should perform the following tasks:
 * Traverse the directory and its subdirectories to find all text files (with a ".txt" extension).
 * Create a separate thread for each text file found. Each thread should read the contents of the file, count the number of words in it, and store the result in a collection.
 * Once all threads have finished processing their respective files, the main thread should display the total word count for each file.
 */

package Threads.WordCount;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class FileProcessor {
    
    File parentDirectory;

    Map<File, Integer> files;
    
    public FileProcessor(String parentDir) throws FileException {
        parentDirectory = new File(parentDir);
        if(!parentDirectory.exists()) throw new FileException("directory not found");
        if(!parentDirectory.isDirectory()) throw new FileException("directory is a file");
    }

    public boolean loadFiles(String file_extension){
        if(!parentDirectory.isDirectory() || !parentDirectory.exists()) return false;
        files = new HashMap<>();
        rec_find_file(parentDirectory, file_extension);
        return files.size() != 0;
    }

    public void printFiles(){
        if(files == null) System.out.println("no files loaded");
        else files.keySet().stream().map(f -> f.getName()).forEach(System.out::println);
    }

    private void rec_find_file(File currentDir, String file_ext){
        if(!currentDir.exists() || !currentDir.isDirectory()) return;
        File[] subfiles = currentDir.listFiles();
        if(subfiles == null || subfiles.length == 0) return;
        for(File sf : subfiles){
            if(sf.isDirectory()) rec_find_file(sf, file_ext);
            if(sf.isFile() && sf.getName().contains(file_ext) && !sf.getName().substring(0, sf.getName().length() - 2).contains(file_ext)) files.put(sf, 0);
        }
    }

    public void countWords() throws FileException {
        if(files == null) throw new FileException("loadFiles before countWords !");
        FileCounter[] fc = new FileCounter[files.size()];
        Thread[] fcT = new Thread[files.size()];

        // Iterator <Entry<String, Integer>> i = files.iterator();
        Iterator <File> it =  files.keySet().iterator();
        for(int i = 0; i < fc.length; ++i) fc[i] = new FileCounter(it.next());
        for(int i = 0; i < fc.length; ++i) fcT[i] = new Thread(fc[i]);
        for(int i = 0; i < fc.length; ++i) fcT[i].start();
        try{
            for(int i = 0; i < fc.length; ++i) fcT[i].join();
        }catch(Exception e){ e.printStackTrace(); }
        for(int i = 0; i < fc.length; ++i) files.put(fc[i].getFile(), fc[i].getCount());
    }

    public void printWordsCount(){
        for(File f : files.keySet())
            System.out.println(f.getName() + " : " + files.get(f));
    }

    public long getWordSum(){
        return files.values().stream().reduce(0, (a, b) -> a + b);
    }

    public double getAvgWordCount(){
        return files.values().stream().mapToDouble(x -> x).average().orElse(0.0);
    }
}
