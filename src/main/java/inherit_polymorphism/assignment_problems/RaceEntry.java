package main.java.inherit_polymorphism.assignment_problems;
public class RaceEntry 
{
    protected String bibNumber;
    protected double entryFee;
    protected double balanceDue;
    public RaceEntry(String bibNumber, double entryFee) 
    {
        if (bibNumber == null || bibNumber.trim().length() < 4) 
        {
            throw new IllegalArgumentException("Invalid bib number");
        }
        this.bibNumber = bibNumber;
        this.entryFee = entryFee;
        this.balanceDue = entryFee;
    }
    public void pay(double amount) 
    {
        balanceDue -= amount;
    }
    public double getBalanceDue() 
    {
        return balanceDue;
    }
    static String registerBatch(String[] bibNumbers, double entryFee) 
    {
        int registered = 0;
        int rejected = 0;
        for (String bib : bibNumbers) 
        {
            try 
            {
                new RaceEntry(bib, entryFee);
                registered++;
            } 
            catch (IllegalArgumentException e) 
            {
                rejected++;
            }
        }
        return "Registered: " + registered + " | Rejected: " + rejected;
    }
    public static void main(String[] args) 
    {
        try 
        {
            new RaceEntry("B1", 50);
            System.out.println("construction succeeded");
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println("construction rejected");
        }
        RunnerEntry runner = new RunnerEntry("BIB2001", 80, "Open 10K");
        runner.pay(30);
        System.out.println(runner.getBalanceDue());
        String[] bibNumbers = {"BIB1", "B1", "BIB2"};
        System.out.println(registerBatch(bibNumbers, 80));
    }
}
class RunnerEntry extends RaceEntry 
{
    private String category;
    public RunnerEntry(String bibNumber, double entryFee, String category) 
    {
        super(bibNumber, entryFee);
        this.category = category;
    }
}