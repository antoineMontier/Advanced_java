package Files;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Scanner;

public class exercice {
    
    public static void main(String[] args){
        // test if a file exists
        // System.out.println(fileExists("Files/blabla.txt"));

        // prints all the files and directories inside of the current directory
        // print_files("..");

        // prints the content of a file
        // printFile("Files/blabla.txt");

        // writes terminal into a file
        // write_in_file("Files/test.txt");

        // copy a file to a different file
        // copy_file("Files/blabla.txt", "Files/test.txt");
        // quick_copy_file("Files/blabla.txt", "Files/test.txt");
    }

    public static boolean fileExists(String filename){
        File test = new File(filename);
        return test.exists();
    }

    public static void print_files(String directory){
        File file = new File(directory);
        File[] files = file.listFiles();
        Arrays.stream(files).forEach(System.out::println);
    }

    public static void printFile(String filename){
        if(!fileExists(filename)){
            System.out.println("File not found");
            return;
        }
        try{
            FileReader fr = new FileReader(filename);
            Scanner sc = new Scanner(fr);
            while(sc.hasNextLine())
                System.out.println(sc.nextLine());
            sc.close();
            fr.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void write_in_file(String filename){
        System.out.println("about to write in file " + filename + " type 'STOP' to end :");
        try{
            Scanner sc = new Scanner(System.in);
            FileWriter fw = new FileWriter(filename);
            String buff = "";
            while(!(buff = sc.next()).contains("STOP") && buff != null)
                fw.append(buff + "\n");
            fw.flush();
            fw.close();
            sc.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void copy_file(String src, String dest){
        if(!fileExists(src)){
            System.out.println("File " + src + " not found");
            return;
        }
        try{
            Scanner read = new Scanner(new FileReader(src));
            FileWriter fw = new FileWriter(dest);
            while(read.hasNextLine())
                fw.append(read.nextLine() + "\n");
            fw.close(); read.close(); // Close also the FileReader explicitly
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void quick_copy_file(String src, String dest){
        try{
            Files.copy(new File(src).toPath(), new File(dest).toPath());
        }catch(IOException e){e.printStackTrace();}
    }

}
