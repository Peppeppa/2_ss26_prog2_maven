package de.thws.klausurvorbereitung.thread.t1;

public class Countdown {
    Thread thread;

    public void startCountdown() throws InterruptedException{
        thread = new Thread(()->{

        for (int i = 5; i >= 1; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Los!");});

        thread.start();

    }

    public static void main(String[] args) {
        Countdown countdown = new Countdown();
        try{countdown.startCountdown();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
