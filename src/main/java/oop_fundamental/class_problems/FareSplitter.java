package main.java.oop_fundamental.class_problems;
public class FareSplitter 
{
    private String tripId;
    private double totalFare;
    private int passengerCount;
    public FareSplitter(String tripId, double totalFare, int passengerCount) 
    {
        if (totalFare < 0) 
        {
            throw new IllegalArgumentException("Fare cannot be negative");
        }
        if (passengerCount <= 0) 
        {
            throw new IllegalArgumentException("Passenger count must be positive");
        }
        this.tripId = tripId;
        this.totalFare = totalFare;
        this.passengerCount = passengerCount;
    }
    public FareSplitter(String tripId, double totalFare) 
    {
        this(tripId, totalFare, 1);
    }
    public FareSplitter(String tripId) 
    {
        this(tripId, 0.0, 2);
    }
    public double[] fareBreakdown() 
    {
        double[] shares = new double[passengerCount];
        double share = Math.floor((totalFare / passengerCount) * 100) / 100;
        for (int i = 0; i < passengerCount; i++) 
        {
            shares[i] = share;
        }
        shares[passengerCount - 1] = Math.round((totalFare - share * (passengerCount - 1)) * 100) / 100.0;
        return shares;
    }
    public boolean isConfirmationOverdue(int confirmed, int expected) 
    {
        return confirmed < expected;
    }
    public static void main(String[] args) 
    {
        FareSplitter fare = new FareSplitter("TRIP001", 100000, 3);
        double[] breakdown = fare.fareBreakdown();
        System.out.print("Fare Breakdown: [");
        for (int i = 0; i < breakdown.length; i++) 
        {
            System.out.print(breakdown[i]);
            if (i < breakdown.length - 1) 
            {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        FareSplitter provisional = new FareSplitter("TRIP003");
        double[] provisionalBreakdown = provisional.fareBreakdown();
        System.out.print("Provisional Breakdown: [");
        for (int i = 0; i < provisionalBreakdown.length; i++) 
        {
            System.out.print(provisionalBreakdown[i]);
            if (i < provisionalBreakdown.length - 1) 
            {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println("Overdue: " + fare.isConfirmationOverdue(2, 3));
    }
}