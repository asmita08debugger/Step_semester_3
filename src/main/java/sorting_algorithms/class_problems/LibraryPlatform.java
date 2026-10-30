package main.java.sorting_algorithms.class_problems;
interface Reservable 
{
    void reserve(String member);
}
interface Downloadable 
{
    void download();
}
class Book implements Reservable 
{
    String id;
    Book(String id) 
    {
        this.id = id;
    }
    public void reserve(String member) 
    {
        System.out.println(id + " reserved for " + member);
    }
}
class EBook implements Reservable, Downloadable 
{
    String id;
    EBook(String id) 
    {
        this.id = id;
    }
    public void reserve(String member) 
    {
        System.out.println(id + " reserved for " + member);
    }
    public void download() 
    {
        System.out.println(id + " downloaded");
    }
}
public class LibraryPlatform 
{
    static Object[] resources = new Object[10];
    static String[] ids = new String[10];
    static int count = 0;
    static void add(String id, Object resource) 
    {
        if (find(id) != -1) 
        {
            System.out.println("duplicate rejected");
            return;
        }
        int i = count - 1;
        while (i >= 0 && ids[i].compareTo(id) > 0) 
        {
            ids[i + 1] = ids[i];
            resources[i + 1] = resources[i];
            i--;
        }
        ids[i + 1] = id;
        resources[i + 1] = resource;
        count++;
        System.out.println(id + " added");
    }
    static int find(String id) 
    {
        int left = 0, right = count - 1;
        while (left <= right) 
        {
            int mid = (left + right) / 2;
            int result = ids[mid].compareTo(id);
            if (result == 0)
                return mid;
            else if (result < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
    static void reserve(String id, String member) 
    {
        int index = find(id);
        if (index == -1) 
        {
            System.out.println(id + " not found");
        } 
        else if (resources[index] instanceof Reservable) 
        {
            ((Reservable) resources[index]).reserve(member);
        } 
        else 
        {
            System.out.println(id + " rejected: reserve unsupported");
        }
    }
    static void download(String id) 
    {
        int index = find(id);
        if (index == -1) 
        {
            System.out.println(id + " not found");
        } 
        else if (resources[index] instanceof Downloadable) 
        {
            ((Downloadable) resources[index]).download();
        } 
        else 
        {
            System.out.println(id + " rejected: download unsupported");
        }
    }
    public static void main(String[] args) 
    {
        add("B1", new Book("B1"));
        add("B1", new Book("B1"));
        add("E1", new EBook("E1"));
        reserve("B1", "M1");
        download("B1");
        download("E1");
        System.out.println("E1 found at index " + find("E1"));
    }
}