package main.java.string_concepts.class_problems;
import java.util.Scanner;
public class PalindromeChecker 
{
    static boolean isPalindromeIterative(String text) 
    {
        int start = 0;
        int end = text.length() - 1;
        while (start < end) 
        {
            if (text.charAt(start) != text.charAt(end)) 
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    static boolean isPalindromeRecursive(String text) 
    {
        if (text.length() <= 1) 
        {
            return true;
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) 
        {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }
    static boolean isPalindromeArrayReversal(String text) 
    {
        char[] characters = text.toCharArray();
        int start = 0;
        int end = characters.length - 1;
        while (start < end) 
        {
            char temp = characters[start];
            characters[start] = characters[end];
            characters[end] = temp;
            start++;
            end--;
        }
        String reversed = new String(characters);
        return text.equals(reversed);
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        String result1 = isPalindromeIterative(text)? "Palindrome" : "Not Palindrome";
        String result2 = isPalindromeRecursive(text)? "Palindrome" : "Not Palindrome";
        String result3 = isPalindromeArrayReversal(text)? "Palindrome" : "Not Palindrome";
        System.out.println("Iterative: " + result1);
        System.out.println("Recursive: " + result2);
        System.out.println("Array Reversal: " + result3);
        sc.close();
    }
}