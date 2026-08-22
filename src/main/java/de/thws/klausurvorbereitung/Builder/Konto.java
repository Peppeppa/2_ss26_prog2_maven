package de.thws.klausurvorbereitung.Builder;

public class Konto {
    private String inhaber;
    private String iban;

//    private Konto(String inhaber, String iban){
//        this.inhaber = inhaber;
//        this.iban = iban;
//    }

    public static InhaberSchritt builder(){
        return new Builder();
    }



    private static class Builder implements InhaberSchritt, IbanSchritt, FertigSchritt{
//       private String inhaber;
//       private String iban;
//
        private Konto konto = new Konto();

//       private Builder(){
//
//       }

       public IbanSchritt mitInhaber(String inhaber){
//           this.inhaber=inhaber;
           konto.inhaber= inhaber;
           return this;
       }
       public FertigSchritt mitIban(String iban){
//           this.iban = iban;
           konto.iban = iban;
           return this;
       }
       public Konto erstellen(){
//            return new Konto(inhaber, iban);
           return konto;
       }
    }


    static void main() {
        Konto k = new Konto.builder()

    }



}
