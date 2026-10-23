package main.java.obj_class_methods_uml.class_problems;
import java.time.LocalDate;
import java.util.*;
public class HotelBookingSystem 
{
    static class Room 
    {
        String name;
        double rate;
        Room(String name, double rate) 
        {
            this.name = name;
            this.rate = rate;
        }
    }
    static class Reservation 
    {
        Room room;
        LocalDate start, end, deadline;
        boolean active = true;
        Reservation(Room room, LocalDate start, LocalDate end, LocalDate deadline) 
        {
            this.room = room;
            this.start = start;
            this.end = end;
            this.deadline = deadline;
        }
    }
    static class Hotel 
    {
        List<Reservation> reservations = new ArrayList<>();
        void book(Room room, LocalDate start, LocalDate end, LocalDate deadline) 
        {
            for (Reservation r : reservations) 
            {
                if (r.active && r.room == room && start.isBefore(r.end) && end.isAfter(r.start)) 
                {
                    System.out.println("Booking failed: " + room.name + " is not available for " + start + " to " + end);
                    return;
                }
            }
            Reservation r = new Reservation(room, start, end, deadline);
            reservations.add(r);
            long days = java.time.temporal.ChronoUnit.DAYS.between(start, end);
            System.out.println(room.name + " booked from " + start + " to " + end + ".");
            System.out.printf("Total price: $%.2f%n", days * room.rate);
        }
        void cancel(Reservation r, LocalDate today) 
        {
            if (r.active && !today.isAfter(r.deadline)) 
            {
                r.active = false;
                System.out.println("Reservation for " + r.room.name + " cancelled successfully.");
            } 
            else 
            {
                System.out.println("Cancellation not allowed.");
            }
        }
    }
    public static void main(String[] args) 
    {
        Hotel hotel = new Hotel();
        Room deluxe = new Room("Deluxe Room 101", 200);
        Room standard = new Room("Standard Room 205", 150);
        LocalDate s1 = LocalDate.of(2024, 12, 1);
        LocalDate e1 = LocalDate.of(2024, 12, 5);
        LocalDate s2 = LocalDate.of(2024, 12, 3);
        LocalDate e2 = LocalDate.of(2024, 12, 7);
        hotel.book(deluxe, s1, e1, LocalDate.of(2024, 11, 28));
        hotel.book(standard, s2, e2, LocalDate.of(2024, 11, 30));
        hotel.book(deluxe, s2, e2, LocalDate.of(2024, 11, 30));
        Reservation first = hotel.reservations.get(0);
        hotel.cancel(first, LocalDate.of(2024, 11, 25));
    }
}