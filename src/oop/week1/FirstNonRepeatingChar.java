package oop.week1;

public class FirstNonRepeatingChar {
    public static char findFirstNonRepeatingChar(String text) {
        int[] freq = new int[256];
        for (char c : text.toCharArray())
            freq[c]++;
        for (char c : text.toCharArray()) {
            if (freq[c] == 1)
                return c;
        }
        return '\0';
    }

    public static void main(String[] args) {
        String text = "swiss";
        System.out.println("\"" + text + "\" -> '" + findFirstNonRepeatingChar(text) + "'");
    }
}