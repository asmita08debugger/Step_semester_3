package main.java.string_operations.class_problems;
import java.util.Scanner;
public class BankTransactionReference 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter transaction reference: ");
        String reference = sc.nextLine().trim();
        if (reference.length() != 14) 
        {
            System.out.println("Invalid: wrong length");
        } 
        else 
        {
            String bankCode = reference.substring(0, 3).toUpperCase();
            reference = bankCode + reference.substring(3);
            boolean letters = true;
            boolean digits = true;
            for (int i = 0; i < 3; i++) 
            {
                if (!Character.isLetter(reference.charAt(i)))
                    letters = false;
            }
            for (int i = 3; i < 14; i++) 
            {
                if (!Character.isDigit(reference.charAt(i)))
                    digits = false;
            }

            if (!letters)
                System.out.println("Invalid: bank code must be 3 letters");
            else if (!digits)
                System.out.println("Invalid: body must contain only digits");
            else
            {
                StringBuilder result = new StringBuilder();
                result.append("[");
                result.append(reference.substring(0, 3));
                result.append("] DATE: ");
                result.append(reference.substring(3, 5));
                result.append("/");
                result.append(reference.substring(5, 7));
                result.append("/");
                result.append(reference.substring(7, 9));
                result.append(" | SEQ: ");
                result.append(reference.substring(9));

                System.out.println(result);
            }
        }
        sc.close();
    }
}