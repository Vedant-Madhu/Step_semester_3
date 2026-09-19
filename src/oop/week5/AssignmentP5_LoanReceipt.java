package oop.week5;

import java.util.Arrays;

class LoanReceipt {
    protected final String memberId;
    protected final String[] bookIds;

    public LoanReceipt(String memberId, String[] bookIds) {
        if (bookIds == null) {
            throw new IllegalArgumentException("Book IDs cannot be null.");
        }
        for (String id : bookIds) {
            if (id == null || !id.matches("BK-\\d{3}")) {
                throw new IllegalArgumentException("Invalid book ID format: " + id);
            }
        }
        this.memberId = memberId;
        this.bookIds = Arrays.copyOf(bookIds, bookIds.length);
    }

    public String[] getBookIds() {
        return Arrays.copyOf(bookIds, bookIds.length);
    }

    public LoanReceipt withCorrectedBookId(int index, String newId) {
        if (newId == null || !newId.matches("BK-\\d{3}")) {
            throw new IllegalArgumentException("Invalid book ID format.");
        }
        String[] newIds = Arrays.copyOf(bookIds, bookIds.length);
        if (index >= 0 && index < newIds.length) {
            newIds[index] = newId;
        }
        return new LoanReceipt(this.memberId, newIds);
    }

    public String getMemberId() {
        return memberId;
    }

    public static String processNightlyCirculation(LoanReceipt[] receipts) {
        if (receipts == null)
            return "0 processed | 0 null skipped | 0 reference-only | 0 regular";
        int processed = 0, nullSkipped = 0, refOnly = 0, regular = 0;

        for (LoanReceipt r : receipts) {
            if (r == null) {
                nullSkipped++;
                continue;
            }
            processed++;
            if (r instanceof ReferenceOnlyLoanReceipt) {
                refOnly++;
            } else {
                regular++;
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | " + refOnly + " reference-only | " + regular
                + " regular";
    }
}

class ReferenceOnlyLoanReceipt extends LoanReceipt {
    private final String roomNumber;

    public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds, String roomNumber) {
        super(memberId, bookIds);
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }
}

public class AssignmentP5_LoanReceipt {
    static {
        System.out.println("LoanReceipt system initialized.");
    }

    public static void main(String[] args) {
        try {
            new LoanReceipt("LIB-8841", new String[] { "BK-100", "bad" });
        } catch (IllegalArgumentException e) {
            System.out.println("construction rejected");
        }

        LoanReceipt r = new LoanReceipt("LIB-8841", new String[] { "BK-100", "BK-101" });
        String[] ids = r.getBookIds();
        if (ids.length > 0)
            ids[0] = "HACKED";
        System.out.println(r.getBookIds()[0]);

        String result = LoanReceipt.processNightlyCirculation(new LoanReceipt[] {
                new ReferenceOnlyLoanReceipt("LIB-001", new String[] { "BK-200" }, "Reading Room 3"),
                null,
                new LoanReceipt("LIB-002", new String[] { "BK-201" })
        });
        System.out.println(result);
    }
}