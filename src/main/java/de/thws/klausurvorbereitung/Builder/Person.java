package de.thws.klausurvorbereitung.Builder;

public class Person {
    private String vorname, nachname, strasse, ort, hobby;
    private int geburtsjahr, telefonnummer;



private  Person(String hobby, int geburtsjahr, String nachname, String ort, String strasse, int telefonnummer, String vorname) {
        this.hobby = hobby;
        this.geburtsjahr = geburtsjahr;
        this.nachname = nachname;
        this.ort = ort;
        this.strasse = strasse;
        this.telefonnummer = telefonnummer;
        this.vorname = vorname;
    }

    public static class Builder{
        public String vorname, nachname, strasse, ort, hobby;
        public int geburtsjahr, telefonnummer;

        public Builder(String vorname, String nachname, int geburtsjahr){
            this.vorname = vorname;
            this.nachname = nachname;
            this.geburtsjahr = geburtsjahr;
        }

        public Builder withStrasse(String strasse){
            this.strasse = strasse;
            return this;
        }
        public Builder withOrt(String ort){
            this.ort= ort;
            return this;
        }
        public Builder withTelefonnummer(int telefonnummer){
            this.telefonnummer= telefonnummer;
            return this;
        }
        public Person build(){
            return new Person(hobby, geburtsjahr, nachname, ort, strasse, telefonnummer, vorname);
        }

    }

    static void main() {
        Person p = new Person.Builder(" John ", "Doe", 1990)
                .withKoerpergroesse(188)
                .withWohnort(" Berlin ")
                .withGewicht(80)
                .build();
    }

}
