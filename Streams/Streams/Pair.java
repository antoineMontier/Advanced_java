package Streams;

public class Pair<T, U> {
    T left;
    U right;

    public Pair(T t, U u){
        left = t;
        right = u;
    }

    public T getLeft(){
        return left;
    }

    public U getRight(){
        return right;
    }

    public void setLeft(T t){
        left = t;
    }

    public void setRight(U u){
        right = u;
    }

    @Override
    public boolean equals(Object o){
        return left.equals(((Pair)(o)).getLeft()) && right.equals(((Pair)(o)).getRight());
    }

    public Pair(Pair<T, U> p){
        left = p.getLeft();
        right = p.getRight();
    }
}
