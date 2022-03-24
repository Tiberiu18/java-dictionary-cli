package TestCases.tests;

import Common.Constants;
import Methods.TranslateSentenceSynonyms;

import java.util.List;

public final class TestTranslateSynonyms {
    private TestTranslateSynonyms() {}

    public static void testTranslateSynonyms()
    {
        System.out.println("\n---- Testing Translate Sentences Synonyms ----");


        System.out.println("\n---- TestCase 1 Translate sentences using synonyms ----");
        String sentence = " +chat *! diplômé,  ?manger ... salut";
        List<String> translatedSentences = TranslateSentenceSynonyms.translateSentences(sentence, Constants.FRENCH_LANGUAGE_CODE, Constants.ROMANIAN_LANGUAGE_CODE);
        if(!translatedSentences.isEmpty()) {
            for (String translatedSentence : translatedSentences) {
                System.out.println(sentence + " -> " + translatedSentence);
            }
        }

        System.out.println("--- TranslateSentenceSynonyms - Testcase (2) ---");
        sentence = "buna!~cum.. te simti ?";

        translatedSentences = TranslateSentenceSynonyms.translateSentences(sentence, Constants.ROMANIAN_LANGUAGE_CODE, Constants.FRENCH_LANGUAGE_CODE);


        if(!translatedSentences.isEmpty()) {
            for (String translatedSentence : translatedSentences) {
                System.out.println(sentence + " -> " + translatedSentence);
            }
        }
        System.out.println();


    }
}
