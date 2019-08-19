package easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWordsProblem {
    private static final String[] MORSE_ALPHABET = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    private static final StringBuffer sb = new StringBuffer();
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> morseWordsSet = new HashSet<>();
        for (String word: words) morseWordsSet.add(convertWordIntoMorseWord(word));
        return morseWordsSet.size();
    }
    private String convertWordIntoMorseWord(String word) {
        sb.setLength(0);
        for(int i = 0; i < word.length(); i++) sb.append(MORSE_ALPHABET[word.charAt(i) - 'a']);
        return sb.toString();
    }
}
