package utils;

import Entities.Definitions;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final  class FilterEntityDefinitions {
    private FilterEntityDefinitions() {}

    public static Definitions filterDefinitionsByDict(List<Definitions> definitionsList, String dict)
    {
        if(definitionsList == null || definitionsList.isEmpty())
        {
            System.out.println("The list of  definitions is empty! Exiting now..");
            return null;
        }

        List<Definitions> filteredDefinitions = definitionsList.stream().filter(p -> p.getDict().equals(dict)).collect(Collectors.toList());
        if(filteredDefinitions.isEmpty())
            return null;
        else
            return filteredDefinitions.get(0);
    }
}
