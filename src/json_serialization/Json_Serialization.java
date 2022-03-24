package json_serialization;

import Common.Constants;
import Entities.Definitions;
import Entities.Word;
import Methods.GetDefinitionsForWord;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import deserialization.DeserializeJson;
import utils.Printers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public final class Json_Serialization {
    private Json_Serialization() {}

    private static Map<String, List<Word>> wordsMap = DeserializeJson.getWordsMap();
    private static List<String> files = new ArrayList<>();
    public static void listFilesForFolder(final File folder)
    {
        try{
            for(final File fileEntry: folder.listFiles())
            {
                if(!fileEntry.isDirectory())
                {
                    files.add(fileEntry.getName());
                }
            }
        }
        catch(Exception ex)
        {
            // nothing
        }
    }

    public static int GetLastFileID(String path, String baseFileName)
    {
        final File folder = new File(path);
        listFilesForFolder(folder);
        List<String> baseFileNameList = new ArrayList<>();
        String[] auxArr = null;
        int maximumNum = 0;
        int n = 0;
        for(String s: files)
        {
            if(s.contains(baseFileName))
            {
                auxArr = s.split("-");
                if(auxArr.length > 1)
                {
                    try{
                        String sp =  auxArr[auxArr.length-1].split("\\.")[0];
                        n = Integer.parseInt(sp);
                        if(n > maximumNum)
                            maximumNum = n;
                    }
                    catch(Exception e)
                    {
                        // do nothing
                    }
                }
            }
        }
        return maximumNum;
    }



    public static void exportDictionary(String language) throws IOException
    {
        if(!Printers.checkLanguageExists(language))
        {
            System.out.println("---- Dictionary with language code " + language + " couldn't be exported ----");
            return;
        }


        List<Word> wordList = wordsMap.get(language);
        wordList.sort(new Comparator<Word>() {
            @Override
            public int compare(Word word, Word t1) {
                return word.getWordName().compareTo(t1.getWordName());
            }
        });

        for(Word w: wordList)
        {
            List<Definitions> wordDefs = w.getDefinitions();
            if(wordDefs != null)
            {
                wordDefs.sort(new Comparator<Definitions>() {
                    @Override
                    public int compare(Definitions definitions, Definitions t1) {
                        return definitions.getYear().compareTo(t1.getYear());
                    }
                });
            }
        }
        String fileName = language + "_dict";

        Integer latestID = (Integer)GetLastFileID(Constants.JSON_SERIALIZATION_FOLDER_NAME, fileName) + 1;
        String FullPathFile = Constants.JSON_SERIALIZATION_FOLDER_NAME+fileName + "-" +latestID.toString();
        if(!Files.isDirectory(Paths.get(Constants.JSON_SERIALIZATION_FOLDER_NAME)))
        {
            Files.createDirectories(Paths.get(Constants.JSON_SERIALIZATION_FOLDER_NAME));
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(wordList, new FileWriter(FullPathFile+".json"));
        System.out.println("---- Dictionary with language code " + language + " exported succesfully!");

    }
}
