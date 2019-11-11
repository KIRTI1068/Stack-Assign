import java.util.*;
class Node{
    int data;
    Node left,right;
Node(int data)
{
    this.data=data;
    left=right=null;
}}
class PreToIn
{
    Node root;
    PreToIn()
    {
        root=null;
    }
   void insert(int data)
    {
        root=InsertData(root,data);
    }
    Node InsertData(Node root,int data)
    {
         if(root==null)
        {
            root=new Node(data);
            return root;
        }
       if(data<root.data)
        {
             root.left=InsertData(root.left,data);
        }
        else
        {
            root.right=InsertData(root.right,data);
        }
    return root;
    }
    void print(Node root)
    {
        if(root==null)
        return;
        else
        print(root.left);
        System.out.println(root.data);
        print(root.right);
    }
    void display()
    {
        print(root);
    }
    

    public static void main(String args[])
    {
        PreToIn p = new PreToIn();
    int arr[]=new int[]{50,30,10,40,80,70};
    for(int i=0;i<arr.length;i++)
    {
        p.insert(arr[i]);
    }
    p.display();
    }
}