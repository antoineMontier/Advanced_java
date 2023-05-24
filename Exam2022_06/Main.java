package Exam2022_06;

import java.util.Random;

public class Main {
    public static void main(String[] args){
        testInverserFichier();
    }

    public static void testMonTableau(){
        Integer[] tab = new Integer[20];
        Random rand = new Random();
        for(int i = 0 ; i < tab.length ; ++i) tab[i] = rand.nextInt(tab.length);
        MonTableau<Integer> mt = new MonTableau<>(tab);
        mt.plusGrandQue(10)  .sorted()
                                .forEach(System.out::println);
    }

    public static void testInverserFichier(){
        InverserFichier ivf = new InverserFichier("Exam2022_06/IndexNonValideException.java", "Exam2022_06/copied.txt");
        ivf.inverser();
    }
}
