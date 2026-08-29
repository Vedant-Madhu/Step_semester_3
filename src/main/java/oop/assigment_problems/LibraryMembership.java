package oop.assigment_problems;

class BrokenLibraryMember {
    static String name;
    static String memberId;
    static int booksIssued;

    public BrokenLibraryMember(String name, String memberId, int booksIssued) {
        BrokenLibraryMember.name = name;
        BrokenLibraryMember.memberId = memberId;
        BrokenLibraryMember.booksIssued = booksIssued;
    }

    public void printName() {
        System.out.println(name);
    }
}

class LibraryMember {
    private String name;
    private String memberId;
    private int booksIssued;

    static String libraryName = "City Central Library";
    static int memberCount = 1000;

    public LibraryMember(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
        memberCount++;
        this.memberId = "LM-" + memberCount;
    }

    public void printMemberCard() {
        System.out.println(name + "  " + memberId);
    }

    public static void printTotalMembers() {
        System.out.println("Total members: " + (memberCount - 1000));
    }
}

public class LibraryMembership {
    public static void main(String[] args) {
        BrokenLibraryMember b1 = new BrokenLibraryMember("Aditi", "LM-1001", 2);
        BrokenLibraryMember b2 = new BrokenLibraryMember("Rohan", "LM-1002", 4);

        b1.printName();
        b2.printName();

        LibraryMember f1 = new LibraryMember("Aditi", 2);
        LibraryMember f2 = new LibraryMember("Rohan", 4);

        f1.printMemberCard();
        f2.printMemberCard();
        LibraryMember.printTotalMembers();
    }
}