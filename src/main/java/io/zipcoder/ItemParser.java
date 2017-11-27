package io.zipcoder;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {


    private String name;
    private Double price;
    private String type;
    private String expiration;

    public ArrayList<String> parseRawDataIntoStringArray(String rawData){
        String stringPattern = "##";
        ArrayList<String> response = splitStringWithRegexPattern(stringPattern , String.valueOf(rawData));
        return response;
    }

    public Item parseStringIntoItem(String rawItem) throws ItemParseException{
        rawItem = rawItem.replaceAll("#", "");
        ArrayList<String> keyValuePairsInRawItemData = findKeyValuePairsInRawItemData(rawItem);
       // System.out.println(keyValuePairsInRawItemData);
        for (String pair: keyValuePairsInRawItemData){
            //System.out.println(pair);
            if (pair.matches("[nameNAME]{4}"))
                name = this.name(pair);
            System.out.println(pair);
            if(pair.matches("[pricePrice]{5}]"))
                price = this.price(pair);
            System.out.println(pair);
            if(pair.matches("[type]{4}"))
                type = this.type(pair);
            System.out.println(pair);
            if(pair.matches("[expriationEXPIRATION]{10}"))
                expiration = this.expiration(pair);
            System.out.println(pair);
        }
       return new Item(name, price, type, expiration);
        //return name;
    }


    public ArrayList<String> findKeyValuePairsInRawItemData(String rawItem){
        String stringPattern = "[;|^|%|*|!|@]";
        ArrayList<String> response = splitStringWithRegexPattern(stringPattern , rawItem);
        return response;
    }

    private ArrayList<String> splitStringWithRegexPattern(String stringPattern, String inputString){
        return new ArrayList<String>(Arrays.asList(inputString.split(stringPattern)));
    }

     public String name(String value){
        String name = null;
        value = value.replaceAll("[~(nameNAME)~g]", "");
            if (value.matches("[milkMILK]{4}")){
                name= "Milk";
            }
            if (value.matches("[breadBREAD]{5}")){
                name = "Bread";
            }
            if (value.matches("[cC]..[kK][iI][eE][sS]")){
                name = "Cookies";
            }
            if (value.matches("[@applesAPPLES]{6}")){
                name = "Apples";
            }
            return name;
        }


    public Double price(String value){
        Double price = null;
        Pattern pattern = Pattern.compile("\\d.\\d+(?=;)");
        Matcher matcher = pattern.matcher(value);
        if(matcher.find()){
            price = Double.parseDouble(matcher.group(0));
        }
        return price;
    }

    public String type(String value){
        String type = null;
        value = value.replaceAll("[type]{4}", "");
        if(value.matches("[fodFOD]{4}")) {
            type = "Food";
        }
        System.out.println(type);
        return type;
    }

    public String expiration(String value){
        String expiration = null;
        Pattern pattern = Pattern.compile("(\\d/\\d+/\\d+)");
        Matcher matcher = pattern.matcher(value);
        if (matcher.find()){
            expiration = matcher.group();
        }
        return expiration;
    }


//    public String milk(String milk){
//        Pattern pattern = Pattern.compile("[milkMILK]{4}");
//        String output = "";
//        Matcher matcher = pattern.matcher(milk);
//        while (matcher.find()){
//            output = matcher.group(0);
//        }
//        return output;
//    }
//
//    public String bread(String bread){
//        Pattern pattern = Pattern.compile("[breadBREAD]{5}");
//        String output = "";
//        Matcher matcher = pattern.matcher(bread);
//        while (matcher.find()){
//            output = matcher.group(0);
//        }
//        return output;
//    }
//
//    public String cookies(String cookies){
//        Pattern pattern = Pattern.compile("[cC]..[kK][iI][eE][sS]");
//        String output = "";
//        Matcher matcher = pattern.matcher(cookies);
//        while (matcher.find()){
//            output = matcher.group(0);
//        }
//        return output;
//    }
//
//    public String apples(String apples){
//        Pattern pattern = Pattern.compile("[@applesAPPLES]{6}");
//        String output = "";
//        Matcher matcher = pattern.matcher(apples);
//        while (matcher.find()){
//            output = matcher.group(0);
//        }
//        return output;
//    }

//    public String food(String food){
//        Pattern pattern = Pattern.compile("([0fodFOD]{4})+.");
//        String output = "";
//        Matcher matcher = pattern.matcher(food);
//        while (matcher.find()){
//            output = matcher.group(0);
//        }
//        return output;
//    }

}


