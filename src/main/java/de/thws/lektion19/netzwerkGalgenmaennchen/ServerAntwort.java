package de.thws.lektion19.netzwerkGalgenmaennchen;

import java.io.Serializable;

public class ServerAntwort implements Serializable {
    private final String anzeige;
    private final boolean wortErraten;
    private final boolean spielBeendet;
    private final boolean treffer;

    public ServerAntwort(String anzeige, boolean wortErraten, boolean spielBeendet, boolean treffer) {
        this.anzeige = anzeige;
        this.wortErraten = wortErraten;
        this.spielBeendet = spielBeendet;
        this.treffer = treffer;
    }

    public String getAnzeige() {
        return anzeige;
    }

    public boolean isWortErraten() {
        return wortErraten;
    }

    public boolean isSpielBeendet() {
        return spielBeendet;
    }

    public boolean isTreffer() {
        return treffer;
    }
}