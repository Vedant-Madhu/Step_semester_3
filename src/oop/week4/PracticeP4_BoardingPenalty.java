package oop.week4;

final class BoardingPenaltyCalculator {
    private final double minimumPenaltyPercent;

    public BoardingPenaltyCalculator(double minimumPenaltyPercent) {
        this.minimumPenaltyPercent = minimumPenaltyPercent;
    }

    public final double calculatePenalty(double ticketFare, int minutesLate) {
        if (ticketFare < 0 || minutesLate < 0) {
            throw new IllegalArgumentException("Negative fare or minutes late.");
        }
        if (minutesLate == 0)
            return 0.0;

        double tiered = 0.0;
        int rem = minutesLate;

        int m1 = Math.min(rem, 5);
        tiered += m1 * (ticketFare * 0.005);
        rem -= m1;

        if (rem > 0) {
            int m2 = Math.min(rem, 10);
            tiered += m2 * (ticketFare * 0.01);
            rem -= m2;
        }

        if (rem > 0) {
            tiered += rem * (ticketFare * 0.02);
        }

        double floor = ticketFare * (minimumPenaltyPercent / 100.0);
        return Math.max(tiered, floor);
    }
}

public class PracticeP4_BoardingPenalty {
    public static void main(String[] args) {
        BoardingPenaltyCalculator calc = new BoardingPenaltyCalculator(1.0);
        System.out.println("Rs " + calc.calculatePenalty(1000, 0));
        System.out.println("Rs " + calc.calculatePenalty(1000, 1));
        System.out.println("Rs " + calc.calculatePenalty(1000, 16));
    }
}