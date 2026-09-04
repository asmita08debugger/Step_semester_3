package main.java.oop.class_problems;
class FeeAccount 
{
    private String regNo;
    private double totalFee;
    private double amountPaid;
    FeeAccount(String regNo, double totalFee) 
    {
        this.regNo = regNo;
        this.totalFee = totalFee;
        amountPaid = 0;
    }
    void pay(double amount) 
    {
        if (amount > 0) 
        {
            amountPaid += amount;
        } 
        else 
        {
            System.out.println("Invalid payment");
        }
    }
    double getDue() 
    {
        return totalFee - amountPaid;
    }
}
class HostelFeeAccount extends FeeAccount 
{
    HostelFeeAccount(String regNo, double totalFee) 
    {
        super(regNo, totalFee);
    }
    void payInTwoInstallments(double amount) 
    {
        pay(amount);
        pay(amount);
    }
}
class ScholarshipFeeAccount extends FeeAccount 
{
    private double scholarshipPercent;
    ScholarshipFeeAccount(String regNo, double totalFee, double scholarshipPercent) 
    {
        super(regNo, totalFee);
        if (scholarshipPercent >= 0 && scholarshipPercent <= 100) 
        {
            this.scholarshipPercent = scholarshipPercent;
        }
    }
    double effectiveDue() 
    {
        return getDue() - (getDue() * scholarshipPercent / 100);
    }
}
public class FeeAccountMain 
{
    public static void main(String[] args) 
    {
        HostelFeeAccount hostel = new HostelFeeAccount("101", 60000);
        hostel.payInTwoInstallments(20000);
        ScholarshipFeeAccount scholarship =new ScholarshipFeeAccount("102", 60000, 20);
        scholarship.pay(20000);
        System.out.println("Hostel Fee Due: " + hostel.getDue());
        System.out.println("Scholarship Fee Due: " + scholarship.effectiveDue());
        if (hostel instanceof HostelFeeAccount) 
        {
            System.out.println("Hostel account supports two installments");
        }
        if (scholarship instanceof ScholarshipFeeAccount) 
        {
            System.out.println("Scholarship account supports scholarship");
        }
    }
}