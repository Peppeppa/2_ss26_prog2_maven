package de.thws.klausurvorbereitung.musikstuecksammlung;

public class MusikStueck {

    String titel; // Name des Musikstueckes
    String interpret; // Gruppe/Saenger des Stueckes
    int laenge; // Dauer in Sekunden

    public MusikStueck(String titel, String interpret, int laenge)
    {
        this.titel = titel;
        this.interpret = interpret;
        this.laenge = laenge;
    }
    @Override
    public String toString(){
        String result = "";
        result +=   "Titel: " + titel + "\n" +
                    "Interpret: " + interpret + "\n" +
                    "Spieldauer: " + laenge;
        return result;
    }


}
