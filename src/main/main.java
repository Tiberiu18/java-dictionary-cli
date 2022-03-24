package main;

import Entities.Word;
import TestCases.Test;
import deserialization.DeserializeDatabase;
import deserialization.DeserializeJson;
import json_serialization.Json_Serialization;
import utils.FilterEntityWord;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class main {
    private main(){}

    public static void main(String[] args) {

        System.out.println("--- IMPORTING INPUT DICTIONARIES ---");
        DeserializeJson.deserializeDict();
        System.out.println("--- FINISHING IMPORTING INPUT DICTIONARIES ---");

        System.out.println("--- STARTING IMPORTING DATABASE ---");
        DeserializeDatabase.InitializeDB();
        System.out.println("--- FINISHING IMPORTING DATABASE ---\n");

        Test.runTests();
    }

}
