package de.thws.lektion16.cyborg;

public interface Roboter {
    public Entscheidung entscheide(Gefahrensituation gefahr);
    public void aufladen();
    public void warten();
    public void arbeiten();
    public void autofahren();
}

