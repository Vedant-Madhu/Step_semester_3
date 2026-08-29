package oop.assigment_problems;

class CompanyEmployeeRecord {
    String name;
    String empId;
    Employee employee;
    ParkingSlot slot;

    static int totalRecords = 0;

    public CompanyEmployeeRecord(String name, String empId, Employee employee, ParkingSlot slot) {
        this.name = name;
        this.empId = empId;
        this.employee = employee;
        this.slot = slot;
        totalRecords++;
    }

    public String fullProfile() {
        double pay = 0.0;
        if (employee instanceof ManagerEmployee) {
            pay = ((ManagerEmployee) employee).effectiveSalary();
        } else if (employee instanceof InternEmployee) {
            pay = ((InternEmployee) employee).effectiveSalary();
        } else if (employee != null) {
            pay = employee.getSalary();
        }

        String slotStr = (slot != null) ? slot.slotNo : "no parking assigned";
        return name + " | Pay: Rs " + pay + " | Slot: " + slotStr;
    }
}

public class HRParkingSystem {
    public static void main(String[] args) {
        ParkingSlot slotA1 = new ParkingSlot("A1", 1, 0);
        ParkingSlot slotA2 = new ParkingSlot("A2", 1, 0);

        ManagerEmployee mgr = new ManagerEmployee("M101", "Divya", 70000.0, 8000.0);
        Employee plain = new Employee("E102", "Karan", 40000.0);
        InternEmployee intern = new InternEmployee("I103", "Meera", 12000.0, 10000.0);

        slotA1.allot("TN01AA1111");
        slotA2.allot("TN01AA2222");

        CompanyEmployeeRecord r1 = new CompanyEmployeeRecord("Divya", "M101", mgr, slotA1);
        CompanyEmployeeRecord r2 = new CompanyEmployeeRecord("Karan", "E102", plain, slotA2);
        CompanyEmployeeRecord r3 = new CompanyEmployeeRecord("Meera", "I103", intern, null);

        System.out.println(r1.fullProfile());
        System.out.println(r2.fullProfile());
        System.out.println(r3.fullProfile());

        System.out.println("Total records: " + CompanyEmployeeRecord.totalRecords);
    }
}