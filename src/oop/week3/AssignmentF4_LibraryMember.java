package oop.week3;

class CorrectLibraryMember {
    String name;
    String memberId;
    int booksIssued;

    static String libraryName = "Central Library";
    static int memberCount = 0;

    public CorrectLibraryMember(String name, int booksIssued) {
        this.name = name;
        memberCount++;
        this.memberId = "LM-100" + memberCount;
        this.booksIssued = booksIssued;
    }

    public void printMemberCard() {
        System.out.println(name + " " + memberId);
    }

    public static void printTotalMembers() {
        System.out.println("Total members: " + memberCount);
    }
}

public class AssignmentF4_LibraryMember {
    public static void main(String[] args) {
        CorrectLibraryMember m1 = new CorrectLibraryMember("Aditi", 2);
        CorrectLibraryMember m2 = new CorrectLibraryMember("Rohan", 1);
        m1.printMemberCard();
        m2.printMemberCard();
        CorrectLibraryMember.printTotalMembers();
    }
}