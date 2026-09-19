package oop.week2;

public class BankTransactionValidator {
    public static String normalizeReference(String raw) {
        if (raw == null)
            return "";
        String trimmed = raw.trim();
        if (trimmed.length() < 3)
            return trimmed.toUpperCase();
        String bankCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return bankCode + rest;
    }

    public static void validateAndFormat(String reference) {
        if (reference == null || reference.length() != 14) {
            System.out.println("Invalid: wrong length");
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                System.out.println("Invalid: bank code must be 3 letters");
                return;
            }
        }
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                System.out.println("Invalid: non-digit body");
                return;
            }
        }
        String bank = reference.substring(0, 3);
        String datePart = reference.substring(3, 9);
        String dd = datePart.substring(0, 2);
        String mm = datePart.substring(2, 4);
        String yy = datePart.substring(4, 6);
        String seq = reference.substring(9);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bank).append("] DATE: ").append(dd).append("/").append(mm).append("/").append(yy)
                .append(" | SEQ: ").append(seq);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        String raw1 = "  hdf03022600042  ";
        String norm1 = normalizeReference(raw1);
        validateAndFormat(norm1);

        String raw2 = "12F03022600042";
        String norm2 = normalizeReference(raw2);
        validateAndFormat(norm2);
    }
}