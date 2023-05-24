package Threads.WordCount;

public class FileException extends Exception {
    public FileException(String msg){
        super("FileException: " + msg);
    }
}
