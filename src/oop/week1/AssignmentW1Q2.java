package oop.week1;

public class AssignmentW1Q2 {
    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null)
            return;
        int total = original.length();
        int matched = 0;
        int firstMismatchPos = -1;
        char mismatchOriginal = ' ';
        char mismatchTyped = ' ';

        int limit = Math.min(total, typed.length());
        for (int i = 0; i < limit; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else {
                if (firstMismatchPos == -1) {
                    firstMismatchPos = i + 1;
                    mismatchOriginal = original.charAt(i);
                    mismatchTyped = typed.charAt(i);
                }
            }
        }

        double accuracy = ((double) matched / total) * 100;
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%", matched, total, accuracy);
        if (firstMismatchPos != -1) {
            System.out.printf(" | First Mismatch at position %d ('%c' vs '%c')\n", firstMismatchPos, mismatchOriginal,
                    mismatchTyped);
        } else {
            System.out.println(" | No Mismatches");
        }
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
    }
}
