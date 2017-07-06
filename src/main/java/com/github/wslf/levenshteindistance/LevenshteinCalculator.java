package com.github.wslf.levenshteindistance;

/**
 * Levenshtein distance between two words is the minimum number of
 * single-character edits (insertions, deletions or substitutions) required to
 * change one word into the other. This class allows you to calculate
 * Levenshtein distance/
 *
 * @author Wsl_F
 */
public class LevenshteinCalculator {

    private static int minimum(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    /**
     * Calculates Levenshtein Distance (case sensitive).
     *
     * @param first one word (char sequence)
     * @param second other word (char sequence)
     * @return integer distance between sequences
     */
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

    /**
     * Calculates difference between words as Levenshtein distance divided by
     * length of longer word. (case sensitive)
     *
     * @param first one word (char sequence)
     * @param second other word (char sequence)
     * @return difference - double value in range [0;1] inclusive.
     */
    public double getDifference(CharSequence first, CharSequence second) {
        int levenshteinDistance = getLevenshteinDistance(first, second);
        int maxLength = Math.max(first.length(), second.length());
        double difference = (double) levenshteinDistance / (double) maxLength;

        return difference;
    }

    /**
     * Calculates Levenshtein Distance (case insensitive).
     *
     * @param first one word (char sequence)
     * @param second other word (char sequence)
     * @return integer distance between sequences
     */
    public int getLevenshteinDistanceIgnoreCase(CharSequence first, CharSequence second) {
        return getLevenshteinDistance(first.toString().toLowerCase(), second.toString().toLowerCase());
    }

    /**
     * Calculates difference between words as Levenshtein distance divided by
     * length of longer word. (case insensitive)
     *
     * @param first one word (char sequence)
     * @param second other word (char sequence)
     * @return difference - double value in range [0;1] inclusive.
     */
    public double getDifferenceIgnoreCase(CharSequence first, CharSequence second) {
        return getDifference(first.toString().toLowerCase(), second.toString().toLowerCase());
    }

    /**
     * Calculates Levenshtein Distance.
     *
     * @param first one word (char sequence)
     * @param second other word (char sequence)
     * @param caseSensitive use false for ignore case, or true for case
     * sensitive
     * @return integer distance between sequences
     */
    public int getLevenshteinDistance(CharSequence first, CharSequence second, boolean caseSensitive) {
        return caseSensitive ? getLevenshteinDistance(first, second)
                : getLevenshteinDistanceIgnoreCase(first, second);
    }

    /**
     * Calculates difference between words as Levenshtein distance divided by
     * length of longer word.
     *
     * @param first one word (char sequence)
     * @param second other word (char sequence)
     * @param caseSensitive use false for ignore case, or true for case
     * sensitive
     * @return difference - double value in range [0;1] inclusive.
     */
    public double getDifference(CharSequence first, CharSequence second, boolean caseSensitive) {
        return caseSensitive ? getDifference(first, second)
                : getDifferenceIgnoreCase(first, second);
    }

}
