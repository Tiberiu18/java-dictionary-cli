package Methods;

import Entities.Definitions;
import Entities.Word;
import deserialization.DeserializeJson;
import utils.FilterEntityWord;
import utils.Printers;
import utils.TokenizeString;

import java.util.*;
import java.util.logging.Filter;

public final class TranslateSentenceSynonyms {
    private TranslateSentenceSynonyms() {}

    private static final Map<String, List<Word>> wordsMap = DeserializeJson.getWordsMap();

    public static ArrayList<String> translateSentences(String sentence, String fromlanguage, String toLanguage)
    {
        if( !Printers.checkLanguageExists(fromlanguage) || !Printers.checkLanguageExists(toLanguage))
            return null;

        //sentence = TranslateSentence.translateSentence(sentence, fromlanguage,toLanguage);
        ArrayList<String> translatedSentences = new ArrayList<>();
        String[] words = TokenizeString.tokenize(sentence);
        String[] wordsCopy = Arrays.copyOf(words, words.length);
        for(int i = 0; i < words.length; i++)
        {
            words[i] = words[i].toLowerCase(); // Lowercase all
            words[i] = TranslateWord.translateWord(words[i], fromlanguage, toLanguage); // Translate all the words
            if(words[i] == null)
                words[i] = wordsCopy[i];
        }




        List<Word> wordsList = new ArrayList<>();

        // Add the words with definitions ( Definitions[] attribute not null  ) in order to process them and create Words without Definitions
        for(String word: words)
        {
            Word w = FilterEntityWord.filterByNameAndLanguage(word, toLanguage);
            if( w != null)
            {
                wordsList.add(w);
            }
            else
                wordsList.add(new Word(word));
        }



        int lowest_syn_len = Integer.MAX_VALUE;

        //Now, let's find the word with the lowest synonims.length from the list of words
        for(Word w : wordsList)
        {
            List<Definitions> wordDefs = w.getDefinitions();
            if(wordDefs != null)
            {
                for(Definitions def: wordDefs)
                {
                    if(def.getDictType().equals("synonyms") )
                    {
                        if ( def.getText().length < lowest_syn_len)
                        {
                            lowest_syn_len = def.getText().length;
                        }
                    }
                }

            }
        }



        boolean found_Synonym = false;

        int i = 0;
        while ( lowest_syn_len > 0 && i < 3)
        {
            StringBuilder syns_sentence = new StringBuilder();
            for(Word w: wordsList)
            {
                found_Synonym = false;
                List<Definitions> wordDefs = w.getDefinitions();
                if(wordDefs != null)
                {
                    for(Definitions d : wordDefs)
                    {
                        if (d.getDictType().equals("synonyms"))
                        {
                            syns_sentence.append(d.getText()[i]).append(" ");
                            found_Synonym = true;
                            break;
                        }
                    }
                    if(!found_Synonym) // if there is no synonyms dictionary
                        syns_sentence.append(w.getWordName()).append(" ");
                }
                else
                {
                    syns_sentence.append(w.getWordName()).append(" ");
                }
            }
            translatedSentences.add(syns_sentence.toString());
            i += 1;
            lowest_syn_len -= 1;
        }

        return translatedSentences;

    }
}
