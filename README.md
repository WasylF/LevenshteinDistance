# Levenshtein Distance

Levenshtein distance between two words is the minimum number of single-character edits (insertions, deletions or substitutions) required to change one word into the other. Also you can calculate "difference" between words as Levenshtein distance divided by length of longer word.

**Few examples:**

| word1 | word2 | Levenshtein distance <br /> (Case sensitive) | Levenshtein distance <br /> (Case insensitive) | difference <br /> (Case sensitive) | difference <br /> (Case insensitive) |
| :------ | :------ | :------: | :------: | :------: | :------: |
| Hi | HI | 1 | 0 | 1/2 | 0.0 |
| gitHub | GitLab | 3 | 2 | 1/2 | 1/3 |
| word | WORLD | 5 | 1 | 1.0 | 1/5 |

**Usage examples:**

```java
import com.github.wslf.levenshteindistance;

...
    
LevenshteinCalculator calculator = new LevenshteinCalculator();

String word1 = "gitHub";
StringBuilder word2 = new StringBuilder("GitLab");

System.out.println("LevDist CaseSens: " + calculator.getLevenshteinDistance(word1, word2));
System.out.println("LevDist CaseIns: " + calculator.getLevenshteinDistanceIgnoreCase(word1, word2));
System.out.println("Diff CaseSens: " + calculator.getDifference(word1, word2));
System.out.println("Diff CaseIns: " + calculator.getDifferenceIgnoreCase(word1, word2));

String word3 = "GitHub";

System.out.println("LevDist CaseSens: " + calculator.getLevenshteinDistance(word1, word3, true));
System.out.println("LevDist CaseIns: " + calculator.getLevenshteinDistance(word1, word3, false));
System.out.println("Diff CaseSens: " + calculator.getDifference(word1, word3, true));
System.out.println("Diff CaseIns: " + calculator.getDifference(word1, word3, false));

```
