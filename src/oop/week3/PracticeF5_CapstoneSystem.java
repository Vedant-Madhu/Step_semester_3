package oop.week3;

class CapstoneStudent {
    String name;
    String regNo;
    HostelFeeAccount feeAccount;
    HostelRoom room;
    static int totalStudents = 0;

    public CapstoneStudent(String name, String regNo, HostelFeeAccount feeAccount, HostelRoom room) {
        this.name = name;
        this.regNo = regNo;
        this.feeAccount = feeAccount;
        this.room = room;
        totalStudents++;
    }

    public String fullStatus() {
        String roomStr = (room != null) ? room.roomNo : "unallotted";
        return name + " | Due: Rs " + feeAccount.getDue() + " | Room: " + roomStr;
    }
}

public class PracticeF5_CapstoneSystem {
    public static void main(String[] args) {
        HostelFeeAccount f1 = new HostelFeeAccount("R1", 140000, 0);
        HostelFeeAccount f2 = new HostelFeeAccount("R2", 180000, 0);
        HostelFeeAccount f3 = new HostelFeeAccount("R3", 200000, 0);

        HostelRoom r1 = new HostelRoom("C-214", 3, 0);
        HostelRoom r2 = new HostelRoom("C-507", 2, 0);

        CapstoneStudent s1 = new CapstoneStudent("Ravi", "101", f1, r1);
        CapstoneStudent s2 = new CapstoneStudent("Anitha", "102", f2, r2);
        CapstoneStudent s3 = new CapstoneStudent("Karthik", "103", f3, null);

        s1.feeAccount.pay(0); // rejected or 0 impact

        System.out.println(s1.fullStatus());
        System.out.println(s2.fullStatus());
        System.out.println(s3.fullStatus());
        System.out.println("Total students: " + CapstoneStudent.totalStudents);
    }
}