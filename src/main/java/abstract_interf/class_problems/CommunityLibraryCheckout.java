package main.java.abstract_interf.class_problems;
interface Borrowable 
{
    void borrow();
    void returnItem();
}
interface Reservable 
{
    void reserve();
}
abstract class LibraryItem 
{
    protected String title;
    private static int itemCount = 0;
    public LibraryItem(String title) 
    {
        this.title = title;
        itemCount++;
    }
    public String getTitle() 
    {
        return title;
    }
    public static int getItemCount() 
    {
        return itemCount;
    }
    public abstract void display();
}
class Book extends LibraryItem implements Borrowable, Reservable 
{
    public Book(String title) 
    {
        super(title);
    }
    @Override
    public void display() 
    {
        System.out.println("Book: " + title);
    }
    @Override
    public void borrow() 
    {
        System.out.println("Book borrowed: " + title);
    }
    @Override
    public void returnItem() 
    {
        System.out.println("Book returned: " + title);
    }
    @Override
    public void reserve() 
    {
        System.out.println("Book reserved: " + title);
    }
}
class Magazine extends LibraryItem implements Reservable 
{
    public Magazine(String title) 
    {
        super(title);
    }
    @Override
    public void display() 
    {
        System.out.println("Magazine: " + title);
    }
    @Override
    public void reserve() 
    {
        System.out.println("Magazine reserved: " + title);
    }
}
class DVD extends LibraryItem implements Borrowable 
{
    public DVD(String title) 
    {
        super(title);
    }
    @Override
    public void display() 
    {
        System.out.println("DVD: " + title);
    }
    @Override
    public void borrow() 
    {
        System.out.println("DVD borrowed: " + title);
    }
    @Override
    public void returnItem() 
    {
        System.out.println("DVD returned: " + title);
    }
}
public class CommunityLibraryCheckout 
{
    public static void main(String[] args) 
    {
        LibraryItem book = new Book("Java Programming");
        LibraryItem magazine = new Magazine("Tech Monthly");
        LibraryItem dvd = new DVD("Inception");
        LibraryItem[] items = {book, magazine, dvd};
        for (LibraryItem item : items) 
        {
            item.display();
            if (item instanceof Borrowable) 
            {
                Borrowable borrowable = (Borrowable) item;
                borrowable.borrow();
                borrowable.returnItem();
            }
            if (item instanceof Reservable) 
            {
                Reservable reservable = (Reservable) item;
                reservable.reserve();
            }
        }
        System.out.println("Total items: " + LibraryItem.getItemCount());
        Object object = book;
        if (object instanceof Book) 
        {
            System.out.println("Object is a Book");
        }
        if (object instanceof Borrowable) 
        {
            System.out.println("Object is Borrowable");
        }
        if (object instanceof Reservable) 
        {
            System.out.println("Object is Reservable");
        }
    }
}