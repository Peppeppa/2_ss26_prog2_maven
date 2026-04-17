package de.thws.lektion16.cyborg;

public class RoboterImpl extends Entitaet implements Roboter{


    public Entscheidung entscheide(Gefahrensituation gefahr){
        return switch (gefahr){
            case GEFAHR_LINKS -> Entscheidung.RECHTS;
            case GEFAHR_RECHTS -> Entscheidung.LINKS;
            case GEFAHR_VORNE -> Entscheidung.BREMSEN;
            default -> Entscheidung.BREMSEN;
        };
    }

    public void arbeiten(){

    }
    public void autofahren(){

    }
    public void aufladen(){

    }
    public void warten(){

    }
}
