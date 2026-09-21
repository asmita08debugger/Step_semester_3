package main.java.inherit_polymorphism.class_problems;
public class TicketAnnouncer 
{
    static class EventTicket 
    {
        protected double balanceDue;
        public EventTicket(double balanceDue) 
        {
            this.balanceDue = balanceDue;
        }
        public double getBalanceDue() 
        {
            return balanceDue;
        }
        public void printTicket() 
        {
            System.out.println("Standard Event Ticket | Balance Due: " + balanceDue);
        }
    }
    static class WorkshopTicket extends EventTicket 
    {
        private String track;
        public WorkshopTicket(double balanceDue, String track) 
        {
            super(balanceDue);
            this.track = track;
        }
        public String getTrack() 
        {
            return track;
        }
        @Override
        public void printTicket() 
        {
            System.out.println("Workshop Ticket | Track: " + track + " | Balance Due: " + balanceDue);
        }
    }
    static String batchPrint(EventTicket[] tickets) 
    {
        StringBuilder report = new StringBuilder();
        for (EventTicket ticket : tickets) 
        {
            ticket.printTicket();
            if (ticket instanceof WorkshopTicket) 
            {
                WorkshopTicket workshop =(WorkshopTicket) ticket;
                report.append("Workshop")
                      .append(" | Track: ")
                      .append(workshop.getTrack())
                      .append(" | Balance: ")
                      .append(workshop.getBalanceDue())
                      .append(" [Track via downcast: ")
                      .append(workshop.getTrack())
                      .append("] | ");
            } 
            else 
            {
                report.append("Standard")
                      .append(" | Balance: ")
                      .append(ticket.getBalanceDue())
                      .append(" | ");
            }
        }
        return report.toString();
    }
    public static void main(String[] args) 
    {
        EventTicket standard = new EventTicket(500);
        WorkshopTicket workshop = new WorkshopTicket(1200, "AI/ML");
        EventTicket[] tickets = {standard, workshop};
        String report = batchPrint(tickets);
        System.out.println(report);
    }
}