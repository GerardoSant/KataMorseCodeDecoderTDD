
import java.util.HashMap;
import java.util.Map;

public class MorseCodeDecoder {

    public static void main(String[] args) {
        System.out.println(get(""));
    }


    public static String get(String morseCode) {
        return morseCode.isEmpty() ? "" : decode(morseCode);
    }

    private static String decode(String morseCode) {
        StringBuilder decodedString = new StringBuilder();
        return getWords(morseCode, decodedString);
    }

    private static String getWords(String morseCode, StringBuilder decodedString) {
        String[] words = morseCode.split("\\s\\s+");
        for (String word : words) {
            decodedString.append(' ');
            getLetters(decodedString, word);
        }
        return (decodedString.length()<1) ? "" : decodedString.substring(1);
    }

    private static void getLetters(StringBuilder decodedString, String word) {
        String[] letters = word.split("\\s");
        for (String letter : letters) {
            decodedString.append(MorseCodeDictionary.get(letter));
        }
    }

}