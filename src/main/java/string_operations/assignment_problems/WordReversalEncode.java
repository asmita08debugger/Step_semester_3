package main.java.string_operations.assignment_problems;
import java.util.Scanner;
public class WordReversalEncode 
{
    static String reverseEachWord(String sentence) 
    {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) 
        {
            StringBuilder reverse = new StringBuilder(word);
            reverse.reverse();
            result.append(reverse);
            result.append(" ");
        }
        return result.toString().trim();
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter sentence: ");
        String sentence = sc.nextLine();
        System.out.println(reverseEachWord(sentence));
        sc.close();
    }
}