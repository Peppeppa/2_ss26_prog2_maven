package de.thws.lektion22.yinyang;

public class YinInterface implements Runnable{
    String nachricht;

    public YinInterface(String nachricht){
        this.nachricht = nachricht;
    }

    public static void main(String[]args){
        YinInterface y1 = new YinInterface("yin");
        YinInterface y2 = new YinInterface("yang");
        Thread t1 = new Thread(y1);
        Thread t2 = new Thread(y2);

        t1.start();
        t2.start();

    }
    @Override
    public void run(){
        while (true){
            System.out.println(nachricht);

            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
                break;
            }
        }

    }

}
