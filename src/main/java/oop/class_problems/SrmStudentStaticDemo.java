package main.java.oop.class_problems;
class BrokenStudent 
{
    static String name;
    static String regNo;
    static int attendance;
    BrokenStudent(String name, String regNo, int attendance) 
    {
        BrokenStudent.name = name;
        BrokenStudent.regNo = regNo;
        BrokenStudent.attendance = attendance;
    }
    void printDetails() 
    {
        System.out.println(name + " " + regNo + " " + attendance);
    }
}
class FixedStudent 
{
    String name;
    String regNo;
    int attendance;
    static String university = "SRM University";
    static int admissionCount = 0;
    FixedStudent(String name, int attendance) 
    {
        this.name = name;
        this.attendance = attendance;
        admissionCount++;
        this.regNo = "RA2311003010" + admissionCount;
    }
    void printIdCard() 
    {
        System.out.println(name + " " + regNo + " " + university);
    }
    static void printTotalAdmissions() 
    {
        System.out.println("Total Admissions: " + admissionCount);
    }
}
public class SrmStudentStaticDemo 
{
    public static void main(String[] args) 
    {
        System.out.println("Broken Version:");
        BrokenStudent student1 = new BrokenStudent("Ravi", "101", 82);
        BrokenStudent student2 = new BrokenStudent("Meera", "102", 74);
        student1.printDetails();
        student2.printDetails();
        System.out.println("\nFixed Version:");
        FixedStudent s1 = new FixedStudent("Ravi", 82);
        FixedStudent s2 = new FixedStudent("Meera", 74);
        s1.printIdCard();
        s2.printIdCard();
        FixedStudent.printTotalAdmissions();
    }
}