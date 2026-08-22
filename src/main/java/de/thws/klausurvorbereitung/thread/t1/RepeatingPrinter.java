package de.thws.klausurvorbereitung.thread.t1;

public class RepeatingPrinter {

    private boolean canceled = false;
    private Thread thread;

    public void start() {
        thread = new Thread(() -> {
            int counter = 1;

            while (!canceled) {
                System.out.println("Durchlauf: " + counter);
                counter++;
            }
        });

        thread.start();
    }
    public void cancel(){
       canceled = true;
    }
}