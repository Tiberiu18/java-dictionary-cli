package Methods;

import Entities.Definitions;
import Entities.Word;
import deserialization.DeserializeJson;
import utils.FilterEntityWord;
import utils.Printers;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public final class GetDefinitionsForWord {
    private GetDefinitionsForWord() {}

    private static Map<String, List<Word>> wordsMap = DeserializeJson.getWordsMap();

    public static List<Definitions> getDefinitionsforWord(String word, String language)
    {
        if( !Printers.checkLanguageExists(language))
        {
            return Collections.emptyList();
        }
        Word w = FilterEntityWord.filterByNameAndLanguage(word, language);
        if(w == null)
        {
            System.out.printf("Word %s is not present in the %s dictionary", word, language);
            return Collections.emptyList();
        }
        List<Definitions> definitions = w.getDefinitions();
        definitions.sort(new Comparator<Definitions>() {
            @Override
            public int compare(Definitions definition, Definitions t1) {
                return definition.getYear().compareTo(t1.getYear());
            }
        });
        return definitions;
    }


}
