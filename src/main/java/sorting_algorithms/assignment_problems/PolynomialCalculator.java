package main.java.sorting_algorithms.assignment_problems;
public class PolynomialCalculator 
{
    static class Node 
    {
        int coefficient, exponent;
        Node next;
        Node(int coefficient, int exponent) 
        {
            this.coefficient = coefficient;
            this.exponent = exponent;
        }
    }
    static Node addPolynomials(Node p, Node q) 
    {
        Node dummy = new Node(0, 0);
        Node tail = dummy;
        while (p != null && q != null) 
        {
            if (p.exponent == q.exponent) 
            {
                int sum = p.coefficient + q.coefficient;
                if (sum != 0) 
                {
                    tail.next = new Node(sum, p.exponent);
                    tail = tail.next;
                }
                p = p.next;
                q = q.next;
            } 
            else if (p.exponent > q.exponent) 
            {
                tail.next = new Node(p.coefficient, p.exponent);
                tail = tail.next;
                p = p.next;
            } 
            else 
            {
                tail.next = new Node(q.coefficient, q.exponent);
                tail = tail.next;
                q = q.next;
            }
        }
        while (p != null) 
        {
            tail.next = new Node(p.coefficient, p.exponent);
            tail = tail.next;
            p = p.next;
        }
        while (q != null) 
        {
            tail.next = new Node(q.coefficient, q.exponent);
            tail = tail.next;
            q = q.next;
        }
        return dummy.next;
    }
    static void display(Node head) 
    {
        while (head != null) 
        {
            System.out.print(head.coefficient);
            if (head.exponent > 0)
                System.out.print("x^" + head.exponent);
            if (head.next != null)
                System.out.print(" + ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) 
    {
        Node p = new Node(5, 3);
        p.next = new Node(4, 2);
        p.next.next = new Node(2, 0);
        Node q = new Node(5, 2);
        q.next = new Node(-3, 1);
        q.next.next = new Node(1, 0);
        display(addPolynomials(p, q));
        Node a = new Node(3, 2);
        a.next = new Node(1, 0);
        Node b = new Node(-3, 2);
        b.next = new Node(4, 1);
        display(addPolynomials(a, b));
    }
}