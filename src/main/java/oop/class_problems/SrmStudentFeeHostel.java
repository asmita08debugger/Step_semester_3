package main.java.oop.class_problems;
class SrmStudentFeeHostel 
{
    String name;
    String regNo;
    HostelFeeAccount feeAccount;
    HostelRoom room;
    static int totalStudents = 0;
    SrmStudentFeeHostel(String name, String regNo, HostelFeeAccount feeAccount, HostelRoom room) 
    {
        this.name = name;
        this.regNo = regNo;
        this.feeAccount = feeAccount;
        this.room = room;
        totalStudents++;
    }
    void fullStatus() 
    {
        System.out.println("Name: " + name);
        System.out.println("Fee Due: " + feeAccount.getDue());
        if (room != null) 
        {
            System.out.println("Room: " + room.roomNo);
        }
        else 
        {
            System.out.println("Room: unallotted");
        }
        System.out.println();
    }
    public static void main(String[] args) 
    {
        HostelRoom[] rooms = { new HostelRoom(101, 2), new HostelRoom(102, 2) };
        HostelRoom room1 = HostelRoom.findAvailableRoom(rooms);
        if (room1 != null) 
        {
            room1.allot("Ravi");
        }
        HostelRoom room2 = HostelRoom.findAvailableRoom(rooms);
        if (room2 != null) 
        {
            room2.allot("Meera");
        }
        HostelFeeAccount fee1 = new HostelFeeAccount("101", 60000);
        fee1.pay(20000);
        HostelFeeAccount fee2 = new HostelFeeAccount("102", 60000);
        fee2.pay(-5000);
        HostelFeeAccount fee3 = new HostelFeeAccount("103", 60000);
        fee3.pay(15000);
        SrmStudentFeeHostel s1 = new SrmStudentFeeHostel("Ravi", "101", fee1, room1);
        SrmStudentFeeHostel s2 = new SrmStudentFeeHostel("Meera", "102", fee2, room2);
        SrmStudentFeeHostel s3 = new SrmStudentFeeHostel("Karthik", "103", fee3, null);
        s1.fullStatus();
        s2.fullStatus();
        s3.fullStatus();
        System.out.println("Total Students: " + totalStudents);
    }
}