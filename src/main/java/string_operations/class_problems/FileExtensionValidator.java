package main.java.string_operations.class_problems;
import java.util.Scanner;
public class FileExtensionValidator 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();
        int dot = fileName.lastIndexOf('.');
        if (dot != -1) 
        {
            String extension = fileName.substring(dot + 1);
            if (extension.equalsIgnoreCase("pdf") || extension.equalsIgnoreCase("txt") || extension.equalsIgnoreCase("jpg"))
                System.out.println("Valid Extension");
            else
                System.out.println("Invalid Extension");
        } 
        else 
        {
            System.out.println("Invalid Extension");
        }
        sc.close();
    }
}