package Methods;

import Entities.Word;
import deserialization.DeserializeJson;
import org.apache.commons.lang3.StringUtils;
import utils.FilterEntityWord;
import utils.Printers;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class TranslateWord {
    private TranslateWord() {}


    private static Word closestMatchWord(List<Word> wordList, String word)
    {
        int distance = Integer.MAX_VALUE;
        Word closestM = null;
        for(Word currW: wordList)
        {
            int currDist = StringUtils.getLevenshteinDistance(word, currW.getWordName());
            if(currDist < distance) {
                distance = currDist;
                closestM = currW;
            }
        }

        if ( distance > 0.25*word.length() ) // not good
        {
            return  null;
        }

        return closestM;
    }




    public static String translateWord(String word, String fromLanguage, String toLanguage)
    {
        if(word.isEmpty() || fromLanguage.isEmpty() || toLanguage.isEmpty())
            return null;
        word = word.toLowerCase();

        if(toLanguage.equals(fromLanguage))
        {
            return word;
        }


        if( !Printers.checkLanguageExists(fromLanguage) || !Printers.checkLanguageExists(toLanguage))
            return null;


        List<Word> fromLanguageWordList = DeserializeJson.getWordsMap().get(fromLanguage);
        List<Word> toLanguageWordList = DeserializeJson.getWordsMap().get(toLanguage);

        if(fromLanguageWordList.isEmpty())
        {
            System.out.println("Currently there are no words in our database for the language with code " + fromLanguage);
            return null;
        }

        if(toLanguageWordList.isEmpty())
        {
            System.out.println("Currently there are no words in our database for the language with code " + toLanguage);
            return null;
        }


        Word w = FilterEntityWord.filterByNameAndLanguage(word, fromLanguage);

        if( w == null)
        {
            w = closestMatchWord(fromLanguageWordList, word);
            if( w == null)
            {
                System.out.println("The word " + word + " has not been found in our database for language code " + fromLanguage.toUpperCase() + " nor a similar one");
                return null;
            }
        }


        String word_En = w.getWord_en();
        Word translatedWord = FilterEntityWord.filterBy_English_Translation_And_Language(word_En, toLanguage);

        if( translatedWord == null)
        {
            translatedWord = closestMatchWord(toLanguageWordList, word);
            if(translatedWord == null)
                return null;
        }
        //System.out.println("Succesfully translated the word! " + word + " from language " + fromLanguage.toUpperCase() +  "  to Language  " + toLanguage.toUpperCase() +" = "+ translatedWord.getWordName());
        return translatedWord.getWordName();

    }
}
