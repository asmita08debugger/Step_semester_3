package main.java.oop_inheritance.class_problems;
public class PatientVitals 
{
    private double[] readings;
    private int count;
    public PatientVitals(double[] initialReadings) 
    {
        readings = new double[500];
        count = 0;
        for (int i = 0; i < initialReadings.length; i++) 
        {
            recordReading(initialReadings[i]);
        }
    }
    public void recordReading(double reading) 
    {
        if (reading <= 0 || reading > 45) 
        {
            return;
        }
        if (count < readings.length) 
        {
            readings[count] = reading;
            count++;
        }
    }
    public double getAverage() 
    {
        if (count == 0) 
        {
            return 0.0;
        }
        double sum = 0;
        for (int i = 0; i < count; i++) 
        {
            sum += readings[i];
        }
        return sum / count;
    }
    public double[] getAllReadings() 
    {
        double[] result = new double[count];
        for (int i = 0; i < count; i++) 
        {
            result[i] = readings[i];
        }
        return result;
    }
    public static void main(String[] args) 
    {
        PatientVitals v = new PatientVitals(new double[]{36.5, -2, 37.1});
        double[] result = v.getAllReadings();
        System.out.print("Readings: [");
        for (int i = 0; i < result.length; i++) 
        {
            System.out.print(result[i]);
            if (i < result.length - 1) 
            {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println("Average: " + v.getAverage());
        double[] copy = v.getAllReadings();
        copy[0] = 999;
        System.out.println("First reading after modification: "+ v.getAllReadings()[0]);
    }
}