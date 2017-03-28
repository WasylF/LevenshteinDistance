
package com.github.wslf.levenshteindistance;

/**
 *
 * @author Wsl_F
 */
public class Calculator {
    private static int minimum(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public int getLevenshteinDistance(CharSequence first, CharSequence second) {
        int len0 = first.length() + 1;
        int len1 = second.length() + 1;

        int[] distance = new int[len0];
        int[] newDistance = new int[len0];

        for (int i = 0; i < len0; i++) {
            distance[i] = i;
        }

        for (int j = 1; j < len1; j++) {
            newDistance[0] = j;

            for (int i = 1; i < len0; i++) {
                int match = (first.charAt(i - 1) == second.charAt(j - 1)) ? 0 : 1;

                int cost_replace = distance[i - 1] + match;
                int cost_insert = distance[i] + 1;
                int cost_delete = newDistance[i - 1] + 1;

                newDistance[i] = minimum(cost_insert, cost_delete, cost_replace);
            }

            int[] swap = distance;
            distance = newDistance;
            newDistance = swap;
        }

        return distance[len0 - 1];
    }

    public double getDistance(CharSequence first, CharSequence second) {
        int levenshteinDistance = getLevenshteinDistance(first, second);
        double distance = levenshteinDistance;
        distance /= Math.min(first.length(), second.length());
        
        return distance;
    }
    
    public int getLevenshteinDistanceIgnoreCase(CharSequence first, CharSequence second) {
        return getLevenshteinDistance(first.toString().toLowerCase(), second.toString().toLowerCase());
    }
    
    public double getDistanceIgnoreCase(CharSequence first, CharSequence second) {
        return getDistance(first.toString().toLowerCase(), second.toString().toLowerCase());
    }
    
}
