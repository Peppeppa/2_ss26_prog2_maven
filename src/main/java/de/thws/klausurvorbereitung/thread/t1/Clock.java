package de.thws.klausurvorbereitung.thread.t1;

public class Clock {

    private Thread thread;
    private volatile boolean cancelled = false;

    public void start() {
        thread = new Thread(() -> {
            try {
                while (!cancelled) {
                    System.out.println("Tick");
                    Thread.sleep(5000);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        thread.start();
    }

    public void cancel() {
        cancelled = true;
        if(thread != null){
            thread.interrupt();
        }
    }
}