package oop.week3;

class CorrectSrmStudent {
    String name;
    String regNo;
    int attendance;

    static String university = "SRMIST";
    static int admissionCount = 0;

    public CorrectSrmStudent(String name, int attendance) {
        this.name = name;
        admissionCount++;
        this.regNo = "RA23110030101" + admissionCount;
        this.attendance = attendance;
    }

    public void printIdCard() {
        System.out.println(name + " " + regNo);
    }

    public static void printTotalAdmissions() {
        System.out.println("Students admitted so far: " + admissionCount);
    }
}

public class PracticeF4_SrmStudent {
    public static void main(String[] args) {
        CorrectSrmStudent s1 = new CorrectSrmStudent("Ravi", 85);
        CorrectSrmStudent s2 = new CorrectSrmStudent("Meera", 90);
        s1.printIdCard();
        s2.printIdCard();
        CorrectSrmStudent.printTotalAdmissions();
    }
}