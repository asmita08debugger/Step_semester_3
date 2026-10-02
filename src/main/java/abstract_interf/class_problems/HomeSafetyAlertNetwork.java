package main.java.abstract_interf.class_problems;
interface Alertable 
{
    void sendAlert();
    default void alertStatus() 
    {
        System.out.println("Alert system active");
    }
}
class SmartDevice 
{
    protected String deviceName;
    public SmartDevice(String deviceName) 
    {
        this.deviceName = deviceName;
    }
    public void showDevice() 
    {
        System.out.println("Device: " + deviceName);
    }
}
class SmartSensor extends SmartDevice 
{
    protected int sensitivity;
    public SmartSensor(String deviceName, int sensitivity) 
    {
        super(deviceName);
        this.sensitivity = sensitivity;
    }
    @Override
    public void showDevice() 
    {
        super.showDevice();
        System.out.println("Sensitivity: " + sensitivity);
    }
}
class SmokeSensor extends SmartSensor implements Alertable 
{
    public SmokeSensor(String deviceName, int sensitivity) 
    {
        super(deviceName, sensitivity);
    }
    @Override
    public void sendAlert() 
    {
        System.out.println("Smoke alert sent from " + deviceName);
    }
}
public class HomeSafetyAlertNetwork 
{
    public static void main(String[] args) 
    {
        SmokeSensor sensor = new SmokeSensor("Kitchen Sensor", 80);
        sensor.showDevice();
        sensor.sendAlert();
        sensor.alertStatus();
        Alertable alert = sensor;
        alert.sendAlert();
        if (alert instanceof SmokeSensor) 
        {
            System.out.println("Alert is from a SmokeSensor");
        }
    }
}