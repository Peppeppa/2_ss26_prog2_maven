package de.thws.klausurvorbereitung.StreamingAPI.streams;
import java.util.*;

public class Level7 {
   // Summe mit reduce
   public static int sumNumbers(List<Integer> numbers){
       return numbers.stream()
               .reduce(0, Integer::sum);
   }
// Alle Wörter verbinden
    public static String joinWords(List<String> words){
       return words.stream()
               .reduce(" ", (a, b) -> a + " " + b)
               .orElse("");
    }
    //Längstes Wort finden
    public static Optional<String> findLongestWord(List<String> words){

        return words.stream()
               .reduce((a,b)->a.length() >= b.length() ? a : b);
    }
}
