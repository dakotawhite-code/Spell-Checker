//This belongs to the area of reproducing the spell checker
public class Levenshtein {
    public static int LevenshteinDistance(String word1, String word2) {
        int x = word1.length();
        int y = word2.length();
        if (x > y) {
            String temp = word1;
            word1 = word2;
            word2 = temp;
            x = word1.length();
            y = word2.length();
        }
        int[] previous = new int[x + 1];
        int[] current = new int[x + 1];
        for (int j = 0; j <= x; j++) {
            previous[j] = j;
        }
        for (int i = 1; i <= y; i++) {
            current[0] = i;
            for (int j = 1; j <= x; j++) {
                int add = previous[j] + 1;
                int delete = current[j - 1] + 1;
                int change = previous[j - 1];
                if (word1.charAt(j - 1) != word2.charAt(i - 1)) {
                    change += 1;
                }
                current[j] = Math.min(Math.min(add, delete), change);
            }
            int[] temp = previous;
            previous = current;
            current = temp;
        }
        return previous[x];
    }
}