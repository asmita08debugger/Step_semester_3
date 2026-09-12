package main.java.oop_fundamental.assignment_problems;
public final class SurgeFeeCalculator 
{
    private final double minimumSurgePercent;
    public SurgeFeeCalculator(double minimumSurgePercent) 
    {
        this.minimumSurgePercent = minimumSurgePercent;
    }
    public final double calculateSurgeFee(double orderValue, int delayMinutes) 
    {
        if (orderValue < 0 || delayMinutes < 0) 
        {
            throw new IllegalArgumentException("Invalid input");
        }
        if (delayMinutes == 0) 
        {
            return 0.0;
        }
        double fee = 0.0;
        int firstFive = Math.min(delayMinutes, 5);
        fee += firstFive * orderValue * 0.005;
        if (delayMinutes > 5) 
        {
            int nextTen = Math.min(delayMinutes - 5, 10);
            fee += nextTen * orderValue * 0.01;
        }
        if (delayMinutes > 15) 
        {
            int remaining = delayMinutes - 15;
            fee += remaining * orderValue * 0.02;
        }
        double minimumFee = orderValue * minimumSurgePercent / 100;
        return Math.max(fee, minimumFee);
    }
    public static void main(String[] args) 
    {
        SurgeFeeCalculator calculator = new SurgeFeeCalculator(1.0);
        System.out.println("Surge Fee for 0 minutes: Rs " + calculator.calculateSurgeFee(500, 0));
        System.out.println("Surge Fee for 1 minute: Rs " + calculator.calculateSurgeFee(500, 1));
        System.out.println("Surge Fee for 16 minutes: Rs " + calculator.calculateSurgeFee(500, 16));
    }
}