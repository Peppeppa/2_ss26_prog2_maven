package de.thws.lektion14;

public class A4Strecke {
    int a;
    int b;

    public A4Strecke(int a, int b){
        if (a<=0 || b<=0){
            throw new IllegalArgumentException("nur ganzzahlige positive Zahlen");
        }
        if (a<b){
            this.a = a;
            this.b = b;
        }else{
            this.a = b;
            this.b = a;
        }
    }
    public boolean ueberschneidung(A4Strecke y){
        return this.b > y.a && y.b > this.a;
    }

    @Override
    public String toString() {
        if (a == b) return String.valueOf(a);

        String result = "" + a;

        for (int i = 0; i < (b - a); i++) {
            result += "-";
        }


        return result + b;
    }
}
