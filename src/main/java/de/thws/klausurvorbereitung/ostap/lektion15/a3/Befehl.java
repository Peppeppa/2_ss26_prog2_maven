package de.thws.klausurvorbereitung.ostap.lektion15.a3;

enum Befehl {
    START {
        @Override
        public void ausführen() {
            System.out.println("System wird gestartet.");
        }
    },
    STOP {
        @Override
        public void ausführen() {
            System.out.println("System wird gestoppt.");
        }
    },
    PAUSE {
        @Override
        public void ausführen() {
            System.out.println("System wird pausiert.");
        }
    },
    RESET {
        @Override
        public void ausführen() {
            System.out.println("System wird zurückgesetzt.");
        }
    };
    public abstract void ausführen();
}