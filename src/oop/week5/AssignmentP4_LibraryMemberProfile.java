package oop.week5;

class LibraryMemberProfile {
    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswer;
    private boolean idSet = false;

    public LibraryMemberProfile() {
        this(null, null);
    }

    public LibraryMemberProfile(String name) {
        this(null, name);
    }

    public LibraryMemberProfile(String membershipId, String name) {
        if (membershipId != null) {
            setMembershipId(membershipId);
        }
        this.name = name;
        this.premiumMember = false;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String id) {
        if (!idSet) {
            this.membershipId = id;
            this.idSet = true;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(boolean premium) {
        this.premiumMember = premium;
    }

    public void setSecurityAnswer(String answer) {
        if (answer != null) {
            this.securityAnswer = String.valueOf(answer.hashCode());
        }
    }
}

public class AssignmentP4_LibraryMemberProfile {
    public static void main(String[] args) {
        System.out.println(new LibraryMemberProfile("Priya Nair").getMembershipId());
        System.out.println(new LibraryMemberProfile("LIB-8841", "Priya Nair").getMembershipId());

        LibraryMemberProfile m = new LibraryMemberProfile();
        m.setMembershipId("LIB-8841");
        m.setMembershipId("FAKE-0000");
        System.out.println(m.getMembershipId());
    }
}