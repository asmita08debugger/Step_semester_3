package main.java.obj_class_methods_uml.class_problems;
public class VehicleRentalSystem 
{
    static abstract class Vehicle 
    {
        String name;
        double rate;
        boolean available = true;
        Vehicle(String name, double rate) 
        {
            this.name = name;
            this.rate = rate;
        }
        abstract double calculateCharge(int days);
    }
    static class LuxuryCar extends Vehicle 
    {
        LuxuryCar(String name) 
        {
            super(name, 100);
        }
        double calculateCharge(int days) 
        {
            return rate * days;
        }
    }
    static class StandardCar extends Vehicle 
    {
        StandardCar(String name) 
        {
            super(name, 50);
        }
        double calculateCharge(int days) 
        {
            return rate * days;
        }
    }
    static class RentalService 
    {
        void rent(Vehicle v, int days) 
        {
            if (!v.available) 
            {
                System.out.println(v.name + " is not available.");
                return;
            }
            v.available = false;
            System.out.println(v.name + " rented for " + days + " days.");
            System.out.printf("Total charge: $%.2f%n", v.calculateCharge(days));
        }
        void returnVehicle(Vehicle v) 
        {
            v.available = true;
            System.out.println(v.name + " returned. Now available.");
        }
    }
    public static void main(String[] args) 
    {
        Vehicle v1 = new LuxuryCar("Luxury Car A");
        Vehicle v2 = new StandardCar("Standard Car B");
        RentalService service = new RentalService();
        service.rent(v1, 3);
        service.rent(v2, 5);
        service.returnVehicle(v1);
    }
}