package Threads;

public class A {
    public static void main(String[] args){
        E e = new E();
        Thread t = new Thread(e);
        System.out.println(t.isAlive());
        t.start();
        System.out.println(t.isAlive());
    }
}
