package main.java.oop.class_problems;
class SrmStudent 
{
    String name;
    String regNo;
    int attendance;
    SrmStudent(String name, String regNo, int attendance) 
    {
        this.name = name;
        this.regNo = regNo;
        this.attendance = attendance;
    }
    void addAttendanceUpdate(int newAttendance) 
    {
        attendance = newAttendance;
    }
    boolean isEligible() 
    {
        return attendance >= 75;
    }
    static double classAverage(SrmStudent[] students) 
    {
        int total = 0;
        for (SrmStudent student : students) 
        {
            total += student.attendance;
        }
        return (double) total / students.length;
    }
    public static void main(String[] args) 
    {
        SrmStudent[] students = {
            new SrmStudent("Ravi", "101", 82),
            new SrmStudent("Anitha", "102", 68),
            new SrmStudent("Karthik", "103", 91),
            new SrmStudent("Meera", "104", 74),
            new SrmStudent("Suresh", "105", 60) };
            for (SrmStudent student : students) 
            {
                System.out.println(student.name + " - Eligible: " + student.isEligible());
            }
        System.out.println("Class Average: " + classAverage(students) + "%");
    }
}