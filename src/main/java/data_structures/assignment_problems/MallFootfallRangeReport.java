package main.java.data_structures.assignment_problems;
import java.util.Arrays;
public class MallFootfallRangeReport 
{
    static int[] footfallReport(int[] visitors, int[][] queries) 
    {
        int[] prefix = new int[visitors.length];
        prefix[0] = visitors[0];
        for (int i = 1; i < visitors.length; i++)
            prefix[i] = prefix[i - 1] + visitors[i];
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) 
        {
            int start = queries[i][0];
            int end = queries[i][1];
            if (start == 0)
                result[i] = prefix[end];
            else
                result[i] = prefix[end] - prefix[start - 1];
        }
        return result;
    }
    public static void main(String[] args) 
    {
        int[] visitors = {12, 7, 3, 9, 15, 4, 8};
        int[][] queries = {{0, 2}, {2, 5}, {4, 6}, {3, 3}};
        System.out.println(Arrays.toString(footfallReport(visitors, queries)));
    }
}