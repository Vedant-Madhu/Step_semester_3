package oop.week3;

class HostelRoom {
    String roomNo;
    int beds;
    int occupied;

    public HostelRoom(String roomNo, int beds, int occupied) {
        this.roomNo = roomNo;
        this.beds = beds;
        this.occupied = occupied;
    }

    public boolean allot(String name) {
        if (occupied < beds) {
            occupied++;
            return true;
        }
        return false;
    }

    public static HostelRoom findAvailableRoom(HostelRoom[] rooms) {
        if (rooms == null)
            return null;
        for (HostelRoom r : rooms) {
            if (r.occupied < r.beds) {
                return r;
            }
        }
        return null;
    }

    public static void safeAllot(HostelRoom[] rooms, String studentName) {
        HostelRoom room = findAvailableRoom(rooms);
        if (room != null) {
            room.allot(studentName);
            System.out.println(studentName + " allotted to room " + room.roomNo);
        } else {
            System.out.println("No rooms available for " + studentName);
        }
    }
}

public class PracticeF3_HostelRoom {
    public static void main(String[] args) {
        HostelRoom[] roomsAvailable = {
                new HostelRoom("C-214", 3, 2),
                new HostelRoom("C-507", 2, 2)
        };
        HostelRoom.safeAllot(roomsAvailable, "Divya");

        HostelRoom[] roomsFull = {
                new HostelRoom("C-214", 3, 3),
                new HostelRoom("C-507", 2, 2)
        };
        HostelRoom.safeAllot(roomsFull, "Divya");
    }
}