//This belongs to the area of reproducing the spell checker
import java.io.*;
import java.util.*;

public class SpellChecker {
    private List<String> dictionary;
    public SpellChecker(String path) throws IOException {
        this.dictionary = Dictionary(path);
    }

    private List<String> Dictionary(String path) throws IOException {
        List<String> words = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;
        while ((line = reader.readLine()) != null) {
            words.add(line.trim());
        }
        reader.close();
        return words;
    }

    public List<Map.Entry<String, Integer>> spelling(String word) {
        List<Map.Entry<String, Integer>> distances = new ArrayList<>();

        for (String dictWord : dictionary) {
            int distance = Levenshtein.LevenshteinDistance(word, dictWord);
            distances.add(new AbstractMap.SimpleEntry<>(dictWord, distance));
        }
        distances.sort(Comparator.comparingInt(Map.Entry::getValue));
        return distances.subList(0, Math.min(10, distances.size()));
    }
}