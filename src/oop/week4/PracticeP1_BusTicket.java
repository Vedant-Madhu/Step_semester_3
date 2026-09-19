package oop.week4;

import java.util.HashSet;
import java.util.Set;

class BusTicket {
    private String passengerName;
    private String destination;
    private boolean checkedIn;

    public BusTicket(String passengerName, String destination) {
        if (!isValidName(passengerName)) {
            throw new IllegalArgumentException("Invalid passenger name: " + passengerName);
        }
        if (!isValidDestination(destination)) {
            throw new IllegalArgumentException("Invalid destination: " + destination);
        }
        this.passengerName = passengerName.trim();
        this.destination = destination.trim();
        this.checkedIn = false;
    }

    private static boolean isValidName(String name) {
        if (name == null)
            return false;
        String trimmed = name.trim();
        return !trimmed.isEmpty() && trimmed.matches("^[a-zA-Z\\s]+$");
    }

    private static boolean isValidDestination(String dest) {
        if (dest == null)
            return false;
        String trimmed = dest.trim();
        return !trimmed.isEmpty() && trimmed.matches("^[a-zA-Z\\s]+$");
    }

    public void markCheckedIn() {
        if (this.checkedIn) {
            System.out
                    .println("Warning: Ticket for " + passengerName + " to " + destination + " is already checked in!");
            return;
        }
        this.checkedIn = true;
        System.out.println("Checked in successfully for " + passengerName);
    }

    public String getUniqueKey() {
        return passengerName + "|" + destination;
    }

    public static void processBatch(String[][] rawBookings) {
        int validCount = 0;
        int rejectedCount = 0;
        int duplicateCount = 0;

        Set<String> acceptedPairs = new HashSet<>();

        if (rawBookings == null) {
            System.out.println("Valid: 0 | Rejected: 0 | Duplicates skipped: 0");
            return;
        }

        for (String[] booking : rawBookings) {
            if (booking == null || booking.length < 2) {
                rejectedCount++;
                continue;
            }
            String name = booking[0];
            String dest = booking[1];

            try {
                BusTicket ticket = new BusTicket(name, dest);
                String key = ticket.getUniqueKey();
                if (acceptedPairs.contains(key)) {
                    duplicateCount++;
                } else {
                    acceptedPairs.add(key);
                    validCount++;
                }
            } catch (IllegalArgumentException e) {
                rejectedCount++;
            }
        }

        System.out.println(
                "Valid: " + validCount + " | Rejected: " + rejectedCount + " | Duplicates skipped: " + duplicateCount);
    }
}

public class PracticeP1_BusTicket {
    public static void main(String[] args) {
        String[][] rawBookings = {
                { "Divya", "Chennai" },
                { "", "Bangalore" },
                { "Ravi123", "Pune" },
                { "Divya", "Chennai" },
                { " ", " " }
        };
        BusTicket.processBatch(rawBookings);
    }
}