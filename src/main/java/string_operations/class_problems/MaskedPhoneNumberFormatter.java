package main.java.string_operations.class_problems;
import java.util.Scanner;
public class MaskedPhoneNumberFormatter 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 10-digit phone number: ");
        String phone = sc.nextLine();
        if (phone.length() == 10) 
        {
            StringBuilder masked = new StringBuilder();
            for (int i = 0; i < 6; i++) 
            {
                masked.append('*');
            }
            masked.append(phone.substring(6));
            System.out.println("Masked Number: " + masked);
        } 
        else 
        {
            System.out.println("Invalid phone number");
        }
        sc.close();
    }
}