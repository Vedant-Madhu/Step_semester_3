package oop.week3;

class BookIssue {
    String title;
    String borrowerName;
    int daysOverdue;

    public BookIssue(String title, String borrowerName, int daysOverdue) {
        this.title = title;
        this.borrowerName = borrowerName;
        this.daysOverdue = daysOverdue;
    }

    public double fineAmount() {
        return daysOverdue > 0 ? daysOverdue * 5.0 : 0.0;
    }

    public boolean isSeverelyOverdue() {
        return daysOverdue > 14;
    }

    public static double totalFineCollected(BookIssue[] issues) {
        if (issues == null)
            return 0.0;
        double total = 0;
        for (BookIssue b : issues) {
            total += b.fineAmount();
        }
        return total;
    }
}

public class AssignmentF1_BookIssue {
    public static void main(String[] args) {
        BookIssue[] books = {
                new BookIssue("Clean Code", "Alice", 18),
                new BookIssue("Effective Java", "Bob", 5),
                new BookIssue("Refactoring", "Charlie", 0),
                new BookIssue("DSA Handbook", "David", 21),
                new BookIssue("Design Patterns", "Eve", 9)
        };

        for (BookIssue b : books) {
            String status = b.isSeverelyOverdue() ? "Severely overdue" : (b.daysOverdue > 0 ? "days OK" : "OK");
            System.out.println(b.title + " " + b.daysOverdue + " days - " + status);
        }
        System.out.println("Total fine collected: Rs " + BookIssue.totalFineCollected(books));
    }
}