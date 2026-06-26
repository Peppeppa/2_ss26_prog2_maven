package de.thws.klausurvorbereitung.Probeklausur.aufgabe1;

abstract public class  ObservationInstrument {
   String name;
   int baujahr;
   int betriebszustand;

   public ObservationInstrument(String name, int baujahr){
       this.name = name;
       this.baujahr = baujahr;
       this.betriebszustand = 100;
   }

   public void calibrate(int value){
       if(value < 0){
           throw new IllegalArgumentException();
       }
      if(betriebszustand + value > 100){
         betriebszustand = 100;
      }else{
          betriebszustand += value;
      }
   }

   public int getOperatingStatus(){
       return betriebszustand;

   }
}
