package de.thws.lektion16.cyborg;

public interface Mensch {
    public Entscheidung entscheide(Gefahrensituation gefahr);
    public void essen();
    public void schlafen();
    public void arbeiten();
    public void autofahren();
}
