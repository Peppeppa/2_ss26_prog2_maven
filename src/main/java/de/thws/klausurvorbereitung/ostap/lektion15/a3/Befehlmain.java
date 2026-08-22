package de.thws.klausurvorbereitung.ostap.lektion15.a3;

public class Befehlmain {
    static void main() {
        Befehl[] befehle = {
                Befehl.START,
                Befehl.PAUSE,
                Befehl.STOP,
                Befehl.RESET
        };

        for (Befehl befehl : befehle) {
            befehl.ausführen();

        }
}

}
