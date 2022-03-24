package utils;

import Entities.Word;
import deserialization.DeserializeJson;

import java.util.List;
import java.util.Map;

public final class Printers {
    private Printers() {}

    public static boolean checkLanguageExists(String language)
    {
        Map<String, List<Word>> wordsMap = DeserializeJson.getWordsMap();
        if ( (! wordsMap.containsKey(language) ))
        {
            System.out.println("The language with the code " + language + " is not present in the database!");
            return false;
        }
        return true;
    }

    public static boolean checkWordExistsInLanguage(String word, String language)
    {
        Word w = FilterEntityWord.filterByNameAndLanguage(word, language);
        if( w == null)
        {
            System.out.println("The word " + word + " is not present in the dictionary!(" + language +")");
            return false;
        }
        return true;
    }
}
