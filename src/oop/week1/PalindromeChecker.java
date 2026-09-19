package oop.week1;

public class PalindromeChecker {
    public static boolean isPalindromeIterative(String text) {
        if (text == null)
            return false;
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left++) != text.charAt(right--))
                return false;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text == null || text.length() <= 1)
            return true;
        if (text.charAt(0) != text.charAt(text.length() - 1))
            return false;
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null)
            return false;
        char[] arr = text.toCharArray();
        char[] rev = new char[arr.length];
        for (int i = 0; i < arr.length; i++)
            rev[i] = arr[arr.length - 1 - i];
        return text.equals(new String(rev));
    }

    public static void main(String[] args) {
        String word = "madam";
        System.out.println(word + " -> Iterative: " + isPalindromeIterative(word) +
                " | Recursive: " + isPalindromeRecursive(word) +
                " | ArrayReversal: " + isPalindromeArrayReversal(word));
    }
}