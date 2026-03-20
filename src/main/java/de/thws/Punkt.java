package de.thws;

public class Punkt {
    int x;
    int y;

    public void verschiebePunkt(int zielX, int zielY) {
        if (zielX < 0 || zielX > 1920 || zielY <= 0 || zielY > 1080){
            throw new RuntimeException("ungueltig");
        }else {
            x = zielX;
            y = zielY;
        }
    }
}
