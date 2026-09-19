package oop.week3;

class ParkingSlot {
    String slotNo;
    int capacity;
    int occupiedCount;

    public ParkingSlot(String slotNo, int capacity, int occupiedCount) {
        this.slotNo = slotNo;
        this.capacity = capacity;
        this.occupiedCount = occupiedCount;
    }

    public boolean allot(String vehicleNo) {
        if (occupiedCount < capacity) {
            occupiedCount++;
            return true;
        }
        return false;
    }

    public static ParkingSlot findAvailableSlot(ParkingSlot[] slots) {
        if (slots == null)
            return null;
        for (ParkingSlot s : slots) {
            if (s.occupiedCount < s.capacity) {
                return s;
            }
        }
        return null;
    }

    public static void safeAllot(ParkingSlot[] slots, String vehicleNo) {
        ParkingSlot slot = findAvailableSlot(slots);
        if (slot != null) {
            slot.allot(vehicleNo);
            System.out.println(vehicleNo + " allotted to slot " + slot.slotNo);
        } else {
            System.out.println("No slots available for " + vehicleNo);
        }
    }
}

public class AssignmentF3_ParkingSlot {
    public static void main(String[] args) {
        ParkingSlot[] availableSlots = {
                new ParkingSlot("A1", 4, 3),
                new ParkingSlot("A2", 5, 5)
        };
        ParkingSlot.safeAllot(availableSlots, "TN09AB1234");

        ParkingSlot[] fullSlots = {
                new ParkingSlot("A1", 4, 4),
                new ParkingSlot("A2", 5, 5)
        };
        ParkingSlot.safeAllot(fullSlots, "TN09AB1234");
    }
}