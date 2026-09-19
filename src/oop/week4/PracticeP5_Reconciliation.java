package oop.week4;

class BusTicketAccount {
    protected String bookingId;
    protected double ticketFare;
    private static BoardingPenaltyCalculator penaltyCalc;

    static {
        penaltyCalc = new BoardingPenaltyCalculator(1.0);
    }

    public BusTicketAccount(String bookingId, double ticketFare) {
        this.bookingId = bookingId;
        this.ticketFare = ticketFare;
    }

    public BusTicketAccount(String bookingId) {
        this(bookingId, 1000.0);
    }

    public final double calculatePenalty(int minutesLate) {
        return penaltyCalc.calculatePenalty(ticketFare, minutesLate);
    }

    public static void processBatch(BusTicketAccount[] accounts, double[] amounts, int[] minutesLateArray) {
        if (accounts == null)
            return;
        int processed = 0, nullSkipped = 0, sleeper = 0, regular = 0;
        double grandTotal = 0.0;

        for (int i = 0; i < accounts.length; i++) {
            BusTicketAccount acc = accounts[i];
            if (acc == null) {
                nullSkipped++;
                continue;
            }
            int lateness = (minutesLateArray != null && i < minutesLateArray.length) ? minutesLateArray[i] : 0;
            grandTotal += acc.calculatePenalty(lateness);
            processed++;

            if (acc instanceof SleeperCoachAccount)
                sleeper++;
            else
                regular++;
        }
        System.out.println(processed + " processed | " + nullSkipped + " null skipped | " + sleeper + " sleeper | "
                + regular + " regular | grand total penalties = Rs " + grandTotal);
    }
}

class SleeperCoachAccount extends BusTicketAccount {
    public SleeperCoachAccount(String id, double fare) {
        super(id, fare);
    }

    public SleeperCoachAccount(String id) {
        super(id);
    }
}

public class PracticeP5_Reconciliation {
    public static void main(String[] args) {
        BusTicketAccount[] accounts = { new SleeperCoachAccount("BK001", 2000), null,
                new BusTicketAccount("BK002", 1200) };
        BusTicketAccount.processBatch(accounts, new double[] { 1200, 900, 700 }, new int[] { 10, 5, 0 });
    }
}