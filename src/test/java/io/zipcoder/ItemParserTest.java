package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ItemParserTest {

    private String rawSingleItem =    "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";

    private String rawSingleItemIrregularSeperatorSample = "naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##";

    private String rawBrokenSingleItem =    "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";

    private String rawMultipleItems = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##"
                                      +"naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##"
                                      +"NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##";
    private ItemParser itemParser;

    @Before
    public void setUp(){
        itemParser = new ItemParser();
    }

    @Test
    public void parseRawDataIntoStringArrayTest(){
        Integer expectedArraySize = 3;
        ArrayList<String> items = itemParser.parseRawDataIntoStringArray(rawMultipleItems);
        Integer actualArraySize = items.size();
        assertEquals(expectedArraySize, actualArraySize);
    }

    @Test
    public void parseStringIntoItemTest() throws ItemParseException{
        Item expected = new Item("milk", 3.23, "food","1/25/2016");
        Item actual = itemParser.parseStringIntoItem(rawMultipleItems);
        assertEquals(expected.toString(), actual.toString());
    }

    @Test(expected = ItemParseException.class)
    public void parseBrokenStringIntoItemTest() throws ItemParseException{
        itemParser.parseStringIntoItem(rawSingleItem);
    }

    @Test
    public void findKeyValuePairsInRawItemDataTest(){
        Integer expected = 4;
        Integer actual = itemParser.findKeyValuePairsInRawItemData(rawSingleItem).size();
        assertEquals(expected, actual);
    }

    @Test
    public void findKeyValuePairsInRawItemDataTestIrregular(){
        Integer expected = 4;
        Integer actual = itemParser.findKeyValuePairsInRawItemData(rawSingleItemIrregularSeperatorSample).size();
        assertEquals(expected, actual);
    }

    @Test
    public void MyStringToItemTest() throws ItemParseException{
        String item = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        String expected = "";
        Item actual = itemParser.parseStringIntoItem(item);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void nameTest() throws ItemParseException {
        //String name = "naMe:apples;price:3.23;type:Food;expiration:1/25/2016";
        ArrayList<String> keyValuePairsInRawItemData = itemParser.findKeyValuePairsInRawItemData(rawMultipleItems);
        String item = keyValuePairsInRawItemData.get(0);
        String expected = "";
        String actual = itemParser.name(item);
        System.out.println(item);

        Assert.assertEquals(expected , actual);
    }

    @Test
    public void priceTest(){
        Double expected = 3.23;
        Double actual = itemParser.price(rawSingleItem);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void typeTest(){
        String name = "naMe:apples;price:3.23;type:Food;expiration:1/25/2016";

        //ArrayList<String> keyValuePairsInRawItemData = itemParser.findKeyValuePairsInRawItemData(name);
        //String item = keyValuePairsInRawItemData.get(2);
        String expected = "Fod";
        String actual = itemParser.type(name);
        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void expirationTest(){
        String expected = "";
        String actual = itemParser.expiration(rawMultipleItems);
        Assert.assertEquals(expected, actual);
    }
}
