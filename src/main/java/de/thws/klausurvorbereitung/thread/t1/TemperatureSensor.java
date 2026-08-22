package de.thws.klausurvorbereitung.thread.t1;

import java.util.function.Consumer;

public class TemperatureSensor {

    Consumer<Integer> consumer;
    private int temperature = 20;

    public void measure() {
        temperature = temperature + 1;
        System.out.println("Temperatur: " + temperature);
        consumer.accept(temperature);
    }

}