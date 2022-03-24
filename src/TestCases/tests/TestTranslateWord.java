package TestCases.tests;

import Methods.TranslateWord;

public final class TestTranslateWord {
    private TestTranslateWord() {}


    public static void testCaseTranslateWord()
    {
        System.out.println("\n---- Testing Translating Word ----");

        System.out.println("---- Testcase 1 Translate Word ----");
        TranslateWord.translateWord("chat", "fr", "ro");

        System.out.println("---- Testcase 2 Translate Word ----");
        TranslateWord.translateWord("pisică", "ro", "fr");

        System.out.println("---- Testcase 3 Translate Word ----");
        TranslateWord.translateWord("calculator", "ro", "fr");

    }
}
