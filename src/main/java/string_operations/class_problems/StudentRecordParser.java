package main.java.string_operations.class_problems;
import java.util.Scanner;
public class StudentRecordParser 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student record: ");
        String record = sc.nextLine();
        String[] data = record.split(",");
        if (data.length == 3) 
        {
            System.out.println("Name: " + data[0]);
            System.out.println("Roll Number: " + data[1]);
            System.out.println("Department: " + data[2]);
        } 
        else 
        {
            System.out.println("Invalid Record");
        }
        sc.close();
    }
}