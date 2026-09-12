package main.java.string_concepts.class_problems;
import java.util.Scanner;
public class TeamBmiCalculator 
{
    static String getBmiStatus(double bmi) 
    {
        if (bmi < 18.5)
            return "Underweight";
        else if (bmi < 25) 
            return "Normal";
        else if (bmi < 30)
            return "Overweight";
        else
            return "Obese";
    }
    static void printWellnessReport(double[] heights, double[] weights) 
    {
        System.out.println("Person | Height | Weight | BMI | Status");
        for (int i = 0; i < heights.length; i++) 
        {
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.printf("%d | %.2f m | %.2f kg | %.2f | %s%n", i + 1, heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of people: ");
        int n = sc.nextInt();
        double[] heights = new double[n];
        double[] weights = new double[n];
        for (int i = 0; i < n; i++) 
        {
            System.out.print("Enter height for person " + (i + 1) + ": ");
            heights[i] = sc.nextDouble();
            System.out.print("Enter weight for person " + (i + 1) + ": ");
            weights[i] = sc.nextDouble();
        }
        printWellnessReport(heights, weights);
        sc.close();
    }
}