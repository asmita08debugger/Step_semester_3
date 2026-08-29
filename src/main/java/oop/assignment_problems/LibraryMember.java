package main.java.oop.assignment_problems;
class LibraryMember 
{
    String name;
    int borrowedCount;
    LibraryMember(String name, int borrowedCount) 
    {
        this.name = name;
        this.borrowedCount = borrowedCount;
    }
    void borrowBook() 
    {
        if (borrowedCount < 5) 
        {
            borrowedCount++;
            System.out.println(name + " borrowed a book.");
        } 
        else 
        {
            System.out.println("Borrowing limit reached.");
        }
    }
    void returnBook() 
    {
        if (borrowedCount > 0) 
        {
            borrowedCount--;
            System.out.println(name + " returned a book.");
        }
    }
    public static void main(String[] args) 
    {
        LibraryMember m1 = new LibraryMember("Aditi", 4);
        m1.borrowBook();
        m1.borrowBook();
        m1.returnBook();
        System.out.println("Books currently borrowed: " + m1.borrowedCount);
    }
}