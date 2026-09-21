package main.java.inherit_polymorphism.class_problems;
public class EventTicket 
{
    protected String attendeeId;
    protected double basePrice;
    protected double balanceDue;
    public EventTicket(String attendeeId, double basePrice) 
    {
        if (attendeeId == null || attendeeId.trim().length() < 4) 
        {
            throw new IllegalArgumentException("Invalid attendee ID");
        }
        this.attendeeId = attendeeId;
        this.basePrice = basePrice;
        this.balanceDue = basePrice;
    }
    public void pay(double amount) 
    {
        balanceDue -= amount;
    }
    public double getBalanceDue() 
    {
        return balanceDue;
    }
    public void printTicket() 
    {
        System.out.println("Standard Event Ticket | Balance Due: " + balanceDue);
    }
    static String registerBatch(String[] attendeeIds, double basePrice) 
    {
        int registered = 0;
        int rejected = 0;
        for (String id : attendeeIds) 
        {
            try 
            {
                new EventTicket(id, basePrice);
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
            new EventTicket("ST1", 500);
            System.out.println("construction succeeded");
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println("construction rejected");
        }
        WorkshopTicket w = new WorkshopTicket("STU2", 1200, "AI/ML");
        w.pay(500);
        System.out.println(w.getBalanceDue());
        String[] attendeeIds = {"STU1", "ST1", "STU2", " ", "STU3"};
        System.out.println(registerBatch(attendeeIds, 500));
    }
}
class WorkshopTicket extends EventTicket 
{
    private String track;
    public WorkshopTicket(String attendeeId, double basePrice, String track) 
    {
        super(attendeeId, basePrice);
        this.track = track;
    }
    public String getTrack()
    {
        return track;
    }
}