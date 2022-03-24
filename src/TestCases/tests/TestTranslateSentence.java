package TestCases.tests;

import Methods.TranslateSentence;

public final class TestTranslateSentence {
    private TestTranslateSentence() {}

    public static void testTranslateSentence()
    {
        System.out.println("\n---- Testing Translate Sentence----");


        System.out.println("---- Testcase1 Translate Sentence----");
        //String sentence = "Tiberiu.,; este foarte înalt. [El] este- un erou   ";
        String sentence = "+chat *! diplômé,  ?manger ... salut";
        String translatedSentence = TranslateSentence.translateSentence(sentence, "ro", "fr");
        System.out.println("--- Translated sentence = " + translatedSentence);

        System.out.println("\n---- TestCase2 Translate Sentence ----");
        sentence = "Tiberiu son très haute il son héros ";
        translatedSentence = TranslateSentence.translateSentence(sentence, "fr", "ro");
        System.out.println("--- Translated sentence = " + translatedSentence);
    }
}
