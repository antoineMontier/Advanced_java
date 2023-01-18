import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class TestPolynom {
    public static void main(String[] args){
        System.out.println("\n\n");

        Polynom p = new Polynom();
        p.addMonom(-1, 0);
        p.addMonom(-3, 1);
        System.out.println(p.toTab());
        System.out.println(p.toString());



        System.out.println("\n\n");
    }
}
