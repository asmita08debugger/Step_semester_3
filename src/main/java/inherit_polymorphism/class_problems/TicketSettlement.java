package main.java.inherit_polymorphism.class_problems;
public class TicketSettlement 
{
    static class EventTicket 
    {
        private static int ticketsIssued = 0;
        private final String ticketId;
        protected double balanceDue;
        public EventTicket(double basePrice) 
        {
            ticketsIssued++;
            ticketId = "TCK-" + (1000 + ticketsIssued);
            balanceDue = basePrice;
        }
        public void pay(double amount) 
        {
            balanceDue -= amount;
        }
        public void pay(double amount, String mode) 
        {
            pay(amount);
        }
        public double getBalanceDue() 
        {
            return balanceDue;
        }
        public String getTicketId() 
        {
            return ticketId;
        }
        public static boolean isValidPromoCode(String code) 
        {
            if (code == null || code.length() != 5) 
            {
                return false;
            }
            if (code.charAt(0) != 'F') 
            {
                return false;
            }
            if (!Character.isDigit(code.charAt(1)) || !Character.isDigit(code.charAt(2)) || !Character.isDigit(code.charAt(3))) 
            {
                return false;
            }
            return Character.isUpperCase(code.charAt(4));
        }
        public static int getTicketsIssued() 
        {
            return ticketsIssued;
        }
    }
    static class GroupTicket extends EventTicket 
    {
        private int groupSize;
        public GroupTicket(double basePrice, int groupSize) 
        {
            super(basePrice);
            this.groupSize = groupSize;
        }
    }
    static String processNightlySettlement(EventTicket[] tickets) 
    {
        int processed = 0;
        int nullSkipped = 0;
        int groupCount = 0;
        int individualCount = 0;
        for (EventTicket ticket : tickets) 
        {
            if (ticket == null) 
            {
                nullSkipped++;
                continue;
            }
            processed++;
            if (ticket instanceof GroupTicket) 
            {
                groupCount++;
            } 
            else 
            {
                individualCount++;
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | " + groupCount + " group | " + individualCount + " individual";
    }
    public static void main(String[] args) 
    {
        EventTicket t1 = new EventTicket(500);
        System.out.println("Ticket ID: " + t1.getTicketId());
        System.out.println("Tickets issued: " + EventTicket.getTicketsIssued());
        System.out.println(EventTicket.isValidPromoCode("F123A"));
        System.out.println(EventTicket.isValidPromoCode("F12A"));
        System.out.println(EventTicket.isValidPromoCode("X123A"));
        t1.pay(200);
        t1.pay(200, "UPI");
        System.out.println("Balance: " + t1.getBalanceDue());
        EventTicket[] tickets = {new GroupTicket(2000, 5), null, new EventTicket(500)};
        System.out.println(processNightlySettlement(tickets)
        );
    }
}