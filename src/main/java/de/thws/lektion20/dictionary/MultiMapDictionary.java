package de.thws.lektion20.dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MultiMapDictionary {


    private Map<String, Set<String>> dictionary;

    public MultiMapDictionary() {
        dictionary = new HashMap<>();
    }

    public void put(String english, String german) {
        if (!dictionary.containsKey(english)) {
            dictionary.put(english, new HashSet<>());
        }

        dictionary.get(english).add(german);
    }

    public Set<String> get(String english) {
        if (!dictionary.containsKey(english)) {
            return new HashSet<>();
        }

        return dictionary.get(english);
    }


}
