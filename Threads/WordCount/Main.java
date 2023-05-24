package Threads.WordCount;

public class Main {
    public static void main(String[] args) throws FileException{
        FileProcessor fp;
        fp = new FileProcessor("/home/antoine/Prog");
        // System.out.println("before search");
        fp.loadFiles(".md");
        // System.out.println("after search");
        fp.printFiles();

        fp.countWords();

        fp.printWordsCount();
        System.out.println("total = " + fp.getWordSum());
        System.out.println("avg = " + fp.getAvgWordCount());
    }
}
