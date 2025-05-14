//This codes belongs to where I implement my own Narrative Paper(essay.txt) from my speech class into the spell checker
import java.io.*;
import java.util.*;

public class expandwork {
    public static void main(String[] args) {
        try {
            spell checker = new spell("words.txt");
            BufferedReader reader = new BufferedReader(new FileReader("essay.txt"));
            String line;
            int lines = 1;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (word.isEmpty()) 
                    continue;
                    String lower = word.toLowerCase();
                    List<Map.Entry<String, Integer>> suggestion = checker.spelling(lower);
                    if (suggestion.isEmpty()) 
                    continue;
                    Map.Entry<String, Integer> match = suggestion.get(0);
                    if (match.getValue() == 0) 
                    continue;
                    System.out.println("\nA word: '" + word + "' on line " + lines + " was not recognized.");
                    System.out.println("Here are spelling suggestions:");
                    for (int i = 0; i < Math.min(10, suggestion.size()); i++) {
                        Map.Entry<String, Integer> entered = suggestion.get(i);
                        System.out.println("- " + entered.getKey() + ": The distance is " + entered.getValue());
                    }
                }
                lines++;
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading the essay (essay.txt): " + e.getMessage());
        }
    }
}
