package Lab5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public class Task5_1 {
    // множество звонких согласных букв в русском алфавите
    private static final Set<Character> VOICED_CONSONANTS = new HashSet<>(Arrays.asList(
            'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'л', 'м', 'н', 'р'
    ));


    // находит все уникальные звонкие согласные буквы в тексте
    public static Set<Character> findVoicedConsonants(String text) {
        Set<Character> result = new TreeSet<>();  // TreeSet для автоматической сортировки

        String lowerText = text.toLowerCase();

        // проходим по всем символам текста
        for (char c : lowerText.toCharArray()) {
            if (VOICED_CONSONANTS.contains(c)) {
                result.add(c);
            }
        }

        return result;
    }
}