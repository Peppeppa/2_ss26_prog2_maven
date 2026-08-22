package de.thws.klausurvorbereitung.ostap.lektion16.a4;

public class Superheld implements Flugfaehig, Unsichtbar, Stark{
    @Override
    public void fliege() {
        System.out.println("fliege");
    }

    @Override
    public void hebeGewicht(int kg) {
        System.out.println("hebe " + kg + "kg");
    }

    @Override
    public void versteckeDich() {
        System.out.println("weg");
    }

    static void main() {
        Superheld a = new Superheld();
        Superheld b = new Superheld();
        Superheld c = new Superheld();
        Superheld[] arr = {a,b,c};

        for(Superheld s:arr){
            int rnd = (int) (Math.random()*3);
            switch(rnd) {
                case 1:
                    s.fliege();
                    break;
                case 2:
                    s.hebeGewicht(123);
                    break;
                case 0:

                    s.versteckeDich();
                    break;
                default:
                    break;
            }






        }
    }
}
