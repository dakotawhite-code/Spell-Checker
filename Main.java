//This belongs to the area of reproducing the spell checker with the words.txt dictionary
import java.io.*;
import java.util.*;public class Main {

    public static void main(String[] args) {
        try {
            SpellChecker checker = new SpellChecker("words.txt");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter a word to spellcheck: ");
            String input = scanner.nextLine();
            List<Map.Entry<String, Integer>> spelling = checker.spelling(input);
            System.out.println("\nHere are spelling suggestions for '" + input + "':");
            for (Map.Entry<String, Integer> entered : spelling) {
                System.out.println("- " + entered.getKey() + ": The distance is " + entered.getValue());
            }
        } catch (IOException e) {
            System.err.println("Error reading dictionary (words.txt): " + e.getMessage());
        }
    }
}
