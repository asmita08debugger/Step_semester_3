package main.java.inherit_polymorphism.assignment_problems;
import java.util.Arrays;
public class LateWithdrawalAudit 
{
    static class RaceEntry 
    {
        protected double balanceDue;
        private double[] lateFeeHistory = new double[10];
        private int lateFeeCount = 0;
        public RaceEntry(double entryFee) 
        {
            balanceDue = entryFee;
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
    static class RunnerEntry extends RaceEntry 
    {
        public RunnerEntry(double entryFee) 
        {
            super(entryFee);
        }
        @Override
        protected void applyLateFee(double amount) 
        {
            super.applyLateFee(amount * 2);
        }
    }
    public static void main(String[] args) 
    {
        RunnerEntry runner = new RunnerEntry(500);
        runner.pay(500);
        runner.applyLateFee(100);
        System.out.println("Balance: " + runner.getBalanceDue());
        double[] history = runner.getLateFeeHistory();
        System.out.println("History: " + Arrays.toString(history));
        history[0] = 9999;
        System.out.println("Original History: " + Arrays.toString(runner.getLateFeeHistory()));
    }
}