package de.thws;

public class Kugelvolumen {

    public static double berechneKugelvolumen(double radius)
    {
        if(radius < 0){
            throw new RuntimeException("nix negatives");
        }else{
            return 4.0/3.0*Math.PI*radius*radius*radius;
        }
    }
}
