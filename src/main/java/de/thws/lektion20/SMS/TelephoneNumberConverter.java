package de.thws.lektion20.SMS;

import java.util.HashMap;
import java.util.Map;

public class TelephoneNumberConverter {

    private Map<Character, Character> tastenMap;

    public TelephoneNumberConverter() {
        tastenMap = new HashMap<>();
        initialisiereMap();
    }

    private void initialisiereMap() {
        tastenMap.put('A', '2');
        tastenMap.put('B', '2');
        tastenMap.put('C', '2');

        tastenMap.put('D', '3');
        tastenMap.put('E', '3');
        tastenMap.put('F', '3');

        tastenMap.put('G', '4');
        tastenMap.put('H', '4');
        tastenMap.put('I', '4');

        tastenMap.put('J', '5');
        tastenMap.put('K', '5');
        tastenMap.put('L', '5');

        tastenMap.put('M', '6');
        tastenMap.put('N', '6');
        tastenMap.put('O', '6');

        tastenMap.put('P', '7');
        tastenMap.put('Q', '7');
        tastenMap.put('R', '7');
        tastenMap.put('S', '7');

        tastenMap.put('T', '8');
        tastenMap.put('U', '8');
        tastenMap.put('V', '8');

        tastenMap.put('W', '9');
        tastenMap.put('X', '9');
        tastenMap.put('Y', '9');
        tastenMap.put('Z', '9');
    }

    public String convert(String text) throws IllegalTelephoneNumberException {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char zeichen = Character.toUpperCase(text.charAt(i));

            if (!tastenMap.containsKey(zeichen)) {
                throw new IllegalTelephoneNumberException(zeichen);
            }

            result.append(tastenMap.get(zeichen));
        }

        return result.toString();
    }
}
