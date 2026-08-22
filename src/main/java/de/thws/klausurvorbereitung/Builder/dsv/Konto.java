package de.thws.klausurvorbereitung.Builder.dsv;

class Konto {

    private String inhaber;
    private String iban;

    private Konto() {
    }

    public static InhaberSchritt builder() {
        return new KontoBuilder();
    }

    interface InhaberSchritt {
        IbanSchritt mitInhaber(String inhaber);
    }

    interface IbanSchritt {
        FertigSchritt mitIban(String iban);
    }

    interface FertigSchritt {
        Konto erstellen();
    }

    private static class KontoBuilder
            implements InhaberSchritt, IbanSchritt, FertigSchritt {

        private Konto konto = new Konto();

        public IbanSchritt mitInhaber(String inhaber) {
            konto.inhaber = inhaber;
            return this;
        }

        public FertigSchritt mitIban(String iban) {
            konto.iban = iban;
            return this;
        }

        public Konto erstellen() {
            return konto;
        }
    }

    static void main() {
        Konto k = Konto.builder()
                .mitInhaber("fds")
                .mitIban("dsfcv")
                .erstellen();
    }
}