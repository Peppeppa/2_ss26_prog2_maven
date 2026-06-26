package de.thws.klausurvorbereitung.StreamingAPI.streams;

public class Student {

    private String name;
    private int alter;
    private String studiengang;
    private double note;

    public Student(String name, int alter, String studiengang, double note) {
        this.name = name;
        this.alter = alter;
        this.studiengang = studiengang;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public int getAlter() {
        return alter;
    }

    public String getStudiengang() {
        return studiengang;
    }

    public double getNote() {
        return note;
    }

    @Override
    public String toString() {
        return name + " (" + alter + ", " + studiengang + ", " + note + ")";
    }
}
