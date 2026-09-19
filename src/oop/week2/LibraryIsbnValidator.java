package oop.week2;

public class LibraryIsbnValidator {
    public static String normalizeCode(String raw) {
        if (raw == null)
            return "";
        String trimmed = raw.trim();
        if (trimmed.length() < 3)
            return trimmed.toUpperCase();
        String pubCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return pubCode + rest;
    }

    public static void validateAndFormat(String code) {
        if (code == null || code.length() != 13) {
            System.out.println("Invalid: wrong length");
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                System.out.println("Invalid: publisher code must be 3 letters");
                return;
            }
        }
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                System.out.println("Invalid: non-digit body");
                return;
            }
        }
        String pub = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pub).append("] YEAR: ").append(year).append(" | CATALOG: ").append(catalog);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        String raw1 = "pen2026004251";
        validateAndFormat(normalizeCode(raw1));

        String raw2 = "12N2026004251";
        validateAndFormat(normalizeCode(raw2));
    }
}