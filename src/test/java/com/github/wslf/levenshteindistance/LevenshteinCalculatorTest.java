package com.github.wslf.levenshteindistance;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wslf
 */
public class LevenshteinCalculatorTest {

    public LevenshteinCalculatorTest() {
    }

    /**
     * Test of getLevenshteinDistance method, of class LevenshteinCalculator.
     */
    @Test
    public void testGetLevenshteinDistance() {
        System.out.println("getLevenshteinDistance");
        CharSequence first = "Wasyl";
        CharSequence second = "Vasyl";
        LevenshteinCalculator instance = new LevenshteinCalculator();
        int expResult = 1;
        int result = instance.getLevenshteinDistance(first, second);
        assertEquals(expResult, result);
    }

    /**
     * Test of getLevenshteinDistance method, of class Calculator.
     */
    @Test
    public void testGetLevenshteinDistanceIgnoreCase() {
        System.out.println("getLevenshteinDistanceIgnoreCase");
        CharSequence first = "vasyl";
        CharSequence second = "Vasyl";
        LevenshteinCalculator instance = new LevenshteinCalculator();
        int expResult = 0;
        int result = instance.getLevenshteinDistanceIgnoreCase(first, second);
        assertEquals(expResult, result);
    }

    /**
     * Test of getLevenshteinDistance method, of class LevenshteinCalculator.
     */
    @Test
    public void testGetLevenshteinDistanceIgnoreCase2() {
        System.out.println("getLevenshteinDistanceIgnoreCase");
        CharSequence first = "СтрокаНомерОдин";
        CharSequence second = "строкАномеРдва";
        LevenshteinCalculator instance = new LevenshteinCalculator();
        int expResult = 3;
        int result = instance.getLevenshteinDistanceIgnoreCase(first, second);
        assertEquals(expResult, result);
    }

    /**
     * Test of getLevenshteinDistance method, of class LevenshteinCalculator.
     */
    @Test
    public void testGetLevenshteinDistanceIgnoreCase3() {
        System.out.println("getLevenshteinDistanceIgnoreCase");
        CharSequence first = "АБВГ";
        CharSequence second = "ЯЮЭЬ";
        LevenshteinCalculator instance = new LevenshteinCalculator();
        int expResult = 4;
        int result = instance.getLevenshteinDistanceIgnoreCase(first, second);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDifference() {
        CharSequence first = "Hello!";
        CharSequence second = "Hi!";
        LevenshteinCalculator instance = new LevenshteinCalculator();
        double expResult = 4.0 / 6.0;
        double result = instance.getDifference(first, second);
        assertEquals(expResult, result, 1e-6);
    }

    @Test
    public void testGetDifference2() {
        CharSequence first = "Hello!";
        CharSequence second = "hi!";
        LevenshteinCalculator instance = new LevenshteinCalculator();
        double expResult = 5.0 / 6.0;
        double result = instance.getDifference(first, second, true);
        assertEquals(expResult, result, 1e-6);
    }

    @Test
    public void testGetDifference3() {
        CharSequence first = "Hello!";
        CharSequence second = "hi!";
        LevenshteinCalculator instance = new LevenshteinCalculator();
        double expResult = 4.0 / 6.0;
        double result = instance.getDifference(first, second, false);
        assertEquals(expResult, result, 1e-6);
    }

}
