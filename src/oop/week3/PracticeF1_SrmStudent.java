package oop.week3;

class SrmStudentF1 {
    String name;
    String regNo;
    int attendance;

    public SrmStudentF1(String name, String regNo, int attendance) {
        this.name = name;
        this.regNo = regNo;
        this.attendance = attendance;
    }

    public void addAttendanceUpdate(int newAttendance) {
        this.attendance = newAttendance;
    }

    public boolean isEligible() {
        return this.attendance >= 75;
    }

    public static double classAverage(SrmStudentF1[] students) {
        if (students == null || students.length == 0)
            return 0.0;
        int sum = 0;
        for (SrmStudentF1 s : students) {
            sum += s.attendance;
        }
        return (double) sum / students.length;
    }
}

public class PracticeF1_SrmStudent {
    public static void main(String[] args) {
        SrmStudentF1[] students = {
                new SrmStudentF1("Ravi", "RA1", 82),
                new SrmStudentF1("Anitha", "RA2", 68),
                new SrmStudentF1("Karthik", "RA3", 91),
                new SrmStudentF1("Meera", "RA4", 74),
                new SrmStudentF1("Suresh", "RA5", 60)
        };

        for (SrmStudentF1 s : students) {
            String status = s.isEligible() ? "Eligible" : "Detained";
            System.out.println(s.name + " " + s.attendance + "% " + status);
        }
        System.out.println("Class average: " + SrmStudentF1.classAverage(students) + "%");
    }
}