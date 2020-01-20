import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MorseCodeDecoder {

    public static void main(String[] args) {
        System.out.println(MorseCodeDecoder.get(".... . -.--     .--- ..- -.. ."));
    }

    public static String get(String morseCode) {
        return morseCode.isEmpty() ? "" : decode(morseCode);
    }


    private static String decode(String morseCode){
        return getCodedWords(morseCode).stream()
                .map(codedWord-> decodeWord(codedWord))
                .reduce("",(decodedMorseCode,decodedWord)-> decodedMorseCode + " " + decodedWord).trim();
    }

    private static String decodeWord(String codedWord) {
        return getCodedLetters(codedWord).stream()
                .map(codedLetter-> decodeLetter(codedLetter))
                .reduce("",String::concat);
    }

    private static List<String> getCodedWords(String morseCode) {
        return new ArrayList<>(Arrays.asList(morseCode.split(RegularExpression.MANY_SPACES)));
    }

    private static List<String> getCodedLetters(String codedWord) {
        return new ArrayList<>(Arrays.asList(codedWord.split(RegularExpression.ONE_SPACE)));
    }

    private static String decodeLetter(String codedLetter) {
        return MorseCodeDictionary.get(codedLetter);
    }

    private static class RegularExpression{
        private final static String MANY_SPACES="\\s\\s+";
        private final static String ONE_SPACE="\\s";
    }

}