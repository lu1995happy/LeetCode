import java.util.*;

public class missingWords {
    public List<String> findMissingWords(String s, String t) {
        String[] sWords = s.split(" ");
        String[] tWords = t.split(" ");
        int sPointer = 0, tPointer = 0;
        List<String> res = new ArrayList<>();
        while (tPointer < tWords.length && sPointer < sWords.length) {
            if (sWords[sPointer].equals(tWords[tPointer])) {
                sPointer++;
                tPointer++;
            } else {
                res.add(sWords[sPointer]);
                sPointer++;
            }
        }
        if (sPointer != sWords.length) {
            for (int i = sPointer; i < sWords.length; i++) {
                res.add(sWords[sPointer]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        missingWords test = new missingWords();
        System.out.println(test.findMissingWords("I am a dog what A pig is", "am dog pig"));
        System.out.println(test.findMissingWords("I am using hackerrank to improve programming", "am hackerrank to improve"));

    }

}