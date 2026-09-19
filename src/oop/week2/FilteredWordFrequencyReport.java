package oop.week2;

import java.util.*;

public class FilteredWordFrequencyReport {
    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty())
            return;

        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "was", "and", "a", "is", "of", "in"));

        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "");
        String[] words = cleaned.split("\\s+");

        Map<String, Integer> freqMap = new LinkedHashMap<>();
        for (String word : words) {
            if (!word.isEmpty() && !stopWords.contains(word)) {
                freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(freqMap.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String feedback = "The mentor was great, the session was great and clear.";
        printFilteredWordFrequency(feedback);
    }
}