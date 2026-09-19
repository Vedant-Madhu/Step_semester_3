package oop.week5;

class PatientRecord {
    private String patientId;
    String wardCode;
    protected double vitalsScore;
    public String facilityName;

    public PatientRecord(String patientId, String wardCode, double vitalsScore, String facilityName) {
        if (patientId == null) {
            throw new IllegalArgumentException("Patient ID cannot be null.");
        }
        String trimmedId = patientId.trim();
        if (trimmedId.isEmpty() || trimmedId.length() < 4) {
            throw new IllegalArgumentException("Patient ID must be at least 4 characters long and not blank.");
        }
        this.patientId = trimmedId;
        this.wardCode = wardCode;
        this.vitalsScore = vitalsScore;
        this.facilityName = facilityName;
    }

    public String getPatientId() {
        return patientId;
    }
}

class AccessRuleEngine {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier == null || accessorContext == null)
            return "DENIED";
        switch (fieldModifier.toLowerCase()) {
            case "private":
                return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
            case "default":
            case "protected":
                if (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE")) {
                    return "ALLOWED";
                }
                return "DENIED";
            case "public":
                return "ALLOWED";
            default:
                return "DENIED";
        }
    }

    public static String summarizeBatch(String[][] attempts) {
        if (attempts == null)
            return "Allowed: 0 | Denied: 0";
        int allowed = 0;
        int denied = 0;
        for (String[] attempt : attempts) {
            if (attempt != null && attempt.length >= 2) {
                if ("ALLOWED".equals(classifyAccess(attempt[0], attempt[1]))) {
                    allowed++;
                } else {
                    denied++;
                }
            }
        }
        return "Allowed: " + allowed + " | Denied: " + denied;
    }
}

public class PracticeP1_FieldVisibility {
    public static void main(String[] args) {
        System.out.println(AccessRuleEngine.classifyAccess("private", "SAME_CLASS"));
        System.out.println(AccessRuleEngine.classifyAccess("default", "DIFFERENT_PACKAGE"));
        System.out.println(AccessRuleEngine.summarizeBatch(new String[][] {
                { "protected", "SAME_PACKAGE" },
                { "protected", "DIFFERENT_PACKAGE" },
                { "public", "DIFFERENT_PACKAGE" }
        }));

        try {
            new PatientRecord("MT9", "W3", 98.2, "MediTrack Central");
        } catch (IllegalArgumentException e) {
            System.out.println("construction rejected");
        }

        PatientRecord valid = new PatientRecord("MT94", "W3", 98.2, "MediTrack Central");
        System.out.println("Successfully created: " + valid.getPatientId());
    }
}