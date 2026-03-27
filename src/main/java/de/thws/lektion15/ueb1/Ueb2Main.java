package de.thws.lektion15.ueb1;


public class Ueb2Main {
    public static void main(String[] args){

        Person[] prog2 = getPeople();
        extracted(prog2);
    }

    private static void extracted(Person[] prog2) {
        for (int i = 0; i<100;i++){
            System.out.println(prog2[i].gibTaetigkeitAus());
        }
    }

    private static Person [] getPeople() {
        Person[] prog2= new Person[100];
        for (int i = 0; i<100;i++){
            if (i%2==0){
                prog2[i]=new Student("besucht","Programmieren");
            }
            else{
                prog2[i]=new Professor("lehrt", "Programmieren");
            }
        }
        return prog2;
    }
}
