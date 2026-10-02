package main.java.abstract_interf.assignment_problems;
abstract class Shape 
{
    private static int shapeCounter = 0;
    private final String shapeId;
    public Shape() 
    {
        shapeCounter++;
        shapeId = "SHAPE-" + shapeCounter;
    }
    public abstract double calculateArea();
    public void scale(double factor) 
    {
        scale(factor, factor);
    }
    public abstract void scale(double xFactor, double yFactor);
    public String getShapeId() 
    {
        return shapeId;
    }
}
class CircleShape extends Shape 
{
    private double radius;
    public CircleShape(double radius) 
    {
        this.radius = radius;
    }
    @Override
    public double calculateArea() 
    {
        return Math.PI * radius * radius;
    }
    @Override
    public void scale(double xFactor, double yFactor) 
    {
        radius *= (xFactor + yFactor) / 2;
    }
}
class SquareShape extends Shape 
{
    private double side;
    public SquareShape(double side) 
    {
        this.side = side;
    }
    @Override
    public double calculateArea() 
    {
        return side * side;
    }
    @Override
    public void scale(double xFactor, double yFactor) 
    {
        side *= (xFactor + yFactor) / 2;
    }
}
public class DrawingCanvas 
{
    static void printArea(Shape s) 
    {
        System.out.println(s.calculateArea());
    }
    public static void main(String[] args) 
    {
        CircleShape c = new CircleShape(5.0);
        SquareShape sq = new SquareShape(4.0);
        printArea(c);
        printArea(sq);
        sq.scale(2.0);
        printArea(sq);
        System.out.println(c.getShapeId());
        System.out.println(sq.getShapeId());
    }
}