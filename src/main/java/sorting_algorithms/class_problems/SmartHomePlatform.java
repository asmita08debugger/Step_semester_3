package main.java.sorting_algorithms.class_problems;
interface Dimmable 
{
    void dim(int level);
}
interface Schedulable 
{
    void schedule(String time);
}
interface EnergyMonitor 
{
    void energy();
}
class Light implements Dimmable, Schedulable 
{
    String id;
    Light(String id) 
    {
        this.id = id;
    }
    public void dim(int level) 
    {
        System.out.println(id + " dimmed to " + level);
    }
    public void schedule(String time) 
    {
        System.out.println(id + " scheduled " + time);
    }
}
class Fan implements Schedulable 
{
    String id;
    Fan(String id) 
    {
        this.id = id;
    }
    public void schedule(String time) 
    {
        System.out.println(id + " scheduled " + time);
    }
}
class Plug implements EnergyMonitor 
{
    String id;
    int units;
    Plug(String id, int units) 
    {
        this.id = id;
        this.units = units;
    }
    public void energy() 
    {
        System.out.println(id + " energy " + units + " kWh");
    }
}
public class SmartHomePlatform 
{
    public static void main(String[] args) 
    {
        Light l = new Light("L1");
        Fan f = new Fan("F1");
        Plug p = new Plug("P1", 12);
        System.out.println("L1 is ON");
        l.dim(40);
        if (f instanceof Dimmable)
            ((Dimmable) f).dim(30);
        else
            System.out.println("F1 rejected: DIM unsupported");
        f.schedule("22:00");
        p.energy();
        if (l instanceof EnergyMonitor)
            ((EnergyMonitor) l).energy();
        else
            System.out.println("L1 rejected: ENERGY unsupported");
    }
}