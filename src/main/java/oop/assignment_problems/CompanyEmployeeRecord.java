package main.java.oop.assignment_problems;
class CompanyEmployeeRecord 
{
    String name;
    String empId;
    Employee employee;
    ParkingSlot slot;
    static int totalRecords = 0;
    CompanyEmployeeRecord(String name, String empId, Employee employee, ParkingSlot slot) 
    {
        this.name = name;
        this.empId = empId;
        this.employee = employee;
        this.slot = slot;
        totalRecords++;
    }
    String fullProfile() 
    {
        double pay;
        if (employee instanceof ManagerEmployee) 
        {
            pay = ((ManagerEmployee) employee).effectiveSalary();
        }
        else if (employee instanceof InternEmployee) 
        {
            pay = ((InternEmployee) employee).effectiveSalary();
        }
        else 
        {
            pay = employee.getSalary();
        }
        if (slot != null) 
        {
            return name + " | Pay: Rs " + pay + " | Slot: " + slot.slotNo;
        }
        else 
        {
            return name + " | Pay: Rs " + pay + " | Slot: no parking assigned";
        }
    }
    public static void main(String[] args) 
    {
        Employee e1 = new ManagerEmployee(101, "Divya", 70000, 8000);
        Employee e2 = new Employee(102, "Karan", 40000);
        Employee e3 = new InternEmployee(103, "Meera", 12000, 10000);
        ParkingSlot slot1 = new ParkingSlot("A1", 1, 0);
        ParkingSlot slot2 = new ParkingSlot("A2", 1, 0);
        CompanyEmployeeRecord r1 = new CompanyEmployeeRecord("Divya", "101", e1, slot1);
        CompanyEmployeeRecord r2 = new CompanyEmployeeRecord("Karan", "102", e2, slot2);
        CompanyEmployeeRecord r3 = new CompanyEmployeeRecord("Meera", "103", e3, null);
        System.out.println(r1.fullProfile());
        System.out.println(r2.fullProfile());
        System.out.println(r3.fullProfile());
        System.out.println("Total records: " + CompanyEmployeeRecord.totalRecords);
    }
}