package main.java.abstract_interf.class_problems;
interface ITaxable 
{
    double calculateTax();
}
abstract class Employee 
{
    private String name;
    protected double salary;
    public Employee() 
    {
        this("Unknown", 0);
    }
    public Employee(String name) 
    {
        this(name, 0);
    }
    public Employee(String name, double salary) 
    {
        this.name = name;
        this.salary = salary;
    }
    public String getName() 
    {
        return name;
    }
    public abstract double calculateBonus();
}
class FullTimeEmployee extends Employee implements ITaxable 
{
    private double bonusRate;
    public FullTimeEmployee(String name, double salary) 
    {
        this(name, salary, 0.10);
    }
    public FullTimeEmployee(String name, double salary, double bonusRate) 
    {
        super(name, salary);
        this.bonusRate = bonusRate;
    }
    @Override
    public double calculateBonus() 
    {
        return salary * bonusRate;
    }
    @Override
    public double calculateTax() 
    {
        return salary * 0.10;
    }
}
class ContractEmployee extends Employee implements ITaxable 
{
    private double fixedBonus;
    public ContractEmployee(String name, double salary) 
    {
        super(name, salary);
        fixedBonus = 500;
    }
    @Override
    public double calculateBonus() 
    {
        return fixedBonus;
    }
    @Override
    public double calculateTax() 
    {
        return salary * 0.05;
    }
}
public class QuarterlyBonusCalculator 
{
    public static double totalBonus(Employee[] employees) 
    {
        double total = 0;
        for (Employee employee : employees) 
        {
            total += employee.calculateBonus();
        }
        return total;
    }
    public static void main(String[] args) 
    {
        FullTimeEmployee fullTime = new FullTimeEmployee("Asmita", 50000);
        ContractEmployee contract = new ContractEmployee("Rahul", 30000);
        Employee[] employees = {fullTime, contract};
        System.out.println("Full Time Bonus: "+ fullTime.calculateBonus());
        System.out.println("Full Time Tax: "+ fullTime.calculateTax());
        System.out.println("Contract Bonus: "+ contract.calculateBonus());
        System.out.println("Contract Tax: "+ contract.calculateTax());
        System.out.println("Total Bonus: "+ totalBonus(employees));
        if (fullTime instanceof ITaxable) 
        {
            System.out.println("Full Time employee is taxable");
        }
    }
}