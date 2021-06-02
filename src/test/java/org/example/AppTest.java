package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Unit test for simple App.
 */
public class AppTest 
{


    @Test
    public void test1()
    {
        String[] brac = new String[]{"[{}]", "[{]}"};
        String[] convertedBraces = braces(brac);
        assertTrue( true );
    }

    // Complete the arrange function below.
    static String[] braces(String[] values) {

        String brc;
        String response[] = new String[values.length];
        for (int i = 0; i< values.length; i++){
            response[i] = brace(values[i]);
        }

        return Arrays.stream(values).map(value -> brace(value)).collect(Collectors.toList()).toArray(new String[0]);
    }

    // Copied from https://www.baeldung.com/java-balanced-brackets-algorithm
    static String brace(String value){

        while (value.contains("()") || value.contains("[]") || value.contains("{}")) {
            value = value.replaceAll("\\(\\)", "")
                    .replaceAll("\\[\\]", "")
                    .replaceAll("\\{\\}", "");
        }
        return (value.length() == 0) ? "YES" : "NO";
    }
}
