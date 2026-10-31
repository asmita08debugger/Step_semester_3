package main.java.sorting_algorithms.assignment_problems;
public class BrowserHistory 
{
    static class Node 
    {
        String data;
        Node prev, next;
        Node(String data) 
        {
            this.data = data;
        }
    }
    static class BrowserHistoryList 
    {
        Node current;
        BrowserHistoryList(String home) 
        {
            current = new Node(home);
        }
        void visit(String url) 
        {
            Node newNode = new Node(url);
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
        }
        String back(int steps) 
        {
            while (steps > 0 && current.prev != null) 
            {
                current = current.prev;
                steps--;
            }
            return current.data;
        }
        String forward(int steps) 
        {
            while (steps > 0 && current.next != null) 
            {
                current = current.next;
                steps--;
            }
            return current.data;
        }
    }
    public static void main(String[] args) 
    {
        BrowserHistoryList browser = new BrowserHistoryList("srm.edu");
        browser.visit("a.com");
        browser.visit("b.com");
        browser.visit("c.com");
        System.out.println(browser.back(1));
        System.out.println(browser.back(1));
        System.out.println(browser.forward(1));
        browser.visit("d.com");
        System.out.println(browser.forward(2));
        System.out.println(browser.back(2));
        System.out.println(browser.back(7));
    }
}