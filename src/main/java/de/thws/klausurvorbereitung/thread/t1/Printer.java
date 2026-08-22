package de.thws.klausurvorbereitung.thread.t1;

public class Printer {

    Thread thread;

    public void printNumbers() {
        thread = new Thread(()-> {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }});
        thread.start();
    }

    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.printNumbers();
    }
}