package oop.week4;

final class SurgeFeeCalculator {
    private final double minimumSurgePercent;

    public SurgeFeeCalculator(double minimumSurgePercent) {
        this.minimumSurgePercent = minimumSurgePercent;
    }

    public final double calculateSurgeFee(double orderValue, int delayMinutes) {
        if (orderValue < 0 || delayMinutes < 0)
            throw new IllegalArgumentException();
        if (delayMinutes == 0)
            return 0.0;

        double tiered = 0.0;
        int rem = delayMinutes;
        int m1 = Math.min(rem, 5);
        tiered += m1 * (orderValue * 0.005);
        rem -= m1;
        if (rem > 0) {
            int m2 = Math.min(rem, 10);
            tiered += m2 * (orderValue * 0.01);
            rem -= m2;
        }
        if (rem > 0) {
            tiered += rem * (orderValue * 0.02);
        }

        double floor = orderValue * (minimumSurgePercent / 100.0);
        return Math.max(tiered, floor);
    }
}

public class AssignmentP4_SurgeFee {
    public static void main(String[] args) {
        SurgeFeeCalculator calc = new SurgeFeeCalculator(1.0);
        System.out.println("Rs " + calc.calculateSurgeFee(500, 0));
        System.out.println("Rs " + calc.calculateSurgeFee(500, 1));
        System.out.println("Rs " + calc.calculateSurgeFee(500, 16));
    }
}