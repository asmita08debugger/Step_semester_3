package main.java.oop_fundamental.class_problems;
class BusTicketAccount 
{
    protected String bookingId;
    protected double ticketFare;
    static String depotName;
    static 
    {
        depotName = "City Bus Depot";
    }
    public BusTicketAccount(String bookingId, double ticketFare) 
    {
        if (ticketFare < 0) 
        {
            throw new IllegalArgumentException("Invalid ticket fare");
        }
        this.bookingId = bookingId;
        this.ticketFare = ticketFare;
    }
    public BusTicketAccount(String bookingId) 
    {
        this(bookingId, 0.0);
    }
    public final double calculatePenalty(int minutesLate) 
    {
        if (minutesLate < 0) 
        {
            throw new IllegalArgumentException("Invalid minutes late");
        }
        if (minutesLate == 0) 
        {
            return 0.0;
        }
        double penalty = 0.0;
        int firstFive = Math.min(minutesLate, 5);
        penalty += firstFive * ticketFare * 0.005;
        if (minutesLate > 5) 
        {
            int nextTen = Math.min(minutesLate - 5, 10);
            penalty += nextTen * ticketFare * 0.01;
        }
        if (minutesLate > 15) 
        {
            int remaining = minutesLate - 15;
            penalty += remaining * ticketFare * 0.02;
        }
        return penalty;
    }
    public void processAccount(double amount, int minutesLate) 
    {
        double penalty = calculatePenalty(minutesLate);
        System.out.println("Booking: " + bookingId + " | Fare: " + amount + " | Penalty: Rs " + penalty);
    }
    static void processBatch(BusTicketAccount[] accounts, double[] amounts, int[] minutesLateArray) 
    {
        int processed = 0;
        int nullSkipped = 0;
        int sleeperCount = 0;
        int regularCount = 0;
        double grandTotal = 0;
        int length = Math.min(accounts.length, Math.min(amounts.length, minutesLateArray.length));
        for (int i = 0; i < length; i++) 
        {
            if (accounts[i] == null) 
            {
                nullSkipped++;
                continue;
            }
            double penalty = accounts[i].calculatePenalty(minutesLateArray[i]);
            grandTotal += penalty;
            processed++;
            if (accounts[i] instanceof SleeperAccount) 
            {
                sleeperCount++;
            } 
            else 
            {
                regularCount++;
            }
            accounts[i].processAccount(amounts[i], minutesLateArray[i]);
        }
        System.out.println("\nSummary");
        System.out.println(processed + " processed");
        System.out.println(nullSkipped + " null skipped");
        System.out.println(sleeperCount + " sleeper");
        System.out.println(regularCount + " regular");
        System.out.println("Grand total penalties = Rs " + grandTotal);
    }
}
class SleeperAccount extends BusTicketAccount 
{
    public SleeperAccount(String bookingId, double ticketFare) 
    {
        super(bookingId, ticketFare);
    }
}
public class BusTicketAccountMain 
{
    public static void main(String[] args) 
    {
        BusTicketAccount[] accounts = 
        {
            new SleeperAccount("BK001", 2000),
            null,
            new BusTicketAccount("BK002", 1200)
        };
        double[] amounts = {1200, 900, 700};
        int[] minutesLate = {10, 5, 0};
        BusTicketAccount.processBatch(accounts, amounts, minutesLate);
    }
}