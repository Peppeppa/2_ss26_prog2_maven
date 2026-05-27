package de.thws.lektion22.yinyang;

public class YinMain {
    public static void main(String[] args) throws InterruptedException {
        while(true){
            new YinYangThread("yin").start();
            new YinYangThread("yang").start();

        }

    }
}
