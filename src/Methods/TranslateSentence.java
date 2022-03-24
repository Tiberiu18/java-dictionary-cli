package Methods;

import Entities.Word;
import deserialization.DeserializeJson;
import org.apache.commons.lang3.ArrayUtils;
import utils.Printers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class TranslateSentence {
    private TranslateSentence() {}



    public static String translateSentence(String sentence, String fromLanguage, String toLanguage)
    {
        if( !Printers.checkLanguageExists(fromLanguage) || !Printers.checkLanguageExists(toLanguage)) // do  testcase to see if error message will be correctly displayed
        {
            return null;
        }

        String[] words = sentence.split("[\\s/\\[\\],~+.;?!*()-]+");
        words = ArrayUtils.removeElement(words, "");
        String[] translatedWords = new String[words.length];
        StringBuilder translatedSentence = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            translatedWords[i] = TranslateWord.translateWord(words[i], fromLanguage, toLanguage);
            if( translatedWords[i] == null )
                translatedSentence.append(words[i]).append(" ");
            else
                translatedSentence.append(translatedWords[i]).append(" ");
        }

        return translatedSentence.toString();
    }
}
