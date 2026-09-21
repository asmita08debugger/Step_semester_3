package main.java.inherit_polymorphism.class_problems;
public class PremiumWorkshopTicket extends WorkshopTicket 
{
    private double kitFee;
    public PremiumWorkshopTicket(String attendeeId, double basePrice, String track, double kitFee) 
    {
        super(attendeeId, basePrice, track);
        this.kitFee = kitFee;
    }
    @Override
    public void printTicket() 
    {
        System.out.println("Premium Workshop Ticket | Track: " + getTrack() + " | Kit Fee: " + kitFee + " | Balance Due: " + getBalanceDue());
    }
    static String classifyGeneration(EventTicket ticket) 
    {
        if (ticket instanceof PremiumWorkshopTicket) 
        {
            return "Multilevel descendant (3 generations deep)";
        }
        if (ticket instanceof HackathonTicket) 
        {
            return "Hierarchical sibling (independent branch)";
        }
        return "Base or Workshop Ticket";
    }
    static double getTotalBalanceDue(EventTicket[] tickets) 
    {
        double total = 0;
        for (EventTicket ticket : tickets) 
        {
            total += ticket.getBalanceDue();
        }
        return total;
    }
    public static void main(String[] args) 
    {
        EventTicket standardTicket = new EventTicket("STU1", 500);
        WorkshopTicket workshopTicket = new WorkshopTicket("STU2", 1200, "AI/ML");
        PremiumWorkshopTicket premiumTicket = new PremiumWorkshopTicket("STU3", 1700, "Cloud Native", 300);
        HackathonTicket hackathonTicket =new HackathonTicket("STU4", 800, "Byte Force");
        standardTicket.printTicket();
        workshopTicket.printTicket();
        premiumTicket.printTicket();
        hackathonTicket.printTicket();
        System.out.println(classifyGeneration(premiumTicket));
        System.out.println(classifyGeneration(hackathonTicket));
        EventTicket[] tickets = {standardTicket,workshopTicket,premiumTicket,hackathonTicket};
        System.out.println(getTotalBalanceDue(tickets));
    }
}
class HackathonTicket extends EventTicket 
{
    private String teamName;
    public HackathonTicket(String attendeeId, double basePrice, String teamName) 
    {
        super(attendeeId, basePrice);
        this.teamName = teamName;
    }
    @Override
    public void printTicket() 
    {
        System.out.println("Hackathon Ticket | Team: " + teamName + " | Balance Due: " + getBalanceDue());
    }
}