package main.java.oop_inheritance.assignment_problems;
public class BookInventory 
{
    private int copiesTotal;
    private int copiesAvailable;
    public BookInventory(int copiesTotal) 
    {
        if (copiesTotal <= 0) 
        {
            throw new IllegalArgumentException("Invalid copies");
        }
        this.copiesTotal = copiesTotal;
        this.copiesAvailable = copiesTotal;
    }
    public void checkOut() 
    {
        if (copiesAvailable > 0) 
        {
            copiesAvailable--;
        }
    }
    public void checkIn() 
    {
        if (copiesAvailable < copiesTotal) 
        {
            copiesAvailable++;
        }
    }
    public int getCopiesAvailable() 
    {
        return copiesAvailable;
    }
    public static void main(String[] args) 
    {
        try 
        {
            new BookInventory(0);
            System.out.println("construction succeeded");
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println("construction rejected");
        }
        BookInventory b = new BookInventory(3);
        b.checkOut();
        b.checkOut();
        b.checkOut();
        b.checkOut();
        System.out.println("After checkouts: " + b.getCopiesAvailable());
        b.checkIn();
        b.checkIn();
        b.checkIn();
        b.checkIn();
        System.out.println("After check-ins: " + b.getCopiesAvailable());
    }
}