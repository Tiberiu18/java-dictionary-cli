package Methods;

import Entities.Definitions;
import Entities.Word;
import deserialization.DeserializeJson;
import utils.FilterEntityDefinitions;
import utils.FilterEntityWord;
import utils.Printers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class AddDefinitionToWord {
    private AddDefinitionToWord() {}




    public static boolean addDefinitionToWord(String word, String language, Definitions definition)
    {
        if( !Printers.checkLanguageExists(language))
            return false;

        if ( !Printers.checkWordExistsInLanguage(word, language))
            return false;

        Word w = FilterEntityWord.filterByNameAndLanguage(word, language);

        Definitions d = FilterEntityDefinitions.filterDefinitionsByDict(w.getDefinitions(), definition.getDict());
        if( d == null )
        {
            w.getDefinitions().add(definition);
            System.out.println("The definition has been added succesfully to the word " + word + " language code "+language);
            Word ws = FilterEntityWord.filterByNameAndLanguage(word, language);
            if ( ws != null)
                System.out.println(ws.getDefinitions());
            return true;
        }
        else{
            System.out.println("There already is a definition from the same dict! (Dict = " + definition.getDict() + " )");
            return false;
        }

    }
}
