package de.thws.lektion24;

import java.util.List;
import java.util.stream.Collectors;

public class BBruder {
    String name;
    int bankDrueckenGewicht;
    int knieBeugenGewicht;

    public BBruder(String name, int bankDrueckenGewicht, int
            knieBeugenGewicht) {
        this.name = name;
        this.bankDrueckenGewicht = bankDrueckenGewicht;
        this.knieBeugenGewicht = knieBeugenGewicht;
    }

    @Override
    public String toString() {
        return String.format(
                "Name: %s, Bankdrücken: %dkg, Kniebeugen %dkg",
                name, bankDrueckenGewicht, knieBeugenGewicht);
    }

    public static void main(String[] args) {
        List<BBruder> bBrothers = List.of(new BBruder("Burt", 238, 311),
                new BBruder("Bronski", 200, 274),
                new BBruder("Bruno", 236, 328));

        //reduce with Binary Operator
        bBrothers.stream()
                .reduce((b1, b2) -> new BBruder(
                        b1.name + " " + b2.name,
                        0,
                        0))
                .ifPresent(b -> System.out.println(b.name));

        //verbessert
        bBrothers.stream()
                .map(s -> s.name)
                .reduce((b1, b2) -> b1 + " " + b2)
                .ifPresent(System.out::println);


        bBrothers.stream()
                .reduce((b1, b2) -> new BBruder(
                        "durchschnittsbankdrücker",
                        b1.bankDrueckenGewicht + b2.bankDrueckenGewicht,
                        0))
                .ifPresent(b -> System.out.println(b.bankDrueckenGewicht / (bBrothers.size() * 1.0)));


        // verbessert
        bBrothers.stream()
                .map(b -> b.bankDrueckenGewicht) // mappt das bankdrüeckgewicht auf die bbruder objekte -> kann
                .reduce((bankdrueckgewicht1, bankDrueckgewicht2) -> bankdrueckgewicht1 + bankDrueckgewicht2)
                .ifPresent(b -> System.out.println(b / (double) (bBrothers.size() * 1.0)));

        //chatGPT:
        int summe = bBrothers.stream()
                .map(b -> b.bankDrueckenGewicht)
                .reduce(0, (g1, g2) -> g1 + g2);

        System.out.println(summe / (double) bBrothers.size());


        int summe2 = bBrothers.stream()
                .map(b -> b.bankDrueckenGewicht)
                .reduce(0, Integer::sum);

        System.out.println(summe2 / (double) bBrothers.size());


        String namensliste = bBrothers.stream()
                .map(b -> b.name)
                .collect(Collectors.joining(", "));
        System.out.println(namensliste);

        bBrothers.stream()
                .mapToDouble(p -> p.bankDrueckenGewicht)
                .average()
                .ifPresent(System.out::println);

    }
}