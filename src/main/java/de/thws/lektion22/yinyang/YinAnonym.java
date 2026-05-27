package de.thws.lektion22.yinyang;

public class YinAnonym {

    public static void main(String[] args) {
        String n1 = "yin";
        String n2 = "yang";

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(n1);

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        });

        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(n2);

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };

        t1.start();
        t2.start();
    }

}
