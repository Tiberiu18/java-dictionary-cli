package TestCases.tests;

import Methods.RemoveWord;
import TestCases.Test;
import deserialization.DeserializeJson;

public final class TestRemoveWord {
    private TestRemoveWord() {}

    public static void testRemoveWord(){
        System.out.println("---- TestCases Remove Word----");

        System.out.println("---- Test 1 Remove Word ---- ");
        RemoveWord.removeWord("merge", "ro");
    }
}
