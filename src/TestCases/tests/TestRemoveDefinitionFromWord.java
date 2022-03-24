package TestCases.tests;

import Entities.Definitions;
import Methods.RemoveDefinitionFromWord;

public final class TestRemoveDefinitionFromWord {
    private TestRemoveDefinitionFromWord() {}

    public static void testRemoveDefinition()
    {
        System.out.println("\n---- Testing Remove Definition for Word ----");


        System.out.println("---- TestCase1 Remove Definition----");
        String dict = "Dicționarul explicativ al limbii române (ediția a II-a revăzută și adăugită)";
        RemoveDefinitionFromWord.removeDefinition("câine", "ro", dict);
    }
}
