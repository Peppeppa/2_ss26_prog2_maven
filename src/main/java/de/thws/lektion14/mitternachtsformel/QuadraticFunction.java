package de.thws.lektion14.mitternachtsformel;

public class QuadraticFunction {

    double a;
    double b;
    double c;

    public QuadraticFunction(int a, int b, int c){

        if(a==0){
            throw new IllegalArgumentException("a darf nicht 0 sein");
        }
        this.a=a;
        this.b = b;
        this.c = c;
    }

    public double[] roots(){
        double diskriminante = b*b-4*a*c;
        if (diskriminante < 0){
            return new double[0];
        }

        if (diskriminante == 0){
            double x = -b / (2*a);
            return new double[] {x};
        }

        double sqrtDiskriminante = Math.sqrt(diskriminante);

        double x1 = (-b + sqrtDiskriminante)/(2*a);
        double x2 = (-b - sqrtDiskriminante)/(2*a);

        double[] roots = new double[]{x1,x2};
        return roots;
    }


}
