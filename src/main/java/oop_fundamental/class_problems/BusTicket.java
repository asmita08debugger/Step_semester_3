package main.java.oop_fundamental.class_problems;
public class BusTicket 
{
    private String passengerName;
    private String destination;
    private boolean checkedIn;
    public BusTicket(String passengerName, String destination) 
    {
        if (passengerName == null || passengerName.trim().isEmpty()) 
        {
            throw new IllegalArgumentException("Invalid passenger name");
        }
        if (destination == null || destination.trim().isEmpty()) 
        {
            throw new IllegalArgumentException("Invalid destination");
        }
        for (int i = 0; i < passengerName.length(); i++) 
        {
            char ch = passengerName.charAt(i);
            if (!Character.isLetter(ch) && ch != ' ') 
            {
                throw new IllegalArgumentException("Invalid passenger name");
            }
        }
        this.passengerName = passengerName.trim();
        this.destination = destination.trim();
        this.checkedIn = false;
    }
    public void markCheckedIn() 
    {
        if (!checkedIn) 
        {
            checkedIn = true;
        }
    }
    static void processBatch(String[][] rawBookings) 
    {
        BusTicket[] acceptedTickets = new BusTicket[rawBookings.length];
        int valid = 0;
        int rejected = 0;
        int duplicates = 0;
        for (int i = 0; i < rawBookings.length; i++) 
        {
            String name = rawBookings[i][0];
            String destination = rawBookings[i][1];
            try 
            {
                BusTicket ticket = new BusTicket(name, destination);
                boolean duplicate = false;
                for (int j = 0; j < valid; j++) 
                {
                    if (acceptedTickets[j].passengerName.equalsIgnoreCase(ticket.passengerName) && acceptedTickets[j].destination.equalsIgnoreCase(ticket.destination)) 
                    {
                        duplicate = true;
                        break;
                    }
                }
                if (duplicate) 
                {
                    duplicates++;
                } 
                else 
                {
                    acceptedTickets[valid] = ticket;
                    valid++;
                }
            } 
            catch (IllegalArgumentException e) 
            {
                rejected++;
            }
        }
        System.out.println("Valid: " + valid);
        System.out.println("Rejected: " + rejected);
        System.out.println("Duplicates skipped: " + duplicates);
    }
    public static void main(String[] args) 
    {
        String[][] bookings = {{"Divya", "Chennai"},{"", "Bangalore"},{"Ravi123", "Pune"},{"Divya", "Chennai"},{" ", " "}};
        processBatch(bookings);
    }
}