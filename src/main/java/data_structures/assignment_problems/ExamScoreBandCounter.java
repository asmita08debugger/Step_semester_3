package main.java.data_structures.assignment_problems;
public class ExamScoreBandCounter 
{
    static int firstPosition(int[] scores, int target) 
    {
        int left = 0, right = scores.length;
        while (left < right) 
        {
            int mid = (left + right) / 2;
            if (scores[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
    static int countInBand(int[] scores, int low, int high) 
    {
        return firstPosition(scores, high + 1) - firstPosition(scores, low);
    }
    public static void main(String[] args) 
    {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        System.out.println(countInBand(scores, 42, 58));
        System.out.println(countInBand(scores, 90, 100));
    }
}