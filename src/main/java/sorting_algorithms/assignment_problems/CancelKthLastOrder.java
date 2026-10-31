package main.java.sorting_algorithms.assignment_problems;
public class CancelKthLastOrder
{
    static class Node 
    {
        int data;
        Node next;
        Node(int data) 
        {
            this.data = data;
        }
    }
    static Node removeKthFromEnd(Node head, int k) 
    {
        Node dummy = new Node(0);
        dummy.next = head;
        Node first = dummy;
        Node second = dummy;
        for (int i = 0; i <= k; i++)
        first = first.next;
        while (first != null) 
        {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
    static void display(Node head) 
    {
        while (head != null) 
        {
            System.out.print(head.data);
            if (head.next != null)
            System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) 
    {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head = removeKthFromEnd(head, 2);
        display(head);
        head = removeKthFromEnd(head, 4);
        display(head);
    }
}