package de.thws.lektion20.dictionary;

import java.util.Set;

public class MainDictionary {

    public static void main(String[] args) {

        MultiMapDictionary dictionary = new MultiMapDictionary();

        dictionary.put("to clean", "reinigen");
        dictionary.put("to clean", "säubern");
        dictionary.put("to clean", "putzen");

        dictionary.put("to expand", "vergrößern");
        dictionary.put("to expand", "wachsen");

        dictionary.put("to clean", "putzen");

        Set<String> cleanTranslations = dictionary.get("to clean");
        Set<String> expandTranslations = dictionary.get("to expand");
        Set<String> unknownTranslations = dictionary.get("to fly");

        System.out.println("to clean -> " + cleanTranslations);
        System.out.println("to expand -> " + expandTranslations);
        System.out.println("to fly -> " + unknownTranslations);
    }
}
