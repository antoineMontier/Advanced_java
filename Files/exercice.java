package Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class exercice {
    
    public static void main(String[] args){
        // test if a file exists
        // System.out.println(fileExists("Files/blabla.txt"));

        // prints all the files inside of the current directory
        // print_files(".");

        // prints the content of a file
        // printFile("Files/blabla.txt");

        // writes terminal into a file
        // write_in_file("Files/test.txt");
    }

    public static boolean fileExists(String filename){
        File test = new File(filename);
        return test.exists();
    }

    public static void print_files(String directory){
        File file = new File(directory);
        File[] files = file.listFiles();
        for(int i = 0; i < files.length; i++)
            System.out.println(files[i]);
    }

    public static void printFile(String filename){
        if(!fileExists(filename)){
            System.out.println("File not found");
            return;
        }
        FileReader fr;
        try{
            fr = new FileReader(filename);
            Scanner sc = new Scanner(fr);
            while(sc.hasNextLine())
                System.out.println(sc.nextLine());
            sc.close();
        }catch(FileNotFoundException e){
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

}
