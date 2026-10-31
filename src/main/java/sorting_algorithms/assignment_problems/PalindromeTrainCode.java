package main.java.sorting_algorithms.assignment_problems;
public class PalindromeTrainCode 
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
    static Node reverse(Node head) 
    {
        Node prev = null;
        while (head != null) 
        {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    static boolean isPalindrome(Node head) 
    {
        if (head == null || head.next == null)
            return true;
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) 
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node second = reverse(slow.next);
        Node temp = second;
        boolean result = true;
        while (temp != null) 
        {
            if (head.data != temp.data) 
            {
                result = false;
                break;
            }
            head = head.next;
            temp = temp.next;
        }
        slow.next = reverse(second);
        return result;
    }
    public static void main(String[] args) 
    {
        Node a = new Node(1);
        a.next = new Node(2);
        a.next.next = new Node(3);
        a.next.next.next = new Node(2);
        a.next.next.next.next = new Node(1);
        System.out.println(isPalindrome(a));
        Node b = new Node(1);
        b.next = new Node(2);
        b.next.next = new Node(3);
        b.next.next.next = new Node(2);
        System.out.println(isPalindrome(b));
        Node c = new Node(1);
        c.next = new Node(2);
        c.next.next = new Node(2);
        c.next.next.next = new Node(1);
        System.out.println(isPalindrome(c));
    }
}