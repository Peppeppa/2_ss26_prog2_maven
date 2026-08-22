package de.thws.klausurvorbereitung.bibliothek;

public abstract class Buch implements Comparable<Buch> {

    String name;
    String autor;
    String verlag;
    int preisInCents;
    String reihe;

    public Buch(String name, String autor, String verlag, int preisInCents, String reihe)
    {
        this.name = name;
        this.autor = autor;
        this.verlag = verlag;
        this.preisInCents = preisInCents;
        this.reihe = reihe;
    }
    public String getName(){return this.name;}
    public String getAuthor(){return this.autor;}
    @Override
    public int compareTo(Buch anderesBuch){
        int autorvergleich = this.autor.compareTo(anderesBuch.getAuthor());

        if (autorvergleich != 0){
            return autorvergleich;
        }
        return this.name.compareTo(anderesBuch.getName());
    }
}
