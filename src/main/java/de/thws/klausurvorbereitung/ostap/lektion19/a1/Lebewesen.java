package de.thws.klausurvorbereitung.ostap.lektion19.a1;

public abstract class Lebewesen {
   String name;

   public Lebewesen (String name){
       this.name = name;
   }
   abstract void beschreibe();
}
