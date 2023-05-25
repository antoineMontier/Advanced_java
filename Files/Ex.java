package Files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Ex {
    public static void main(String[] args){
        /*// ====== test if a file exists ======
        File f = new File("Files/test.txt");
        p(f.getName()  + " exists : " +   f.exists());


        // ================================================

        // ====== prints all the files and directories inside of the current directory ======
        File dir = new File("./Files");
        p(dir.getName() + " is directory : "  + dir.isDirectory());
        p("files of actual directory : "); Arrays.stream(dir.listFiles()).forEach(System.out::println);


        // ================================================*/

        /*// ====== prints the content of a file ======
        File ff = new File ("Files/test.txt");
        p(ff.getName()  + " exists : " +   ff.exists());
        try{
            BufferedReader br = new BufferedReader(new FileReader(ff));
            String l;
            while((l = br.readLine()) != null)
                p(l);
            br.close();
        }catch (IOException e){e.printStackTrace();}


        // ================================================*/

        // ====== writes from terminal into a file ======
        
        File to_write = new File("new_file.txt");
        p("ready to write in " + to_write.getName() + " type '*STOP*' to stop and commit");
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(to_write, true));
            Scanner sc = new Scanner(System.in);
            while(sc.hasNextLine()) {String s = sc.nextLine() ; if (s.contains("STOP")) break; bw.write(s); bw.newLine();}
            sc.close();
            bw.flush();
            bw.close();
        }catch(IOException e){ e.printStackTrace();}
        p("done");
        
        // ================================================

        /*// ====== copy a file to a different file ======
        File src = new File("Files/test.txt");
        p("copy possible : " + (src.exists() && src.isFile()));
        File dst = new File("Files/copied.txt");

        try{
            FileReader frr = new FileReader(src);
            Scanner scc = new Scanner(frr);
            FileWriter fww = new FileWriter(dst);
            while(scc.hasNextLine()) fww.append(scc.nextLine() + "\n");
            fww.flush();
            scc.close(); fww.close(); frr.close();
        }catch(IOException e){ e.printStackTrace();}


        // ================================================*/

        /*// ====== delete a file ======
        File delete = new File("Files/copied.txt");
        p("delete possible : " + (src.exists() && src.isFile()));
        p("deleted : " + delete.delete());


        // ================================================

        // ====== move a file ======
        File tomove = new File("./Files/blabla.txt");
        p("moved : " + tomove.renameTo(new File("./Files/temp_dir/blabla.txt")));


        // ================================================*/


    }

    public static void p(Object s){System.out.println(s);}
}

