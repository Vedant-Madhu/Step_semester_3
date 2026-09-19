package oop.week3;

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
        double pay = 0;
        if (employee instanceof ManagerEmployee) {
            pay = ((ManagerEmployee) employee).effectiveSalary();
        } else if (employee instanceof InternEmployee) {
            pay = ((InternEmployee) employee).effectiveSalary();
        } else {
            pay = employee.getSalary();
        }

        String slotStr = (slot != null) ? slot.slotNo : "no parking assigned";
        return name + " | Pay: Rs " + pay + " | Slot: " + slotStr;
    }
}

public class AssignmentF5_CompanyRecord {
    public static void main(String[] args) {
        Employee e1 = new ManagerEmployee("M1", "Divya", 70000, 8000);
        Employee e2 = new Employee("M2", "Karan", 40000);
        Employee e3 = new InternEmployee("M3", "Meera", 12000, 10000);

        ParkingSlot s1 = new ParkingSlot("A1", 2, 0);
        ParkingSlot s2 = new ParkingSlot("A2", 2, 0);

        CompanyEmployeeRecord r1 = new CompanyEmployeeRecord("Divya", "EMP1", e1, s1);
        CompanyEmployeeRecord r2 = new CompanyEmployeeRecord("Karan", "EMP2", e2, s2);
        CompanyEmployeeRecord r3 = new CompanyEmployeeRecord("Meera", "EMP3", e3, null);

        System.out.println(r1.fullProfile());
        System.out.println(r2.fullProfile());
        System.out.println(r3.fullProfile());
        System.out.println("Total records: " + CompanyEmployeeRecord.totalRecords);
    }
}