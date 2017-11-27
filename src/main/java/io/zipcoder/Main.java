package io.zipcoder;

import org.apache.commons.io.IOUtils;

import java.util.ArrayList;


public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        //System.out.println(output);

        ItemParser itemParser = new ItemParser();
        //ArrayList<String> outputSeparated = itemParser.parseRawDataIntoStringArray(output);
//
//        for (String itemString: outputSeparated){
//            System.out.println(itemString);
//        }

        // TODO: parse the data in output into items, and display to console.
        ArrayList<String> items = itemParser.parseRawDataIntoStringArray(output);
//        ArrayList<String> items = itemParser.findKeyValuePairsInRawItemData(test);
//        for (String item : items){
//            System.out.println(item);
//        }

        ArrayList<ArrayList<String>> eachItem = new ArrayList<>();

        for (String item : items){
            ArrayList<String> itemArray = itemParser.findKeyValuePairsInRawItemData(item);
            eachItem.add(itemArray);
        }

        for (ArrayList<String> itemDetail : eachItem){
            System.out.println(itemDetail);

        }

        //System.out.println(test);
    }
}
