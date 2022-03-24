package TestCases.tests;

import Entities.Definitions;
import Entities.Word;
import deserialization.DeserializeJson;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import Methods.AddWord;
public final class TestAddWord {
    private TestAddWord() {}

    public static void TestAddWord()
    {
        System.out.println("--- Test add word ----");

        System.out.println("---- Test 1 ----");
        Definitions defFrigider = new Definitions("Dictionarul limbii romane", "definitions", 1950, new String[]{"Aparat special"});
        Word word = new Word("frigider", "fridge", "noun", Arrays.asList("frigider"), Arrays.asList("frigidere"), Arrays.asList(defFrigider));
        AddWord.addWord(word, "ro");
        List<Word> wordList = DeserializeJson.getWordsMap().get("ro");
        List<Word> w = wordList.stream().filter(p -> p.getWordName().equals(word.getWordName())).collect(Collectors.toList());
        System.out.println(w.get(0));


        System.out.println("---- Test 2 ----");
        AddWord.addWord(word, "ru");
    }
}
