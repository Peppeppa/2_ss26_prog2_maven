package de.thws.klausurvorbereitung.thread.t1;

public class BackgroundPrinter {

    Thread thread;

    public void startPrinting() {
        thread = new Thread(() -> {
            for (int i = 1; i <= 20; i++) {
                System.out.println("Zahl: " + i);
            }
        });

        thread.start();
    }
    public boolean isRunning(){

        return thread != null && thread.isAlive();
    }
}