package main.java.obj_class_methods_uml.assignment_problems;
import java.util.*;
public class ElectiveSeatRush 
{
    interface CreditPolicy 
    {
            int getLimit();
            String getType();
    }
        static class Regular implements CreditPolicy 
        {
            public int getLimit() { return 24; }
            public String getType() { return "Regular"; }
        }
        static class Honors implements CreditPolicy 
        {
            public int getLimit() { return 28; }
            public String getType() { return "Honors"; }
        }
        static class Exchange implements CreditPolicy 
        {
            public int getLimit() { return 20; }
            public String getType() { return "Exchange"; }
        }
        static class Student 
        {
            String name;
            int credits;
            CreditPolicy policy;
            Student(String name, int credits, CreditPolicy policy) 
            {
                this.name = name;
                this.credits = credits;
                this.policy = policy;
            }
        }
        static class Elective 
        {
            String name;
            int credits, capacity;
            List<Student> enrolled = new ArrayList<>();
            Queue<Student> waitlist = new LinkedList<>();
            Elective(String name, int credits, int capacity) 
            {
                this.name = name;
                this.credits = credits;
                this.capacity = capacity;
            }
        }
        static class EnrollmentService 
        {
            void enroll(Student s, Elective e) 
            {
                if (contains(s, e)) 
                {
                    System.out.println("Enrollment failed: " + s.name + " already enrolled or waitlisted.");
                    return;
                }
                if (s.credits + e.credits > s.policy.getLimit()) 
                {
                    System.out.println("Enrollment failed: " + s.name + " would exceed the " + s.policy.getType() + " credit limit (" + (s.credits + e.credits) + "/" + s.policy.getLimit() + ").");
                    return;
                }
                if (e.enrolled.size() < e.capacity) 
                {
                    e.enrolled.add(s);
                    s.credits += e.credits;
                    System.out.println(s.name + " enrolled in " + e.name + " (credits: " + s.credits + "/" + s.policy.getLimit() + ").");
                } 
                else 
                {
                    e.waitlist.add(s);
                    System.out.println(e.name + " is full. " + s.name + " added to waitlist (position " + e.waitlist.size() + ").");
                }
            }
            boolean contains(Student s, Elective e) 
            {
                return e.enrolled.contains(s) || e.waitlist.contains(s);
            }
            void drop(Student s, Elective e) 
            {
                if (!e.enrolled.remove(s)) 
                {
                    System.out.println(s.name + " is not enrolled in " + e.name + ".");
                    return;
                }
                s.credits -= e.credits;
                System.out.println(s.name + " dropped " + e.name + " (credits: " + s.credits + "/" + s.policy.getLimit() + ").");
                int size = e.waitlist.size();
                for (int i = 0; i < size; i++) 
                {
                    Student next = e.waitlist.poll();
                    if (next.credits + e.credits <= next.policy.getLimit()) 
                    {
                        e.enrolled.add(next);
                        next.credits += e.credits;
                        System.out.println(next.name + " promoted from waitlist and enrolled in " + e.name + " (credits: " + next.credits + "/" + next.policy.getLimit() + ").");
                        return;
                    } 
                    else 
                    {
                        e.waitlist.add(next);
                    }
                }
            }
        }
        public static void main(String[] args) 
        {
            Elective cloud = new Elective("Cloud Computing", 4, 2);
            Student asha = new Student("Asha", 20, new Regular());
            Student ravi = new Student("Ravi", 22, new Honors());
            Student neha = new Student("Neha", 12, new Exchange());
            Student kiran = new Student("Kiran", 22, new Regular());
            EnrollmentService service = new EnrollmentService();
            service.enroll(asha, cloud);
            service.enroll(ravi, cloud);
            service.enroll(neha, cloud);
            service.enroll(kiran, cloud);
            service.drop(asha, cloud);
        }
}