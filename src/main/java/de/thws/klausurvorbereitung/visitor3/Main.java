package de.thws.klausurvorbereitung.visitor3;

public class Main {

    public static void main(String[] args) {
        Ordner root = new Ordner("root");

        Datei datei1 = new Datei("text.txt", 10);
        Datei datei2 = new Datei("bild.png", 50);

        Ordner unterordner = new Ordner("dokumente");
        Datei datei3 = new Datei("vertrag.pdf", 100);
        Datei datei4 = new Datei("rechnung.pdf", 30);

        unterordner.add(datei3);
        unterordner.add(datei4);

        root.add(datei1);
        root.add(datei2);
        root.add(unterordner);

        GroessenVisitor visitor = new GroessenVisitor();

        root.accept(visitor);

        System.out.println("Gesamtgröße: " + visitor.getGesamtGroesse());
    }
}