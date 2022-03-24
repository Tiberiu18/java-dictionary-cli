package utils;

import org.apache.commons.lang3.ArrayUtils;

public final class TokenizeString {
    private TokenizeString() {}


    public static String[] tokenize(String sentence)
    {
        String[] words = sentence.split("[\\s/\\[\\],+~.;?!*()-]+");
        words = ArrayUtils.removeElement(words, "");
        return words;
    }
}
