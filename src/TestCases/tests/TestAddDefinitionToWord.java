package TestCases.tests;

import Entities.Definitions;
import Methods.AddDefinitionToWord;

public final class TestAddDefinitionToWord {
    private TestAddDefinitionToWord() {}

    public static void testAddDefinitionToWord()
    {
        System.out.println("\n---- Testing AddDefinitionToWord ----");

        System.out.println("\n---- TestCase 1 AddDefinitionToWord ----");
        Definitions d = new Definitions("Dictionarul universal al limbii romane ( Editia a X-a)", "definitions", 2007, new String[]{"animal mic de statura"});
        AddDefinitionToWord.addDefinitionToWord("câine", "ro", d);

        System.out.println("\n---- TestCase 2 AddDefinitionToWord ----");
        d = new Definitions("Dicționar universal al limbei române, ediția a VI-a)", "definitions", 2007, new String[]{"animal mic de statura"});
        AddDefinitionToWord.addDefinitionToWord("câine", "ro", d);



    }
}
