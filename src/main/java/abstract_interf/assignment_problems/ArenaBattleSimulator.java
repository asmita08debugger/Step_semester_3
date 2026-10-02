package main.java.abstract_interf.assignment_problems;
interface Attackable 
{
    void attack();
    void attack(int damage);
}
interface Defendable 
{
    void defend();
}
abstract class Combatant 
{
    protected String name;
    protected int health;
    public Combatant(String name, int health) 
    {
        this.name = name;
        this.health = health;
    }
    public abstract void display();
}
class Warrior extends Combatant implements Attackable, Defendable 
{
    public Warrior(String name, int health) 
    {
        super(name, health);
    }
    @Override
    public void display() 
    {
        System.out.println("Warrior: " + name + " | Health: " + health);
    }
    @Override
    public void attack() 
    {
        System.out.println(name + " attacks with sword");
    }
    @Override
    public void attack(int damage) 
    {
        System.out.println(name + " attacks for " + damage + " damage");
    }
    @Override
    public void defend() 
    {
        System.out.println(name + " blocks the attack");
    }
}
class Mage extends Combatant implements Attackable, Defendable 
{
    public Mage(String name, int health) 
    {
        super(name, health);
    }
    @Override
    public void display() 
    {
        System.out.println("Mage: " + name + " | Health: " + health);
    }
    @Override
    public void attack() 
    {
        System.out.println(name + " attacks with magic");
    }
    @Override
    public void attack(int damage) 
    {
        System.out.println(name + " casts spell for " + damage + " damage");
    }
    @Override
    public void defend() 
    {
        System.out.println(name + " creates a magic shield");
    }
}
class Trap implements Attackable 
{
    @Override
    public void attack() 
    {
        System.out.println("Trap activates");
    }
    @Override
    public void attack(int damage) 
    {
        System.out.println("Trap deals " + damage + " damage");
    }
}
public class ArenaBattleSimulator 
{
    public static void main(String[] args) 
    {
        Warrior warrior = new Warrior("Knight", 100);
        Mage mage = new Mage("Wizard", 80);
        Trap trap = new Trap();
        warrior.display();
        mage.display();
        Attackable[] attackers = {warrior, mage, trap};
        for (Attackable attacker : attackers) 
        {
            attacker.attack();
        }
        warrior.attack(30);
        mage.attack(40);
        trap.attack(20);
        warrior.defend();
        mage.defend();
    }
}