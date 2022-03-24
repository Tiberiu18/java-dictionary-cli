package Methods;

import Entities.Word;
import deserialization.DeserializeJson;
import utils.FilterEntityWord;
import utils.Printers;

import java.util.List;
import java.util.Map;


public final class RemoveWord {
    private RemoveWord() {}

    public static boolean removeWord(String word, String language)
    {
        if( !Printers.checkLanguageExists(language))
            return false;

        Word w = FilterEntityWord.filterByNameAndLanguage(word, language);
        if( w == null)
        {
            System.out.println("The word " + word + " is not present in the dictionary!" + language +")");
            return false;
        }
        else
        {
            DeserializeJson.getWordsMap().get(language).remove(w);
            System.out.println("The word " + word + " has been succesfully deleted from the dictionary with language code " + language + "");
            return true;
        }
    }
}
