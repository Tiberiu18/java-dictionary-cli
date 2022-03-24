package deserialization;

import Common.Constants;
import Entities.Word;
import Methods.AddWord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class DeserializeDatabase {
    private DeserializeDatabase() {}


    public static void populateDatabase()
    {
        try{
            BufferedReader roBR = new BufferedReader(new FileReader(Constants.ROMANIAN_WORDS_DB_PATH));
            BufferedReader enBR = new BufferedReader(new FileReader(Constants.ENGLISH_WORDS_DB_PATH));
            BufferedReader frBR = new BufferedReader(new FileReader(Constants.FRENCH_WORDS_DB_PATH));


            while(true)
            {
                String lineRO = roBR.readLine();
                String lineEN = enBR.readLine();
                String lineFR = frBR.readLine();
                if(lineRO == null || lineEN == null || lineFR == null)
                    break;
                AddWord.addWord(new Word(lineRO.toLowerCase(), lineEN.toLowerCase()), Constants.ROMANIAN_LANGUAGE_CODE);
                AddWord.addWord(new Word(lineFR.toLowerCase(), lineEN.toLowerCase()), Constants.FRENCH_LANGUAGE_CODE);

            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }


    public static void InitializeDB()
    {
        try{
            PrintStream original = System.out;
            System.setOut(new PrintStream(new OutputStream() {
                @Override
                public void write(int b) {
                    // do nothing to redirect output stream to null
                }
            }));
            populateDatabase();
            System.setOut(original);
            System.out.println("Succesfully imported words from databases!");

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
