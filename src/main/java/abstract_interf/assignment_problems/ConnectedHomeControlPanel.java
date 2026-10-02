package main.java.abstract_interf.assignment_problems;
interface Switchable 
{
    void turnOn();
    void turnOff();
}
interface Schedulable 
{
    void schedule(String time);
}
abstract class HomeDevice 
{
    protected String deviceName;
    public HomeDevice(String deviceName) 
    {
        this.deviceName = deviceName;
    }
    public abstract void displayStatus();
}
class SmartLight extends HomeDevice implements Switchable, Schedulable 
{
    public SmartLight(String deviceName) 
    {
        super(deviceName);
    }
    @Override
    public void displayStatus() 
    {
        System.out.println("Smart Light: " + deviceName);
    }
    @Override
    public void turnOn() 
    {
        System.out.println(deviceName + " turned on");
    }
    @Override
    public void turnOff() 
    {
        System.out.println(deviceName + " turned off");
    }
    @Override
    public void schedule(String time) 
    {
        System.out.println(deviceName + " scheduled at " + time);
    }
}
class SmartThermostat extends HomeDevice implements Schedulable 
{
    public SmartThermostat(String deviceName) 
    {
        super(deviceName);
    }
    @Override
    public void displayStatus() 
    {
        System.out.println("Smart Thermostat: " + deviceName);
    }
    @Override
    public void schedule(String time) 
    {
        System.out.println(deviceName + " scheduled at " + time);
    }
}
public class ConnectedHomeControlPanel 
{
    public static void main(String[] args) 
    {
        HomeDevice light = new SmartLight("Living Room Light");
        HomeDevice thermostat = new SmartThermostat("Home Thermostat");
        light.displayStatus();
        thermostat.displayStatus();
        if (light instanceof Switchable) 
        {
            Switchable switchable = (Switchable) light;
            switchable.turnOn();
            switchable.turnOff();
        }
        if (light instanceof Schedulable) 
        {
            Schedulable schedulable = (Schedulable) light;
            schedulable.schedule("8:00 PM");
        }
        if (thermostat instanceof Schedulable) 
        {
            Schedulable schedulable = (Schedulable) thermostat;
            schedulable.schedule("10:00 PM");
        }
    }
}