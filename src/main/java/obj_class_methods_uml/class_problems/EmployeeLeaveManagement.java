package main.java.obj_class_methods_uml.class_problems;
public class EmployeeLeaveManagement 
{
    interface Employee 
    {
        String getName();
        String getType();
    }
    static class FullTime implements Employee 
    {
        String name;
        FullTime(String name) 
        {
            this.name = name;
        }
        public String getName() 
        {
            return name;
        }
        public String getType() 
        {
            return "Full-time";
        }
    }
    static class PartTime implements Employee 
    {
        String name;
        PartTime(String name) 
        {
            this.name = name;
        }
        public String getName() 
        {
            return name;
        }
        public String getType() 
        {
            return "Part-time";
        }
    }
    static class LeaveRequest 
    {
        Employee employee;
        String start, end, status = "Pending";
        LeaveRequest(Employee employee, String start, String end) {
            this.employee = employee;
            this.start = start;
            this.end = end;
            System.out.println("Leave request submitted by " + employee.getName() + " for " + start + " to " + end + ". Status: " + status);
        }
        void review(String newStatus) 
        {
            if (!status.equals("Pending")) 
            {
                System.out.println("Cannot change status: " + status + " request cannot revert to Pending.");
            } 
            else if (newStatus.equals("Approved") || newStatus.equals("Rejected")) 
            {
                status = newStatus;
                System.out.println("Leave request for " + employee.getName() + " " + status.toLowerCase() + ". Status: " + status);
            }
        }
    }
    public static void main(String[] args) 
    {
        Employee e1 = new FullTime("John Doe");
        Employee e2 = new PartTime("Jane Smith");
        LeaveRequest r1 = new LeaveRequest(e1, "2024-10-10", "2024-10-12");
        r1.review("Approved");
        LeaveRequest r2 = new LeaveRequest(e2, "2024-11-01", "2024-11-05");
        r1.review("Pending");
    }
}