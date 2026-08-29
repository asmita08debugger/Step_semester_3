package main.java.oop.assignment_problems;
class BookIssue {
    String title;
    String borrowerName;
    int daysOverdue;
    BookIssue(String title, String borrowerName, int daysOverdue) 
    {
        this.title = title;
        this.borrowerName = borrowerName;
        this.daysOverdue = daysOverdue;
    }
    double fineAmount() 
    {
        if (daysOverdue > 0)
            return daysOverdue * 5;
        else
            return 0;
    }
    boolean isSeverelyOverdue() 
    {
        return daysOverdue > 14;
    }
    // fineAmount() belongs to one book, so it is an instance method.
    // totalFineCollected() works on many books, so it is static.
    static double totalFineCollected(BookIssue[] issues) 
    {
        double total = 0;
        for (BookIssue b : issues) 
        {
            total += b.fineAmount();
        }
        return total;
    }
    public static void main(String[] args) 
    {
        BookIssue[] books = {
            new BookIssue("Clean Code", "Aditi", 18),
            new BookIssue("Effective Java", "Rohan", 5),
            new BookIssue("Refactoring", "Meera", 0),
            new BookIssue("DSA Handbook", "Karan", 21),
            new BookIssue("Design Patterns", "Divya", 9)};
        for (BookIssue b : books) 
        {
            if (b.isSeverelyOverdue())
                System.out.println(b.title + " - " + b.daysOverdue + " days - Severely overdue");
            else
                System.out.println(b.title + " - " + b.daysOverdue + " days - OK");
        }
        System.out.println("Total fine collected: Rs " +BookIssue.totalFineCollected(books));
    }
}