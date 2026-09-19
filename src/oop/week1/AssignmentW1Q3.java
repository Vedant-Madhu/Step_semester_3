package oop.week1;

public class AssignmentW1Q3 {
    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty())
            return;
        char bestColor = signalLog.charAt(0);
        int maxStreak = 1;
        char currentColor = signalLog.charAt(0);
        int currentStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentColor) {
                currentStreak++;
            } else {
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                    bestColor = currentColor;
                }
                currentColor = signalLog.charAt(i);
                currentStreak = 1;
            }
        }
        if (currentStreak > maxStreak) {
            maxStreak = currentStreak;
            bestColor = currentColor;
        }

        System.out.printf("Longest Streak: '%c' repeated %d times\n", bestColor, maxStreak);
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
    }
}
