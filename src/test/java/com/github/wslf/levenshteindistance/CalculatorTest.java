package com.github.wslf.levenshteindistance;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wslf
 */
public class CalculatorTest {
    
    public CalculatorTest() {
    }

    /**
     * Test of getLevenshteinDistance method, of class Calculator.
     */
    @Test
    public void testGetLevenshteinDistance() {
        System.out.println("getLevenshteinDistance");
        CharSequence first = "Wasyl";
        CharSequence second = "Vasyl";
        Calculator instance = new Calculator();
        int expResult = 1;
        int result = instance.getLevenshteinDistance(first, second);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSimilarity method, of class Calculator.
     */
    @Test
    public void testGetDistance() {
        System.out.println("getSimilarity");
        CharSequence first = "String-one";
        CharSequence second = "string-two";
        Calculator instance = new Calculator();
        double expResult = 0.4;
        double result = instance.getDistance(first, second);
        assertEquals(expResult, result, 1e-6);
    }

    /**
     * Test of getLevenshteinDistance method, of class Calculator.
     */
    @Test
    public void testGetLevenshteinDistanceIgnoreCase() {
        System.out.println("getLevenshteinDistanceIgnoreCase");
        CharSequence first = "vasyl";
        CharSequence second = "Vasyl";
        Calculator instance = new Calculator();
        int expResult = 0;
        int result = instance.getLevenshteinDistanceIgnoreCase(first, second);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSimilarity method, of class Calculator.
     */
    @Test
    public void testGetDistanceIgnoreCase() {
        System.out.println("getSimilarityIgnoreCase");
        CharSequence first = "String-one";
        CharSequence second = "string-two";
        Calculator instance = new Calculator();
        double expResult = 0.3;
        double result = instance.getDistanceIgnoreCase(first, second);
        assertEquals(expResult, result, 1e-6);
    }

    /**
     * Test of getLevenshteinDistance method, of class Calculator.
     */
    @Test
    public void testGetLevenshteinDistanceIgnoreCase2() {
        System.out.println("getLevenshteinDistanceIgnoreCase");
        CharSequence first = "СтрокаНомерОдин";
        CharSequence second = "строкАномеРдва";
        Calculator instance = new Calculator();
        int expResult = 3;
        int result = instance.getLevenshteinDistanceIgnoreCase(first, second);
        assertEquals(expResult, result);
    }

    /**
     * Test of getLevenshteinDistance method, of class Calculator.
     */
    @Test
    public void testGetLevenshteinDistanceIgnoreCase3() {
        System.out.println("getLevenshteinDistanceIgnoreCase");
        CharSequence first = "АБВГ";
        CharSequence second = "ЯЮЭЬ";
        Calculator instance = new Calculator();
        int expResult = 4;
        int result = instance.getLevenshteinDistanceIgnoreCase(first, second);
        assertEquals(expResult, result);
    }

    
}
