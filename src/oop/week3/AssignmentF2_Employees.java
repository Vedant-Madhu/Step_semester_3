package oop.week3;

class Employee {
    private String empId;
    private String empName;
    protected double salary;

    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}

class ManagerEmployee extends Employee {
    private double teamBonus;

    public ManagerEmployee(String empId, String empName, double salary, double teamBonus) {
        super(empId, empName, salary);
        this.teamBonus = teamBonus;
    }

    public double effectiveSalary() {
        return getSalary() + teamBonus;
    }
}

class InternEmployee extends Employee {
    private double stipendCap;

    public InternEmployee(String empId, String empName, double salary, double stipendCap) {
        super(empId, empName, salary);
        this.stipendCap = stipendCap;
    }

    public double effectiveSalary() {
        return Math.min(getSalary(), stipendCap);
    }
}

public class AssignmentF2_Employees {
    public static void main(String[] args) {
        Employee plain = new Employee("E1", "John", 40000);
        ManagerEmployee manager = new ManagerEmployee("E2", "Sarah", 70000, 8000);
        InternEmployee intern = new InternEmployee("E3", "Alex", 12000, 10000);

        System.out.println("Plain employee pay: Rs " + plain.getSalary());

        if (manager instanceof ManagerEmployee) {
            System.out.println("Manager effective pay: Rs " + manager.effectiveSalary());
        }
        if (intern instanceof InternEmployee) {
            System.out.println("Intern effective pay: Rs " + intern.effectiveSalary());
        }
    }
}