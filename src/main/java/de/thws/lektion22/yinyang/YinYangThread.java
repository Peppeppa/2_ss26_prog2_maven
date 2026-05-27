package de.thws.lektion22.yinyang;

public class YinYangThread extends Thread{
    String nachricht;

    public YinYangThread(String nachricht){
        this.nachricht = nachricht;
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
