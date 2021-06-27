package question3;

import question1.PolygoneRegulier;

public class UneUtilisation {

    public static void main(String[] args) throws Exception {
        Pile2<PolygoneRegulier> p1 = new Pile2<PolygoneRegulier>(5);
        Pile2<Pile2<PolygoneRegulier>> p2 = new Pile2<Pile2<PolygoneRegulier>>(5); 

        // p1 est ici une pile de polygones r√©guliers PolygoneRegulier.java
        p1.empiler(new PolygoneRegulier(4, 100));
        p1.empiler(new PolygoneRegulier(5, 100));

        System.out.println(" la pile p1 = " + p1);

        p2.empiler(p1);
        System.out.println(" la pile p2 = " + p2);

        try {
            // p1.empiler(new PolygoneRegulier(5,100)); // d√©sormais une erreur de
            // compilation
            // ....
            // String s = (String)p1.depiler(); // d√©sormais une erreur de
            // compilation
            p1.empiler(new PolygoneRegulier(5,10)); // vÈrifiez qu'une exception est levÈe ‡ la compilation
            String s = p1.depiler().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}