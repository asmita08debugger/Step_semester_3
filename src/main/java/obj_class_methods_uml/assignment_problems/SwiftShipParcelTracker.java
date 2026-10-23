package main.java.obj_class_methods_uml.assignment_problems;
import java.util.*;
public class SwiftShipParcelTracker 
{
    interface ShippingType 
    {
        double charge(double weight);
    }
    static class Standard implements ShippingType 
    {
        public double charge(double w) 
        {
            return 40 + 10 * w;
        }
    }
    static class Express implements ShippingType 
    {
        public double charge(double w) 
        {
            return 80 + 15 * w;
        }
    }
    static class Fragile implements ShippingType 
    {
        public double charge(double w) 
        {
            return 40 + 10 * w + 50;
        }
    }
    interface NotificationChannel 
    {
        void notify(String id, String status);
    }
    static class SmsChannel implements NotificationChannel 
    {
        public void notify(String id, String status) 
        {
            System.out.println("[SMS] " + id + " is now " + status + ".");
        }
    }
    static class EmailChannel implements NotificationChannel 
    {
        public void notify(String id, String status) 
        {
            System.out.println("[Email] " + id + " is now " + status + ".");
        }
    }
    static class Customer 
    {
        String name;
        Customer(String name) 
        {
            this.name = name;
        }
    }
    static class Parcel 
    {
        String id, status = "BOOKED";
        double weight;
        ShippingType type;
        List<NotificationChannel> channels = new ArrayList<>();
        Parcel(String id, double weight, ShippingType type) 
        {
            this.id = id;
            this.weight = weight;
            this.type = type;
        }
        void subscribe(NotificationChannel c) 
        {
            channels.add(c);
        }
        void updateStatus(String next) 
        {
            String[] statuses = {"BOOKED", "PICKED_UP", "IN_TRANSIT", "OUT_FOR_DELIVERY", "DELIVERED"};
            int current = Arrays.asList(statuses).indexOf(status);
            int target = Arrays.asList(statuses).indexOf(next);
            if (target == current + 1) 
            {
                status = next;
                for (NotificationChannel c : channels)
                    c.notify(id, status);
            } 
            else 
            {
                System.out.println("Invalid transition: " + status + " → " + next + " is not allowed.");
            }
        }
        void cancel() 
        {
            if (status.equals("BOOKED")) 
            {
                status = "CANCELLED";
                System.out.println("Parcel " + id + " cancelled.");
            } 
            else
            {
                System.out.println("Cancellation failed: " + id + " can be cancelled only while BOOKED.");
            }
        }
    }
    static class ParcelService 
    {
        void book(Parcel p) 
        {
            System.out.println("Parcel " + p.id + " booked (" + (p.type instanceof Express ? "Express" : p.type instanceof Fragile ? "Fragile" : "Standard") + ", " + p.weight + " kg).");
            System.out.printf(Locale.US, "Charge: ₹%.2f.%n", p.type.charge(p.weight));
            for (NotificationChannel c : p.channels)
                c.notify(p.id, p.status);
        }
    }
    public static void main(String[] args) 
    {
        Parcel p = new Parcel("P101", 2, new Express());
        p.subscribe(new SmsChannel());
        p.subscribe(new EmailChannel());
        ParcelService service = new ParcelService();
        service.book(p);
        p.updateStatus("PICKED_UP");
        p.cancel();
        p.updateStatus("IN_TRANSIT");
        p.updateStatus("DELIVERED");
    }
}