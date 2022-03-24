package Methods;

import Entities.Definitions;
import Entities.Word;
import deserialization.DeserializeJson;
import utils.FilterEntityDefinitions;
import utils.FilterEntityWord;
import utils.Printers;

import java.util.List;

public final class RemoveDefinitionFromWord {
    private RemoveDefinitionFromWord() {}

    public static boolean removeDefinition(String word, String language, String dictionary)
    {
        if( !Printers.checkLanguageExists(language))
            return false;


        Word w = FilterEntityWord.filterByNameAndLanguage(word, language);
        if( w == null)
        {
            System.out.println("The word " + word + " is not present in the dictionary!(" + language +")");
            return false;
        }
        else
        {
            List<Definitions> wordDefs = w.getDefinitions();
            Definitions c = FilterEntityDefinitions.filterDefinitionsByDict(wordDefs, dictionary);
            if( c == null )
            {
                System.out.println("There is no definition for the word " + word  + " from the dict " + dictionary);
                return false;
            }
            else
            {
                wordDefs.remove(c);
                System.out.println("Succesfully deleted definition for word " + word + " from the dict " + dictionary);
                System.out.println(w.getDefinitions());
                return true;
            }
        }

    }
}
