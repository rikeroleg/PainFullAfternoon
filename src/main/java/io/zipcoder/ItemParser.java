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
    private String milk;

    public ArrayList<String> parseRawDataIntoStringArray(String rawData){
        String stringPattern = "##";
        ArrayList<String> response = splitStringWithRegexPattern(stringPattern , rawData);
        return response;
    }

    public String parseStringIntoItem(String rawItem) throws ItemParseException{
        ArrayList<String> keyValuePairsInRawItemData = findKeyValuePairsInRawItemData(rawItem);
        for (String pair: keyValuePairsInRawItemData){
            if (pair.matches(name))
                name = this.name(pair);
            if(pair.matches(String.valueOf(price(""))))
                price = this.price(pair);
            if(pair.matches(type("")))
                type = this.type(pair);
            if(pair.matches(expiration("")))
                expiration = this.expiration(pair);
            if (pair.matches(milk("")));
                milk = this.milk(pair);
        }

       return this.name;
        //return name;

       //return new Item(name, price, type, expiration);
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
        String output = "";
        Matcher matcher = pattern.matcher(output);
        while (matcher.find()){
            output = matcher.group();
            if (name.matches("[milkMILK]{4}")){
                output = "Milk";
            }
            if (name.matches("[breadBREAD]{5}")){
                output = "Bread";
            }
            if (name.matches("[cC]..[kK][iI][eE][sS]")){
                output = "Cookies";
            }
            if (name.matches("[@applesAPPLES]{6}")){
                output = "Apples";
            }
            else {
                output = "test";
            }
        }
        return output;
    }

    public Double price(String price){
        Pattern pattern = Pattern.compile("[pricePrice]{5}]");
        String output = "";
        Matcher matcher = pattern.matcher(price);
        while (matcher.find()){
            output = matcher.group(0);
        }
        return Double.valueOf(output);
    }

    public String type(String type){
        Pattern pattern = Pattern.compile("[typeTYPE]{4}");
        String output = "";
        Matcher matcher = pattern.matcher(type);
        while (matcher.find()){
            output = matcher.group(0);
        }
        return output;
    }

    public String expiration(String expiration){
        Pattern pattern = Pattern.compile("[expriationEXPIRATION]{10}");
        String output = "";
        Matcher matcher = pattern.matcher(expiration);
        while (matcher.find()){
            output = matcher.group(0);
        }
        return output;
    }

    public String milk(String milk){
        Pattern pattern = Pattern.compile("[milkMILK]{4}");
        String output = "";
        Matcher matcher = pattern.matcher(milk);
        while (matcher.find()){
            output = matcher.group(0);
        }
        return output;
    }

    public String bread(String bread){
        Pattern pattern = Pattern.compile("[breadBREAD]{5}");
        String output = "";
        Matcher matcher = pattern.matcher(bread);
        while (matcher.find()){
            output = matcher.group(0);
        }
        return output;
    }

    public String cookies(String cookies){
        Pattern pattern = Pattern.compile("[cC]..[kK][iI][eE][sS]");
        String output = "";
        Matcher matcher = pattern.matcher(cookies);
        while (matcher.find()){
            output = matcher.group(0);
        }
        return output;
    }

    public String apples(String apples){
        Pattern pattern = Pattern.compile("[@applesAPPLES]{6}");
        String output = "";
        Matcher matcher = pattern.matcher(apples);
        while (matcher.find()){
            output = matcher.group(0);
        }
        return output;
    }

    public String food(String food){
        Pattern pattern = Pattern.compile("([0fodFOD]{4})+.");
        String output = "";
        Matcher matcher = pattern.matcher(food);
        while (matcher.find()){
            output = matcher.group(0);
        }
        return output;
    }

}


