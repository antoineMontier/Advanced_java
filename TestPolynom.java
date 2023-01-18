public class TestPolynom {
    public static void main(String[] args){
        System.out.println("\n\n");

        Polynom p = new Polynom();
        p.addMonom(-1, 0);
        p.addMonom(-3, 1);
        p.addMonom(0.5, 1);

        Polynom g = new Polynom();
        g.addMonom(4, 0);
        g.addMonom(2, 3);

        Polynom h = new Polynom();

        System.out.println("p = " + p);
        System.out.println("g = " + g);
        System.out.println("h = " + h);

        System.out.println("(p + g) = " + (p.plus(g)));
        System.out.println("(p - g) = " + (p.minus(g)));
        System.out.println("(p - g + p) = " + (p.minus(g).plus(p)));
        System.out.println("(p - h) = " + (p.minus(h)));
        System.out.println("(h - p) = " + (h.minus(p)));

        assert((p.minus(h)).equals(p));
        assert((p.minus(p)).equals(h));
        assert((p.plus(g)).equals(g.plus(p)));
        assert((g.plus(h).minus(p)).equals(g.minus(p)));
        assert((g.mult(h)).equals(p.mult(h)));
        assert(h.plus(h).equals(h));
        assert(h.derivate().equals(h));
        

        System.out.println(g.derivate());

        System.out.println("\n\n");
    }
}
