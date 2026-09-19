package oop.week4;

class DeliveryAccount {
    protected String studentId;
    protected double orderValue;
    private static SurgeFeeCalculator surgeCalc;

    static {
        surgeCalc = new SurgeFeeCalculator(1.0);
    }

    public DeliveryAccount(String studentId, double orderValue) {
        this.studentId = studentId;
        this.orderValue = orderValue;
    }

    public DeliveryAccount(String studentId) {
        this(studentId, 500.0);
    }

    public final double calculateSurgeFee(int delayMinutes) {
        return surgeCalc.calculateSurgeFee(orderValue, delayMinutes);
    }

    public static void processBatch(DeliveryAccount[] accounts, double[] amounts, int[] delayMinutesArray) {
        if (accounts == null)
            return;
        int processed = 0, nullSkipped = 0, premium = 0, regular = 0;
        double total = 0.0;

        for (int i = 0; i < accounts.length; i++) {
            DeliveryAccount acc = accounts[i];
            if (acc == null) {
                nullSkipped++;
                continue;
            }
            int delay = (delayMinutesArray != null && i < delayMinutesArray.length) ? delayMinutesArray[i] : 0;
            total += acc.calculateSurgeFee(delay);
            processed++;
            if (acc instanceof PremiumDeliveryAccount)
                premium++;
            else
                regular++;
        }
        System.out.println(processed + " processed | " + nullSkipped + " null skipped | " + premium + " premium | "
                + regular + " regular | grand total surge fees = Rs " + total);
    }
}

class PremiumDeliveryAccount extends DeliveryAccount {
    public PremiumDeliveryAccount(String id, double val) {
        super(id, val);
    }

    public PremiumDeliveryAccount(String id) {
        super(id);
    }
}

public class AssignmentP5_MultiKitchen {
    public static void main(String[] args) {
        DeliveryAccount[] accounts = { new PremiumDeliveryAccount("STU001", 500), null,
                new DeliveryAccount("STU002", 300) };
        DeliveryAccount.processBatch(accounts, new double[] { 500, 400, 300 }, new int[] { 10, 5, 0 });
    }
}