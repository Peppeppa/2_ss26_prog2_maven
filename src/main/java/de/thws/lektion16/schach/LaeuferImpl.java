package de.thws.lektion16.schach;

public class LaeuferImpl extends AbstractFigur implements Laeufer {
    public LaeuferImpl(int x, int y) {
        super(x, y);
    }

    public Brett gibErlaubteFelder() {
        Brett brett = new Brett();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; i < 8; i++) {
                brett.brett[i][j] = false;
            }
        }
        brett.markiereFeld(x, y);
        int pointerX = x;
        int pointerY = y;
        while (pointerX > 0 && pointerY > 0) {
            brett.markiereFeld(pointerX, pointerY);

            pointerX -= 1;
            pointerY -= 1;
        }
        pointerX = x;
        pointerY = y;
        while (pointerX < 9 && pointerY > 0) {
            brett.markiereFeld(pointerX, pointerY);

            pointerX += 1;
            pointerY -= 1;
        }
        pointerX = x;
        pointerY = y;
        while (pointerX < 9 && pointerY < 9) {
            brett.markiereFeld(pointerX, pointerY);

            pointerX += 1;
            pointerY += 1;
        }
        pointerX = x;
        pointerY = y;
        while (pointerX > 0 & pointerY < 9) {
            brett.markiereFeld(pointerX, pointerY);

            pointerX -= 1;
            pointerY += 1;
        }


        //TODO: Erg�nzen Sie den Algorithmus zur Bestimmung der Felder
        return brett;
    }

    public static void main(String[] args) {
        LaeuferImpl l = new LaeuferImpl(4, 5);
        Brett brett = l.gibErlaubteFelder();
        for (int j = 1; j <= 8; j++) {
            for (int i = 1; i <= 8; i++) {
                if (brett.gibFeld(i, j)) System.out.print("x");
                else System.out.print("o");
            }
            System.out.println();
        }
    }
}
