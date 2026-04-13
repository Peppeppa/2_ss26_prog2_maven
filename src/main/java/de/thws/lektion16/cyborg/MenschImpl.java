package de.thws.lektion16.cyborg;

public class MenschImpl extends Entitaet implements Mensch {

    public Entscheidung entscheide(Gefahrensituation gefahr){
        int rnd = (int) Math.random()*4+1;
        if (rnd == 1){
            return Entscheidung.UNENTSCHIEDEN;
        }else{
            return switch (gefahr){
                case GEFAHR_LINKS -> Entscheidung.RECHTS;
                case GEFAHR_RECHTS -> Entscheidung.LINKS;
                case GEFAHR_VORNE -> Entscheidung.BREMSEN;
                case null -> Entscheidung.BREMSEN;
            };
        }

    }
    public void arbeiten(){

    }
    public void autofahren(){

    }
    public void essen(){

    }
    public void schlafen(){

    }
}
