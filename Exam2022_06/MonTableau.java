package Exam2022_06;

import java.util.Arrays;
import java.util.stream.Stream;

public class MonTableau<T extends Number> {
    Object[] tableau;

    public MonTableau(T[] tab){
        tableau = new Object[tab.length];
        for(int i = 0 ; i < tab.length ; ++i) tableau[i] = tab[i];
    }

    public int size(){return tableau.length;}
    public T get(int index) throws IndexNonValideException {
        if(index < 0 || index >= tableau.length) throw new IndexNonValideException("hors du tableau");
        return (T)(tableau[index]);
    }

    public void set(int index, T value) throws IndexNonValideException {
        if(index < 0 || index >= tableau.length) throw new IndexNonValideException("hors du tableau");
        tableau[index] = value;
    }


    public Stream<T> plusGrandQue(T nb){
        return 
        Arrays.stream(tableau)
                .filter(p -> ((((T)p).doubleValue()) - nb.doubleValue() >= 0))
                .map(x -> (T)x);
    }

}
