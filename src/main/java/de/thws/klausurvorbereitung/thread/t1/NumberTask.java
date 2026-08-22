package de.thws.klausurvorbereitung.thread.t1;

public class NumberTask implements Runnable {

    private int limit;

    public NumberTask(int limit) {
        this.limit = limit;
    }

    @Override
    public void run() {
        for (int i = 0; i < limit; i++){
            System.out.println(i);
        }
    }

    static void main() {
        new Thread(new NumberTask(10)).start();
        new Thread(new NumberTask(2)).start();
    }
}