package utils;

import Entities.Word;
import deserialization.DeserializeJson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class FilterEntityWord {
    private FilterEntityWord() {}

    public static List<Word> filterByName(String wordName)
    {
        List<Word> fullWordList = new ArrayList<>();
        List<Word> filteredWordList = new ArrayList<>();
        Map<String,List<Word>> wordsMap = DeserializeJson.getWordsMap();
        for(Map.Entry<String,List<Word>> entry : wordsMap.entrySet())
        {
            fullWordList.addAll(entry.getValue());
        }
        filteredWordList = fullWordList.stream().filter(p -> p.getWordName().equals(wordName)).collect(Collectors.toList());
        if(filteredWordList.isEmpty())
            return Collections.emptyList();
        else
            return filteredWordList;
    }

    public static Word filterByNameAndLanguage(String wordName, String language)
    {
       List<Word> filteredWordList = new ArrayList<>();
       List<Word> wordList = new ArrayList<>();
       Map<String, List<Word>> wordsMap = DeserializeJson.getWordsMap();
       if( ! (wordsMap.containsKey(language)))
       {
            System.out.println("The language with the code " + language + " is not present in the database!");
            return null;
       }
       else
       {
           wordList = wordsMap.get(language);
           filteredWordList = wordList.stream().filter(p -> p.getWordName().equals(wordName)).collect(Collectors.toList());
           if(filteredWordList.isEmpty())
               return null;
       }
       return filteredWordList.get(0);
    }


    public static Word filterBy_English_Translation_And_Language(String word_EN, String language)
    {
        Map<String, List<Word>> wordsMap = DeserializeJson.getWordsMap();
        if( ! (wordsMap.containsKey(language)))
        {
            System.out.println("The language with the code " + language + " is not present in the database!");
            return null;
        }

        List<Word> wordList = wordsMap.get(language);
        List<Word> filteredWordList = wordList.stream().filter(p -> p.getWord_en().equals(word_EN)).collect(Collectors.toList());
        if(filteredWordList.isEmpty())
        {
            System.out.println("The english word " + word_EN + " has not been found in the dictionary with language code " + language);
            return null;
        }
        else
        {
            return filteredWordList.get(0);
        }

    }
}
