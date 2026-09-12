package main.java.oop_fundamental.assignment_problems;
public class FoodOrder 
{
    private String studentName;
    private String dishName;
    private boolean delivered;
    public FoodOrder(String studentName, String dishName) 
    {
        if (studentName == null || studentName.trim().isEmpty()) 
        {
            throw new IllegalArgumentException("Invalid student name");
        }
        if (dishName == null || dishName.trim().isEmpty()) 
        {
            throw new IllegalArgumentException("Invalid dish name");
        }
        this.studentName = studentName.trim();
        this.dishName = dishName.trim();
        this.delivered = false;
    }
    public void markDelivered() 
    {
        if (!delivered) 
        {
            delivered = true;
            System.out.println("Order marked as delivered.");
        } 
        else 
        {
            System.out.println("Order was already delivered.");
        }
    }
    static void processBatch(String[][] rawOrders) 
    {
        int valid = 0;
        int rejected = 0;
        for (int i = 0; i < rawOrders.length; i++) 
        {
            String studentName = rawOrders[i][0];
            String dishName = rawOrders[i][1];
            try 
            {
                new FoodOrder(studentName, dishName);
                valid++;
            }
            catch (IllegalArgumentException e) 
            {
                rejected++;
            }
        }
        System.out.println("Valid: " + valid + " | Rejected: " + rejected);
    }
    public static void main(String[] args) 
    {
        String[][] orders = {{"Ravi", "Paneer Butter Masala"},{"", "Chole Bhature"},{"Meera", " "},{"Divya", "Veg Biryani"}};
        processBatch(orders);
        FoodOrder order = new FoodOrder("Ravi", "Paneer Butter Masala");
        order.markDelivered();
        order.markDelivered();
    }
}