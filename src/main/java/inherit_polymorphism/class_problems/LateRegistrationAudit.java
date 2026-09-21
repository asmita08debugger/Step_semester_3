package main.java.inherit_polymorphism.class_problems;
import java.util.Arrays;
public class LateRegistrationAudit 
{
    static class EventTicket 
    {
        protected double balanceDue;
        private double[] lateFeeHistory = new double[10];
        private int lateFeeCount = 0;
        public EventTicket(double basePrice) 
        {
            balanceDue = basePrice;
        }
        public void pay(double amount) 
        {
            balanceDue -= amount;
        }
        public double getBalanceDue() 
        {
            return balanceDue;
        }
        protected void applyLateFee(double amount) 
        {
            balanceDue += amount;
            if (lateFeeCount < 10) 
            {
                lateFeeHistory[lateFeeCount] = amount;
                lateFeeCount++;
            }
        }
        public double[] getLateFeeHistory() 
        {
            double[] history = new double[lateFeeCount];
            for (int i = 0; i < lateFeeCount; i++) 
            {
                history[i] = lateFeeHistory[i];
            }
            return history;
        }
    }
    static class WorkshopTicket extends EventTicket 
    {
        private String track;
        public WorkshopTicket(double basePrice, String track) 
        {
            super(basePrice);
            this.track = track;
        }
        @Override
        protected void applyLateFee(double amount) 
        {
            super.applyLateFee(amount * 2);
        }
    }
    public static void main(String[] args) 
    {
        WorkshopTicket ticket = new WorkshopTicket(1200, "AI/ML");
        ticket.pay(1200);
        ticket.applyLateFee(100);
        System.out.println("Balance: " + ticket.getBalanceDue());
        double[] history = ticket.getLateFeeHistory();
        System.out.println("History: " + Arrays.toString(history));
        history[0] = 9999;
        System.out.println("Original History: " + Arrays.toString(ticket.getLateFeeHistory()));
    }
}