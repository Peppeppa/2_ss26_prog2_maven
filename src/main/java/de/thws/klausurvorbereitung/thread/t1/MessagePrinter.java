package de.thws.klausurvorbereitung.thread.t1;

public class MessagePrinter implements Runnable{

    public void run(){
        for (int i = 0; i < 5;i++){
            System.out.println(i);
        }
    }
}
class DotPrinter implements Runnable{

    public void run(){



    }
}
