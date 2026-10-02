package main.java.abstract_interf.assignment_problems;
interface Insurable 
{
    void insure();
    double getInsurancePremium();
}
abstract class Vehicle 
{
    private String model;
    protected double basePremium;
    public Vehicle(String model, double basePremium) 
    {
        this.model = model;
        this.basePremium = basePremium;
    }
    public String getModel() 
    {
        return model;
    }
    public void setModel(String model) 
    {
        this.model = model;
    }
    public abstract void service();
}
class ElectricVehicle extends Vehicle implements Insurable 
{
    protected double batteryCapacity;
    public ElectricVehicle(String model, double basePremium, double batteryCapacity) 
    {
        super(model, basePremium);
        this.batteryCapacity = batteryCapacity;
    }
    @Override
    public void service() 
    {
        System.out.println("Servicing electric vehicle: " + getModel());
    }
    @Override
    public void insure() 
    {
        System.out.println("Electric vehicle insured");
    }
    @Override
    public double getInsurancePremium() 
    {
        return basePremium;
    }
}
class DeliveryVan extends Vehicle 
{
    protected double loadCapacity;
    public DeliveryVan(String model, double basePremium, double loadCapacity) 
    {
        super(model, basePremium);
        this.loadCapacity = loadCapacity;
    }
    @Override
    public void service() 
    {
        System.out.println("Servicing delivery van: " + getModel());
    }
}
class ElectricDeliveryVan extends ElectricVehicle 
{
    private double loadCapacity;
    public ElectricDeliveryVan(String model, double basePremium, double batteryCapacity, double loadCapacity) 
    {
        super(model, basePremium, batteryCapacity);
        this.loadCapacity = loadCapacity;
    }
    @Override
    public void service() 
    {
        super.service();
        System.out.println("Checking delivery load capacity: " + loadCapacity);
    }
}
public class FleetMaintenanceTracker 
{
    public static void main(String[] args) 
    {
        ElectricDeliveryVan van = new ElectricDeliveryVan( "E-Van", 1000, 80, 500);
        van.service();
        System.out.println("Insurance Premium: " + van.getInsurancePremium());
        if (van instanceof Insurable) 
        {
            System.out.println("Vehicle is insurable");
        }
        van.setModel("E-Van Pro");
        System.out.println("Updated Model: " + van.getModel());
    }
}