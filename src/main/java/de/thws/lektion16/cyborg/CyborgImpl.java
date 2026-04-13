package de.thws.lektion16.cyborg;

public class CyborgImpl extends Entitaet implements Mensch, Roboter{
    private Mensch mensch;
    private Roboter roboter;

    public CyborgImpl(){
        this.mensch = new MenschImpl();
        this.roboter = new RoboterImpl();
    }

    public Entscheidung entscheide(Gefahrensituation gefahr){
        if (Math.random()<0.5){
            return mensch.entscheide(gefahr);
        }else{
            return roboter.entscheide(gefahr);
        }
    }
    public void arbeiten(){

    }
    public void autofahren(){

    }
    public void aufladen(){

    }
    public void warten(){

    }
    public void essen(){

    }
    public void schlafen(){

    }
}
