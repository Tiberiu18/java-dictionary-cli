package TestCases.tests;

import Common.Constants;
import Entities.Definitions;
import Methods.GetDefinitionsForWord;

import java.util.List;

public final class TestGetDefinitionForWord {
    private TestGetDefinitionForWord() {}

    public static void testGetDefinitionForWord()
    {
        System.out.println("--- GetDefinitionsForWord - Testcase (1) ---");
        List<Definitions> definitions = GetDefinitionsForWord.getDefinitionsforWord("câine", Constants.ROMANIAN_LANGUAGE_CODE);
        if(!definitions.isEmpty()) {
            for (Definitions definition: definitions) {
                System.out.println(definition);
            }
        }

        System.out.println("--- GetDefinitionsForWord - Testcase (2) ---");
        definitions = GetDefinitionsForWord.getDefinitionsforWord("câine", Constants.FRENCH_LANGUAGE_CODE);
        if(!definitions.isEmpty()) {
            for (Definitions definition: definitions) {
                System.out.println(definition);
            }
        }
        System.out.println();
    }
}
