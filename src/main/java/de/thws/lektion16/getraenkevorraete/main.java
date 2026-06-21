package de.thws.lektion16.getraenkevorraete;

public class main {
    static void main() {
        BierImpl b1 = new BierImpl("Helles", "Eichhofen", 5.0);
        BierImpl b2 = new BierImpl("Alkoholfrei", "Alk", 0.2);
        WeinImpl rw = new WeinImpl("Randersacker", "Rotwein", 8.2, 2040);
        WeinImpl ww = new WeinImpl("Randersacker", "Weißwein", 18.2, 3000);
        GetraenkImpl[] ga = new GetraenkImpl[]{b1, b2, rw, ww};
        for (GetraenkImpl sauf : ga){
            System.out.println(sauf.toString());
        }


    }
}
