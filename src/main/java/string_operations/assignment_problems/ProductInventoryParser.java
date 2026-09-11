package main.java.string_operations.assignment_problems;
import java.util.Scanner;
public class ProductInventoryParser 
{
    static void parseInventoryRecord(String csvLine) 
    {
        String[] details = csvLine.split(",");
        if (details.length != 3) 
        {
            System.out.println("Invalid Record");
        } 
        else 
        {
            System.out.println("Product: " + details[0] + " | SKU: " + details[1] + " | Qty: " + details[2]);
        }
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter inventory record: ");
        String csvLine = sc.nextLine();
        parseInventoryRecord(csvLine);
        sc.close();
    }
}