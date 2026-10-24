package main.java.obj_class_methods_uml.assignment_problems;
import java.util.*;
public class SmartLabControlPanel 
{
        interface Capability 
        {
            String getName();
            boolean apply(Device d, int value);
        }
        static class Device 
        {
            String name;
            Map<String, Capability> capabilities = new LinkedHashMap<>();
            Device(String name) 
            {
                this.name = name;
            }
            void addCapability(Capability c) 
            {
                capabilities.put(c.getName(), c);
                System.out.println(name + ": " + c.getName() + " capability added.");
            }
            void apply(String capability, int value) 
            {
                Capability c = capabilities.get(capability);
                if (c != null) 
                {
                    c.apply(this, value);
                }
            }
        }
        static class PowerCapability implements Capability 
        {
            public String getName() 
            {
                return "Power";
            }
            public boolean apply(Device d, int value) 
            {
                System.out.println(d.name + ": " + (value == 1 ? "ON" : "OFF") + ".");
                return true;
            }
        }
        static class BrightnessCapability implements Capability 
        {
            public String getName() 
            {
                return "Brightness";
            }
            public boolean apply(Device d, int value) 
            {
                if (value < 0 || value > 100) 
                {
                    System.out.println("Rejected: Brightness must be between 0% and 100%.");
                    return false;
                }
                System.out.println(d.name + ": brightness set to " + value + "%.");
                return true;
            }
        }
        static class TemperatureCapability implements Capability 
        {
            public String getName() 
            {
                return "Temperature";
            }
            public boolean apply(Device d, int value) 
            {
                if (value < 16 || value > 30) 
                {
                    System.out.println("Rejected: " + d.name + " temperature must be between 16°C and 30°C.");
                    return false;
                }
                System.out.println(d.name + ": temperature set to " + value + "°C.");
                return true;
            }
        }
        static class Scene 
        {
            String name;
            List<Runnable> steps = new ArrayList<>();
            Scene(String name) 
            {
                this.name = name;
            }
            void addStep(Runnable step) 
            {
                steps.add(step);
            }
            void execute() 
            {
                System.out.println("Scene '" + name + "' started.");
                for (Runnable step : steps) 
                {
                    step.run();
                }
                System.out.println("Scene '" + name + "' completed: 5 actions applied.");
            }
        }
        public static void main(String[] args) 
        {
            Device ac = new Device("Lab AC");
            ac.addCapability(new PowerCapability());
            ac.addCapability(new TemperatureCapability());
            Device lights = new Device("Ceiling Lights");
            lights.addCapability(new PowerCapability());
            lights.addCapability(new BrightnessCapability());
            Device projector = new Device("Projector");
            projector.addCapability(new PowerCapability());
            Scene scene = new Scene("Lecture Mode");
            scene.addStep(() -> ac.apply("Power", 1));
            scene.addStep(() -> lights.apply("Power", 1));
            scene.addStep(() -> projector.apply("Power", 1));
            scene.addStep(() -> lights.apply("Brightness", 40));
            scene.addStep(() -> ac.apply("Temperature", 24));
            scene.execute();
            ac.apply("Temperature", 12);
            projector.addCapability(new BrightnessCapability());
            projector.apply("Brightness", 70);
        }
}