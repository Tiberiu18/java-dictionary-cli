package TestCases.tests;

import json_serialization.Json_Serialization;

import java.io.IOException;

public final class TestExportDictionaries {
    private TestExportDictionaries() {}

    public static void testExportDictionaries()
    {
        System.out.println("---- Testing export dictionaries ----");

        System.out.println("\n---- TestCase 1 ----");
        try{
            Json_Serialization.exportDictionary("ro");
        }
        catch(IOException e) {
            e.printStackTrace();
        }


        System.out.println("\n---- TestCase 2 ----");
        try{
            Json_Serialization.exportDictionary("fr");
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n---- TestCase 3 ----");
        try{
            Json_Serialization.exportDictionary("xk");
        }
        catch(IOException e) {
            e.printStackTrace();
        }



    }

}
