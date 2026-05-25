package de.thws.lektion21.Naehrstoffangabe;

public class Naehrstoffangabe {
    double portionsGroesse;
    int anzahlPortionen;
    double eiweiss;
    double fett;
    double kohlenhydrate;
    double natrium;

    private Naehrstoffangabe(double portionsGroesse, int anzahlPortionen, double eiweiss, double fett, double kohlenhydrate, double natrium){
        this.portionsGroesse = portionsGroesse;
        this.anzahlPortionen = anzahlPortionen;
        this.eiweiss = eiweiss;
        this.fett = fett;
        this.kohlenhydrate = kohlenhydrate;
        this.natrium = natrium;
    }

    public int getAnzahlPortionen() {
        return anzahlPortionen;
    }

    public double getEiweiss() {
        return eiweiss;
    }

    public double getFett() {
        return fett;
    }

    public double getKohlenhydrate() {
        return kohlenhydrate;
    }

    public double getNatrium() {
        return natrium;
    }

    public double getPortionsGroesse() {
        return portionsGroesse;
    }

    public static class NaehrstoffangabeBuilder {
        double portionsGroesse;
        int anzahlPortionen;
        double eiweiss;
        double fett;
        double kohlenhydrate;
        double natrium;

        public NaehrstoffangabeBuilder(double portionsGroesse, int anzahlPortionen){
            this.portionsGroesse = portionsGroesse;
            this.anzahlPortionen = anzahlPortionen;
        }
        public NaehrstoffangabeBuilder eiweiss(double eiweiss){
            this.eiweiss = eiweiss;
            return this;
        }
        public NaehrstoffangabeBuilder fett(double fett){
            this.fett=fett;
            return this;
        }
        public NaehrstoffangabeBuilder kohlenhydrate(double kohlenhydrate){
            this.kohlenhydrate = kohlenhydrate;
            return this;
        }
        public NaehrstoffangabeBuilder natrium(double natrium){
            this.natrium = natrium;
            return this;
        }
        public Naehrstoffangabe build(){
            return new Naehrstoffangabe(portionsGroesse, anzahlPortionen, eiweiss, fett, kohlenhydrate, natrium);
        }
    }
    public static void main(String[] args) {
        Naehrstoffangabe angabe = new NaehrstoffangabeBuilder(250.0, 2)
                .eiweiss(12.5)
                .fett(8.0)
                .kohlenhydrate(30.0)
                .natrium(0.6)
                .build();

        System.out.println("Portionsgröße: " + angabe.getPortionsGroesse());
        System.out.println("Anzahl Portionen: " + angabe.getAnzahlPortionen());
        System.out.println("Eiweiß: " + angabe.getEiweiss());
        System.out.println("Fett: " + angabe.getFett());
        System.out.println("Kohlenhydrate: " + angabe.getKohlenhydrate());
        System.out.println("Natrium: " + angabe.getNatrium());
    }

}
