package easy;

import java.util.HashSet;
import java.util.Set;

public class RemoveVowelsFromAString {
    private static final Set<Character> vowelsToIgnoreSet;
    static {
        vowelsToIgnoreSet = new HashSet<>();
        vowelsToIgnoreSet.add('a');
        vowelsToIgnoreSet.add('e');
        vowelsToIgnoreSet.add('i');
        vowelsToIgnoreSet.add('o');
        vowelsToIgnoreSet.add('u');
    }

    public String removeVowelsReadableVersion(String s) {
        StringBuilder sb = new StringBuilder();
        for(int charIndex = 0; charIndex < s.length(); charIndex++) {
            Character currentCharacter = s.charAt(charIndex);
            if (!vowelsToIgnoreSet.contains(currentCharacter)) {
                sb.append(currentCharacter);
            }
        }
        return sb.toString();
    }

    public String removeVowels(String s) {
        boolean[] map = new boolean[26];
        map['a' - 'a'] = true;
        map['e' - 'a'] = true;
        map['i' - 'a'] = true;
        map['o' - 'a'] = true;
        map['u' - 'a'] = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) if( !map[s.charAt(i) - 'a'] ) sb.append(s.charAt(i));
        return sb.toString();
    }
}
