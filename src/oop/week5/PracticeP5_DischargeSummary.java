package oop.week5;

import java.util.Arrays;

class DischargeSummary {
    protected final String patientId;
    protected final String[] medicationCodes;

    public DischargeSummary(String patientId, String[] medicationCodes) {
        if (medicationCodes == null) {
            throw new IllegalArgumentException("Medication codes cannot be null.");
        }
        for (String code : medicationCodes) {
            if (code == null || !code.matches("MED-[A-Z]")) {
                throw new IllegalArgumentException("Invalid medication code format: " + code);
            }
        }
        this.patientId = patientId;
        this.medicationCodes = Arrays.copyOf(medicationCodes, medicationCodes.length);
    }

    public String[] getMedicationCodes() {
        return Arrays.copyOf(medicationCodes, medicationCodes.length);
    }

    public DischargeSummary withCorrectedMedication(int index, String newCode) {
        if (newCode == null || !newCode.matches("MED-[A-Z]")) {
            throw new IllegalArgumentException("Invalid medication code format.");
        }
        String[] newCodes = Arrays.copyOf(medicationCodes, medicationCodes.length);
        if (index >= 0 && index < newCodes.length) {
            newCodes[index] = newCode;
        }
        return new DischargeSummary(this.patientId, newCodes);
    }

    public String getPatientId() {
        return patientId;
    }

    public static String processNightlyBatch(DischargeSummary[] summaries) {
        if (summaries == null)
            return "0 processed | 0 null skipped | 0 critical-care | 0 routine";
        int processed = 0, nullSkipped = 0, criticalCare = 0, routine = 0;

        for (DischargeSummary s : summaries) {
            if (s == null) {
                nullSkipped++;
                continue;
            }
            processed++;
            if (s instanceof CriticalCareDischargeSummary) {
                criticalCare++;
            } else {
                routine++;
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | " + criticalCare + " critical-care | "
                + routine + " routine";
    }
}

class CriticalCareDischargeSummary extends DischargeSummary {
    private final int icuDays;

    public CriticalCareDischargeSummary(String patientId, String[] medicationCodes, int icuDays) {
        super(patientId, medicationCodes);
        this.icuDays = icuDays;
    }

    public int getIcuDays() {
        return icuDays;
    }
}

public class PracticeP5_DischargeSummary {
    static {
        System.out.println("DischargeSummary system initialized.");
    }

    public static void main(String[] args) {
        try {
            new DischargeSummary("MT2026-0142", new String[] { "MED-A", "bad" });
        } catch (IllegalArgumentException e) {
            System.out.println("construction rejected");
        }

        DischargeSummary d = new DischargeSummary("MT2026-0142", new String[] { "MED-A", "MED-B" });
        String[] codes = d.getMedicationCodes();
        if (codes.length > 0)
            codes[0] = "TAMPERED";
        System.out.println(d.getMedicationCodes()[0]);

        String result = DischargeSummary.processNightlyBatch(new DischargeSummary[] {
                new CriticalCareDischargeSummary("MT001", new String[] { "MED-X" }, 4),
                null,
                new DischargeSummary("MT002", new String[] { "MED-Y" })
        });
        System.out.println(result);
    }
}