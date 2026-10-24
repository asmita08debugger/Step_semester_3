package main.java.obj_class_methods_uml.assignment_problems;
import java.util.*;
public class CampusCanteenSmartCard 
{
    interface PricingPlan 
    {
        double getPrice(double price);
    }
    static class DayScholarPlan implements PricingPlan 
    {
        public double getPrice(double price) { return price; }
    }
    static class HostellerPlan implements PricingPlan 
    {
        public double getPrice(double price) { return price * 0.90; }
    }
    static class StaffPlan implements PricingPlan 
    {
        public double getPrice(double price) { return price * 0.80; }
    }
    static class Transaction 
    {
        String item;
        double amount;
        boolean refunded = false;
        Transaction(String item, double amount) 
        {
            this.item = item;
            this.amount = amount;
        }
    }
    static class SmartCard 
    {
        private String id;
        private double balance = 0;
        private boolean blocked = false;
        private PricingPlan plan;
        private List<Transaction> transactions = new ArrayList<>();
        SmartCard(String id, PricingPlan plan) 
        {
            this.id = id;
            this.plan = plan;
        }
        void topUp(double amount) 
        {
            if (blocked) 
            {
                System.out.println("Top-up rejected: Card is blocked.");
                return;
            }
            if (amount < 100 || balance + amount > 5000) 
            {
                System.out.println("Top-up rejected: Invalid amount or balance limit exceeded.");
                return;
            }
            balance += amount;
            transactions.add(new Transaction("Top-up", amount));
            System.out.printf("%s topped up with ₹%.2f. Balance: ₹%.2f.%n", id, amount, balance);
        }
        void purchase(String item, double price) 
        {
            if (blocked) 
            {
                System.out.println("Purchase failed: Card is blocked.");
                return;
            }
            double charged = plan.getPrice(price);
            if (balance < charged) 
            {
                System.out.printf("Purchase failed: Insufficient balance (required ₹%.2f, available ₹%.2f).%n", charged, balance);
                return;
            }
            balance -= charged;
            transactions.add(new Transaction(item, -charged));
            System.out.printf("%s purchased for ₹%.2f. Balance: ₹%.2f.%n", item, charged, balance);
        }
        void refund(String item) 
        {
            for (Transaction t : transactions) 
            {
                if (t.item.equals(item) && t.amount < 0) 
                {
                    if (t.refunded) 
                    {
                        System.out.println("Refund rejected: " + item + " has already been refunded.");
                        return;
                    }
                    t.refunded = true;
                    double amount = -t.amount;
                    balance += amount;
                    transactions.add(new Transaction("Refund: " + item, amount));
                    System.out.printf("Refund of ₹%.2f for %s processed. Balance: ₹%.2f.%n", amount, item, balance);
                    return;
                }
            }
            System.out.println("Refund rejected: Purchase not found.");
        }
        void block() 
        {
            blocked = true;
            System.out.println("Card blocked.");
        }
        void unblock() 
        {
            blocked = false;
            System.out.println("Card unblocked.");
        }
        void miniStatement() 
        {
            System.out.print("Mini-statement for " + id + ": ");
            for (int i = 0; i < transactions.size(); i++) 
            {
                double amount = transactions.get(i).amount;
                System.out.printf("%s%.2f", amount >= 0 ? "+" : "", amount);
                if (i < transactions.size() - 1) System.out.print(", ");
            }
            System.out.printf(" = ₹%.2f.%n", balance);
        }
    }
    public static void main(String[] args) 
    {
        SmartCard card = new SmartCard("C-2045", new HostellerPlan());
        card.topUp(500);
        card.purchase("Veg Thali", 120);
        card.purchase("Cold Coffee", 60);
        card.purchase("Other Items", 400);
        card.refund("Veg Thali");
        card.refund("Veg Thali");
        card.miniStatement();
    }
}