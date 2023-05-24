package Exam2022_06;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class InverserFichier {
    File src;
    File dst;

    public InverserFichier(String source, String destination){
        src = new File(source);
        dst = new File(destination);
    }

    public boolean inverser(){
        if(!src.exists() || src.isDirectory()) return false;
        ArrayList<String> lines = new ArrayList<String>();
        try{
            FileReader fr = new FileReader(src);
            Scanner sc = new Scanner(fr);
            while (sc.hasNextLine()) lines.add(sc.nextLine() + "\n");
            sc.close();
            fr.close();
        }catch (IOException e) {e.printStackTrace();}
        if (lines.size() == 0) return false;
        try{
            FileWriter fw = new FileWriter(dst);
            for(int i = lines.size() - 1 ;  i>= 0 ;--i) fw.append(lines.get(i));
            fw.close();
        }catch(IOException e){e.printStackTrace();}
        return true;
    }

}
