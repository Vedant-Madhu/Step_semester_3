package oop.assigment_problems;

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
        if (daysOverdue > 0) {
            return daysOverdue * 5.0;
        }
        return 0.0;
    }

    public boolean isSeverelyOverdue() {
        return daysOverdue > 14;
    }

    public static double totalFineCollected(BookIssue[] issues) {
        double total = 0.0;
        for (int i = 0; i < issues.length; i++) {
            if (issues[i] != null) {
                total += issues[i].fineAmount();
            }
        }
        return total;
    }
}

public class LibraryFineSystem {
    public static void main(String[] args) {
        BookIssue[] books = new BookIssue[5];
        books[0] = new BookIssue("Clean Code", "Alice", 18);
        books[1] = new BookIssue("Effective Java", "Bob", 5);
        books[2] = new BookIssue("Refactoring", "Charlie", 0);
        books[3] = new BookIssue("DSA Handbook", "David", 21);
        books[4] = new BookIssue("Design Patterns", "Emma", 9);

        for (int i = 0; i < books.length; i++) {
            String status = books[i].isSeverelyOverdue() ? "Severely overdue" : "OK";
            System.out.println(books[i].title + " " + books[i].daysOverdue + " days - " + status);
        }

        System.out.println("Total fine collected: Rs " + BookIssue.totalFineCollected(books));
    }
}