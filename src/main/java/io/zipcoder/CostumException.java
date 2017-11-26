package io.zipcoder;

public class CostumException extends Exception  {

    static int errorCount = 0;

    public CostumException(){
        errorCount++;
    }
}