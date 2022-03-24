package deserialization;
import Entities.Word;
import com.google.gson.Gson;
import Common.Constants;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class DeserializeJson {
    private DeserializeJson() {
    }

    private static final Map<String, List<Word>> wordsMap = new HashMap<>();


    public static List<String> findJsonFiles(String path, String FileExtension) {
        List<String> jsonFileNames = new ArrayList<>();

        if (!Files.isDirectory(Paths.get(path))) {
            System.out.println("Invalid path!");
            return Collections.emptyList();
        }

        try (Stream<Path> walk = Files.walk(Paths.get(path))) {
            jsonFileNames = walk.filter(p -> !Files.isDirectory(p)).map(p -> p.toString().toLowerCase())
                    .filter(f -> f.endsWith(FileExtension)).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonFileNames;
    }


    public static void deserializeDict() {
        List<String> jsonFiles = findJsonFiles(Constants.DICTIONARIES_PATH, Constants.JSON_EXT);
        if (jsonFiles.isEmpty()) {
            System.out.println("No json files found at " + Constants.DICTIONARIES_PATH + ".");
            return;
        }

        //Check format ( to check if the file is ro_dict.json for example )
        for (String fName : jsonFiles) {
            String languageCode = null;
            String[] auxStr = fName.split(Pattern.quote("\\"));
            //ro_dict.json will be auxStr[1]
            // XX_dict.json
            String[] final_Res = auxStr[1].split("_");
            if ( !(Objects.equals(final_Res[1], "dict.json")) ||( final_Res.length != 2)) {
                continue;
            }
            else
            {
                languageCode = final_Res[0];
            }

            List<Word> auxWords = new ArrayList<>();
            Gson gson = new Gson();
            Type word = new TypeToken<Collection<Word>>() {}.getType();

            try (JsonReader reader = new JsonReader(new FileReader(fName))) {
                auxWords = gson.fromJson(reader, word);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if(wordsMap.containsKey(languageCode))
            {
                wordsMap.get(languageCode).addAll(auxWords);
            }
            else
            {
                wordsMap.put(languageCode, auxWords);
            }
            System.out.println("Succesfully imported from the file " + fName +" !");
        }
    }

    public static Map<String, List<Word>> getWordsMap()
    {
        return wordsMap;
    }

}

