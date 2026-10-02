package main.java.abstract_interf.class_problems;
abstract class PaymentMethod 
{
    private static int transactionCounter = 0;
    protected final String transactionId;
    protected double amount;
    public PaymentMethod(double amount) 
    {
        this.amount = amount;
        transactionCounter++;
        transactionId = "TXN" + transactionCounter;
    }
    public abstract void processPayment();
    public void pay() 
    {
        processPayment();
    }
    public void pay(double extraAmount) 
    {
        amount += extraAmount;
        processPayment();
    }
    public final String getTransactionId() 
    {
        return transactionId;
    }
    public static int getTransactionCount() 
    {
        return transactionCounter;
    }
}
class CardPayment extends PaymentMethod 
{

    public CardPayment(double amount) 
    {
        super(amount);
    }
    @Override
    public void processPayment() 
    {
        System.out.println("Card payment processed: " + amount);
    }
}
class UpiPayment extends PaymentMethod 
{
    public UpiPayment(double amount) 
    {
        super(amount);
    }
    @Override
    public void processPayment() 
    {
        System.out.println("UPI payment processed: " + amount);
    }
}
public class CheckoutPaymentHandler 
{
    public static void main(String[] args) 
    {
        PaymentMethod card = new CardPayment(1000);
        PaymentMethod upi = new UpiPayment(500);
        card.pay();
        upi.pay(200);
        System.out.println("Card Transaction ID: " + card.getTransactionId());
        System.out.println("UPI Transaction ID: " + upi.getTransactionId());
        System.out.println("Total Transactions: " + PaymentMethod.getTransactionCount());
    }
}