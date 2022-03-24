package TestCases;
import TestCases.tests.*;

public final class Test {
    private Test(){}

    public static void runTests()
    {
        TestAddWord.TestAddWord();

        TestRemoveWord.testRemoveWord();

        TestAddDefinitionToWord.testAddDefinitionToWord();

        TestRemoveDefinitionFromWord.testRemoveDefinition();

        TestTranslateWord.testCaseTranslateWord();

        TestTranslateSentence.testTranslateSentence();

        TestTranslateSynonyms.testTranslateSynonyms();

        TestGetDefinitionForWord.testGetDefinitionForWord();

        TestExportDictionaries.testExportDictionaries();


    }
}
