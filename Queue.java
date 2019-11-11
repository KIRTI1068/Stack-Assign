import java.io.*;
import java.util.*;

public class Queue
{
    int head = 0;
    int tail = 0;
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    void enq(int a)
    {
        s1.push(a);
        tail++;
    }
    int deq()
    {
        if(s1.empty())
        {
            return Integer.MIN_VALUE;
        }
        while(!s1.empty())
        {
            s2.push(s1.pop());
        }
        int a = s2.pop();
        while(!s2.empty())
        {
            s1.push(s2.pop());
        }
        head++;
        return a;
    }
    void print()
    {
        if(s1.empty())
        {
            System.out.println("Empty");
            return;
        }
        while(!s1.empty())
        {
            s2.push(s1.pop());
        }
        while(!s2.empty())
        {
            int a = s2.peek();
            s1.push(s2.pop());
            System.out.println(a);
        }
    }
public static void main(String []agrs)
    {
        Queue q = new Queue();
        q.enq(10);
        q.enq(20);
        q.enq(30);
        q.enq(40);
        q.enq(50);

        System.out.println("\n"+q.deq());
        System.out.println(q.deq());
        q.print();
       }
}