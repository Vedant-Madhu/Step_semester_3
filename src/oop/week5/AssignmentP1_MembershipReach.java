package oop.week5;

class LibraryMember {
    private String membershipId;
    String branchCode;
    protected double finesOwed;
    public String displayName;

    public LibraryMember(String membershipId, String branchCode, double finesOwed, String displayName) {
        if (membershipId == null) {
            throw new IllegalArgumentException("Membership ID cannot be null.");
        }
        String trimmed = membershipId.trim();
        if (trimmed.isEmpty() || trimmed.length() < 4) {
            throw new IllegalArgumentException("Membership ID must be at least 4 characters.");
        }
        this.membershipId = trimmed;
        this.branchCode = branchCode;
        this.finesOwed = finesOwed;
        this.displayName = displayName;
    }

    public String getMembershipId() {
        return membershipId;
    }
}

class LibraryAccessRuleEngine {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier == null || accessorContext == null)
            return "DENIED";
        switch (fieldModifier.toLowerCase()) {
            case "private":
                return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
            case "default":
            case "protected":
                return (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE")) ? "ALLOWED"
                        : "DENIED";
            case "public":
                return "ALLOWED";
            default:
                return "DENIED";
        }
    }

    public static String summarizeByModifier(String[][] attempts) {
        int privAllowed = 0, privDenied = 0;
        int defAllowed = 0, defDenied = 0;
        int protAllowed = 0, protDenied = 0;
        int pubAllowed = 0, pubDenied = 0;

        if (attempts != null) {
            for (String[] attempt : attempts) {
                if (attempt != null && attempt.length >= 2) {
                    String mod = attempt[0].toLowerCase();
                    boolean allowed = "ALLOWED".equals(classifyAccess(mod, attempt[1]));
                    switch (mod) {
                        case "private":
                            if (allowed)
                                privAllowed++;
                            else
                                privDenied++;
                            break;
                        case "default":
                            if (allowed)
                                defAllowed++;
                            else
                                defDenied++;
                            break;
                        case "protected":
                            if (allowed)
                                protAllowed++;
                            else
                                protDenied++;
                            break;
                        case "public":
                            if (allowed)
                                pubAllowed++;
                            else
                                pubDenied++;
                            break;
                    }
                }
            }
        }
        return "private: " + privAllowed + " allowed / " + privDenied + " denied | " +
                "default: " + defAllowed + " allowed / " + defDenied + " denied | " +
                "protected: " + protAllowed + " allowed / " + protDenied + " denied | " +
                "public: " + pubAllowed + " allowed / " + pubDenied + " denied";
    }
}

public class AssignmentP1_MembershipReach {
    public static void main(String[] args) {
        System.out.println(LibraryAccessRuleEngine.classifyAccess("private", "SAME_CLASS"));
        System.out.println(LibraryAccessRuleEngine.classifyAccess("protected", "DIFFERENT_PACKAGE"));
        System.out.println(LibraryAccessRuleEngine.summarizeByModifier(new String[][] {
                { "private", "SAME_CLASS" },
                { "private", "SAME_PACKAGE" },
                { "default", "SAME_PACKAGE" },
                { "default", "DIFFERENT_PACKAGE" },
                { "protected", "SAME_PACKAGE" },
                { "protected", "SAME_CLASS" },
                { "public", "DIFFERENT_PACKAGE" }
        }));

        try {
            new LibraryMember("LB9", "BR1", 0, "Priya Nair");
        } catch (IllegalArgumentException e) {
            System.out.println("construction rejected");
        }
    }
}