package oop.week4;

import java.util.Set;

class DeliverySlot {
    private String orderId;
    private String timeSlot;
    private static final Set<String> PEAK = Set.of("12:00-13:00", "13:00-14:00", "19:00-20:00", "20:00-21:00");

    public DeliverySlot(String orderId, String timeSlot) {
        this.orderId = orderId;
        this.timeSlot = (timeSlot == null || timeSlot.trim().isEmpty()) ? "ASAP" : timeSlot.trim();
    }

    public DeliverySlot(String orderId) {
        this(orderId, "ASAP");
    }

    public boolean isPeakHour() {
        return PEAK.contains(timeSlot);
    }
}

public class AssignmentP2_DeliverySlot {
    public static void main(String[] args) {
        System.out.println(new DeliverySlot("ORD101", "13:00-14:00").isPeakHour());
        System.out.println(new DeliverySlot("ORD102").isPeakHour());
    }
}