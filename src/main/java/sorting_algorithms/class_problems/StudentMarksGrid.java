package main.java.sorting_algorithms.class_problems;
public class StudentMarksGrid 
{
    public static void main(String[] args) 
    {
        String[] students = {"Anu", "Ravi", "Meena"};
        String[] subjects = {"Math", "Sci", "Eng"};
        int[][] marks = {{80, 90, 70},{60, 85, -1},{95, 75, 88}};
        int[] maxMarks = {-1, -1, -1};
        String[] toppers = new String[3];
        for (int i = 0; i < students.length; i++) 
        {
            int total = 0;
            for (int j = 0; j < subjects.length; j++) 
            {
                if (marks[i][j] != -1) 
                {
                    total += marks[i][j];
                    if (marks[i][j] > maxMarks[j]) 
                    {
                        maxMarks[j] = marks[i][j];
                        toppers[j] = students[i];
                    }
                }
            }
            System.out.println("Total " + students[i] + " " + total);
        }
        for (int j = 0; j < subjects.length; j++) 
        {
            System.out.println("Topper " + subjects[j] + " " + toppers[j] + " " + maxMarks[j]);
        }
    }
}