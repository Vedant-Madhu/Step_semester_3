package oop.week3;

class FeeAccount {
    private String regNo;
    protected double totalFee;
    protected double amountPaid;

    public FeeAccount(String regNo, double totalFee, double amountPaid) {
        this.regNo = regNo;
        this.totalFee = totalFee;
        this.amountPaid = amountPaid;
    }

    public void pay(double amount) {
        if (amount > 0) {
            this.amountPaid += amount;
        }
    }

    public double getDue() {
        return totalFee - amountPaid;
    }
}

class HostelFeeAccount extends FeeAccount {
    public HostelFeeAccount(String regNo, double totalFee, double amountPaid) {
        super(regNo, totalFee, amountPaid);
    }

    public void payInTwoInstallments(double amount) {
        pay(amount / 2);
        pay(amount / 2);
    }
}

class ScholarshipFeeAccount extends FeeAccount {
    private double scholarshipPercent;

    public ScholarshipFeeAccount(String regNo, double totalFee, double amountPaid, double scholarshipPercent) {
        super(regNo, totalFee, amountPaid);
        this.scholarshipPercent = scholarshipPercent;
    }

    public double effectiveDue() {
        double baseDue = getDue();
        return baseDue - (baseDue * (scholarshipPercent / 100.0));
    }
}

public class PracticeF2_FeeAccounts {
    public static void main(String[] args) {
        FeeAccount plain = new FeeAccount("R01", 150000, 150000);
        HostelFeeAccount hostel = new HostelFeeAccount("R02", 200000, 60000);
        ScholarshipFeeAccount scholarship = new ScholarshipFeeAccount("R03", 180000, 0, 20);

        System.out.println("Plain account due: Rs " + plain.getDue());
        System.out.println("Hostel account due: Rs " + hostel.getDue());
        System.out.println("Scholarship account effective due: Rs " + scholarship.effectiveDue());
    }
}