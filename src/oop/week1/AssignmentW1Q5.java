package oop.week1;

public class AssignmentW1Q5 {
    public static void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }
        String[] words = review.trim().split("\\s+");
        int shortCount = 0, mediumCount = 0, longCount = 0;

        for (String word : words) {
            int len = word.replaceAll("[^a-zA-Z]", "").length();
            if (len >= 1 && len <= 4) {
                shortCount++;
            } else if (len >= 5 && len <= 8) {
                mediumCount++;
            } else if (len >= 9) {
                longCount++;
            }
        }

        System.out.printf("Short: %d | Medium: %d | Long: %d\n", shortCount, mediumCount, longCount);
    }

    public static void main(String[] args) {
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }
}
