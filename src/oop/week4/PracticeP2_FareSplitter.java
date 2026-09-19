package oop.week4;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

class FareSplitter {
    private String tripId;
    private double totalFare;
    private int passengerCount;

    public FareSplitter(String tripId, double totalFare, int passengerCount) {
        if (totalFare < 0 || passengerCount <= 0) {
            throw new IllegalArgumentException("Invalid fare or passenger count.");
        }
        this.tripId = tripId;
        this.totalFare = totalFare;
        this.passengerCount = passengerCount;
    }

    public FareSplitter(String tripId, double totalFare) {
        this(tripId, totalFare, 2);
    }

    public FareSplitter(String tripId) {
        this(tripId, 0.0, 2);
    }

    public double[] fareBreakdown() {
        if (passengerCount <= 0)
            return new double[0];

        BigDecimal total = BigDecimal.valueOf(totalFare).setScale(2, RoundingMode.HALF_UP);
        BigDecimal count = BigDecimal.valueOf(passengerCount);

        BigDecimal baseShare = total.divide(count, 2, RoundingMode.DOWN);
        double[] shares = new double[passengerCount];
        Arrays.fill(shares, baseShare.doubleValue());

        BigDecimal allocatedSum = baseShare.multiply(count);
        BigDecimal remainder = total.subtract(allocatedSum);
        int remPaise = remainder.multiply(BigDecimal.valueOf(100)).intValue();

        for (int i = passengerCount - 1; i >= passengerCount - remPaise && i >= 0; i--) {
            shares[i] = BigDecimal.valueOf(shares[i]).add(BigDecimal.valueOf(0.01)).setScale(2, RoundingMode.HALF_UP)
                    .doubleValue();
        }

        return shares;
    }

    public boolean isConfirmationOverdue(int confirmed, int expected) {
        return confirmed < expected;
    }
}

public class PracticeP2_FareSplitter {
    public static void main(String[] args) {
        FareSplitter fs1 = new FareSplitter("TRIP001", 100000, 3);
        System.out.println(Arrays.toString(fs1.fareBreakdown()));

        FareSplitter fs3 = new FareSplitter("TRIP003");
        System.out.println(Arrays.toString(fs3.fareBreakdown()));
    }
}