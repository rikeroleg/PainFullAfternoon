package io.zipcoder;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {


    public ArrayList<String> parseRawDataIntoStringArray(String rawData){
        String stringPattern = "##";
        ArrayList<String> response = splitStringWithRegexPattern(stringPattern , rawData);
        return response;
    }

    public Item parseStringIntoItem(String rawItem) throws ItemParseException{




        



       return null;
    }


    public ArrayList<String> findKeyValuePairsInRawItemData(String rawItem){
        String stringPattern = "[;|^|%|*|!|@]";
        ArrayList<String> response = splitStringWithRegexPattern(stringPattern , rawItem);
        return response;
    }

    private ArrayList<String> splitStringWithRegexPattern(String stringPattern, String inputString){
        return new ArrayList<String>(Arrays.asList(inputString.split(stringPattern)));
    }

    public String name(String name){
        Pattern pattern = Pattern.compile("[nameNAME]{4}");
        StringBuilder stringBuilder = new StringBuilder(name);
        Matcher matcher = pattern.matcher(stringBuilder);
        while (matcher.find()){
            stringBuilder.replace(matcher.start(), matcher.end(), "name");
        }
        name = stringBuilder.toString();
        return name;
    }

    public String price(String price){
        Pattern pattern = Pattern.compile("[pricePrice]{5}]");
        StringBuilder stringBuilder = new StringBuilder(price);
        Matcher matcher = pattern.matcher(stringBuilder);
        while (matcher.find()){
            stringBuilder.replace(matcher.start(), matcher.end(), "Price");
        }
        price = stringBuilder.toString();
        return price;
    }

    public String type(String type){
        Pattern pattern = Pattern.compile("[typeTYPE]{4}");
        StringBuilder stringBuilder = new StringBuilder(type);
        Matcher matcher = pattern.matcher(stringBuilder);
        while (matcher.find()){
            stringBuilder.replace(matcher.start(), matcher.end(), "type");
        }
        type = stringBuilder.toString();
        return type;
    }

    public String expiration(String expiration){
        Pattern pattern = Pattern.compile("[expriationEXPIRATION]{10}");
        StringBuilder stringBuilder = new StringBuilder(expiration);
        Matcher matcher = pattern.matcher(stringBuilder);
        while (matcher.find()){
            stringBuilder.replace(matcher.start(), matcher.end(), "expiration");
        }
        expiration = stringBuilder.toString();
        return expiration;
    }

    public String milk(String milk){
        Pattern pattern = Pattern.compile("[milkMILK]{4}");
        StringBuilder stringBuilder = new StringBuilder(milk);
        Matcher matcher = pattern.matcher(stringBuilder);
        while (matcher.find()){
            stringBuilder.replace(matcher.start(), matcher.end(), "Milk");
        }
        milk = stringBuilder.toString();
        return milk;
    }

    public String bread(String bread){
        Pattern pattern = Pattern.compile("[breadBREAD]{5}");
        StringBuilder stringBuilder = new StringBuilder(bread);
        Matcher matcher = pattern.matcher(stringBuilder);
        while (matcher.find()){
            stringBuilder.replace(matcher.start(), matcher.end(), "Bread");
        }
        bread = stringBuilder.toString();
        return bread;
    }

    public String cookies(String cookies){
        Pattern pattern = Pattern.compile("[cC]..[kK][iI][eE][sS]");
        StringBuilder stringBuilder = new StringBuilder(cookies);
        Matcher matcher = pattern.matcher(stringBuilder);
        while (matcher.find()){
            stringBuilder.replace(matcher.start(), matcher.end(), "Cookies");
        }
        cookies = stringBuilder.toString();
        return cookies;
    }

    public String apples(String apples){
        Pattern pattern = Pattern.compile("[@applesAPPLES]{6}");
        StringBuilder stringBuilder = new StringBuilder(apples);
        Matcher matcher = pattern.matcher(stringBuilder);
        while (matcher.find()){
            stringBuilder.replace(matcher.start(), matcher.end(), "Apples");
        }
        apples = stringBuilder.toString();
        return apples;
    }

    public String food(String food){
        Pattern pattern = Pattern.compile("([0fodFOD]{4})+.");
        StringBuilder stringBuilder = new StringBuilder(food);
        Matcher matcher = pattern.matcher(stringBuilder);
        while (matcher.find()){
            stringBuilder.replace(matcher.start(), matcher.end(), "Food");
        }
        food = stringBuilder.toString();
        return food;
    }

}


