package main.java.obj_class_methods_uml.class_problems;
import java.util.*;
public class FoodOrderSystem 
{
    interface PaymentMethod 
    {
        boolean pay();
        String getName();
    }
    static class CreditCard implements PaymentMethod 
    {
        public boolean pay() 
        {
            return true;
        }
        public String getName() 
        {
            return "Credit Card";
        }
    }
    static class DigitalWallet implements PaymentMethod 
    {
        public boolean pay() 
        {
            return false;
        }
        public String getName() 
        {
            return "Digital Wallet";
        }
    }
    static class LineItem 
    {
        String name;
        int quantity;
        LineItem(String name, int quantity) 
        {
            this.name = name;
            this.quantity = quantity;
        }
    }
    static class Order 
    {
        int id;
        List<LineItem> items = new ArrayList<>();
        Order(int id) 
        {
            this.id = id;
            System.out.println("Order created.");
        }
        void addItem(String name, int quantity) 
        {
            items.add(new LineItem(name, quantity));
            System.out.println("Added " + name + " (Qty " + quantity + ")");
        }
        void place(PaymentMethod payment) 
        {
            if (items.isEmpty()) 
            {
                System.out.println("Cannot place order: Order must contain at least one item.");
                return;
            }
            System.out.println("Order placed successfully.");
            if (payment.pay()) 
            {
                System.out.println("Payment via " + payment.getName() + " successful.");
                System.out.println("Order status: Paid.");
                System.out.println("Notification: Order #" + id + " placed and paid.");
            } 
            else 
            {
                System.out.println("Payment via " + payment.getName() + " failed.");
                System.out.println("Order status: Pending Payment.");
                System.out.println("Notification: Order #" + id + " placed, awaiting payment.");
            }
        }
    }
    public static void main(String[] args) 
    {
        Order o1 = new Order(123);
        o1.addItem("Pizza", 2);
        o1.addItem("Soda", 1);
        Order empty = new Order(122);
        empty.place(new CreditCard());
        o1.place(new CreditCard());
        Order o2 = new Order(124);
        o2.addItem("Burger", 1);
        o2.place(new DigitalWallet());
    }
}