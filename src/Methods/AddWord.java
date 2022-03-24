package Methods;

import Entities.Word;
import deserialization.DeserializeJson;
import utils.FilterEntityWord;
import utils.Printers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class AddWord {
    private AddWord(){}

    // Map<Language_Name, List_Of_Words>
    private static final Map<String, List<Word>> wordsMap = DeserializeJson.getWordsMap();

    public static boolean addWord(Word word, String language)
    {
        if( !Printers.checkLanguageExists(language))
            return false;
        else
        {
            List<Word> wordList = wordsMap.get(language);
            Word w = FilterEntityWord.filterByNameAndLanguage(word.getWordName(), language);
            if( w == null )
            {
                wordsMap.get(language).add(word);
                return true;
            }
            else
            {
                System.out.println("The word " + word.getWordName() + " already exists in the language code " + language + " database");
                return false;
            }
        }
    }
}
