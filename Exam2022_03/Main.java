package Exam2022_03;

public class Main {
    public static void main(String[] args){
        try{
            EntNat en = new EntNat(2);
            en.decremente();
            en.setN(1);
            en.decremente();
            en.decremente();
        }catch(Exception e){e.printStackTrace();}
    }
}
