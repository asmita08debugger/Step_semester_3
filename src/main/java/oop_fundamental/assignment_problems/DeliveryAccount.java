package main.java.oop_fundamental.assignment_problems;
class PremiumAccount extends DeliveryAccount 
{
    public PremiumAccount(String studentId, double orderValue) 
    {
        super(studentId, orderValue);
    }
}
public class DeliveryAccount 
{
    protected String studentId;
    protected double orderValue;
    static String appName;
    static 
    {
        appName = "Campus Delivery";
    }
    public DeliveryAccount(String studentId, double orderValue) 
    {
        this.studentId = studentId;
        this.orderValue = orderValue;
    }
    public DeliveryAccount(String studentId) 
    {
        this(studentId, 0.0);
    }
    public final double calculateSurgeFee(int delayMinutes) 
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
        return fee;
    }
    static void processAccount(DeliveryAccount account, double amount, int delayMinutes) 
    {
        double fee = account.calculateSurgeFee(delayMinutes);
        if (account instanceof PremiumAccount) 
        {
            fee = fee * 0.5;
            System.out.println(account.studentId + " | Premium | Surge Fee: Rs " + fee);
        }
        else 
        {
            System.out.println(account.studentId + " | Regular | Surge Fee: Rs " + fee);
        }
    }
    static void processBatch(DeliveryAccount[] accounts, double[] amounts, int[] delayMinutesArray) 
    {
        int processed = 0;
        int nullSkipped = 0;
        int premiumCount = 0;
        int regularCount = 0;
        double grandTotal = 0.0;
        int length = Math.min(accounts.length, Math.min(amounts.length, delayMinutesArray.length));
        for (int i = 0; i < length; i++) 
        {
            if (accounts[i] == null) 
            {
                nullSkipped++;
                continue;
            }
            double fee = accounts[i].calculateSurgeFee(delayMinutesArray[i]);
            if (accounts[i] instanceof PremiumAccount) 
            {
                fee = fee * 0.5;
                premiumCount++;
            } 
            else 
            {
                regularCount++;
            }
            grandTotal += fee;

            processAccount(accounts[i],amounts[i], delayMinutesArray[i]);
            processed++;
        }
        System.out.println("\nSummary");
        System.out.println(processed + " processed");
        System.out.println(nullSkipped + " null skipped");
        System.out.println(premiumCount + " premium");
        System.out.println(regularCount + " regular");
        System.out.println("Grand total surge fees = Rs " + grandTotal);
    }
    public static void main(String[] args) 
    {
        DeliveryAccount[] accounts = 
        {
            new PremiumAccount("STU001", 500),
            null,
            new DeliveryAccount("STU002", 300)
        };
        double[] amounts = {500, 400, 300};
        int[] delayMinutes = {10, 5, 0};
        processBatch(accounts, amounts, delayMinutes);
    }
}