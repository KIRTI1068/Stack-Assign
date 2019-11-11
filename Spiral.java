import java.util.*;

public class Spiral
{
    class Node
    {
        int data;
        Node right,left;
        Node(int data)
        {
            this.data = data;
            right=left=null;
        }
    }
    Node root ;
   Spiral()
    {
        root = null;
    }
    void insert(int data)
    {
        root = insertInTree(root,data);
    }
    Node insertInTree(Node root , int data)
    {
        if(root == null)
        {
            root = new Node(data);
            return root;
        }
        if(data < root.data)
        {
           root.left = insertInTree(root.left, data);
        }
        else
        {
            root.right = insertInTree(root.right, data);
        }
        return root;
    }
    int height()
    {
        int a ;
        a = calHeight(root);
        return a;
    }
    int calHeight(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        else
        {
            int l = calHeight(root.left);
            int r = calHeight(root.right);
            if(l>r)
            {
                return l+1;
            }
            else
            {
                return r+1;
            }
        }
    }
   
    void level()
    {
        int h = height();
        for(int i = 1 ; i<=h ; i++)
        {
            printlevel(root,i);
            System.out.println();
        }
    }
    void printlevel(Node root , int level)   //prints height in edges
    {
        if(root == null)
        {
            return;
        }
        if(level == 1)
        {
            System.out.print(root.data + " " );
        }
        else if(level>1)
        {
            printlevel(root.left, level-1);
            printlevel(root.right, level-1);
        }
    }
  
    void rightlevel()
    {
        int h = height();
        for(int i = 1 ; i<=h ; i++)
        {
            System.out.println();
            printrtllevel(root,i);
        }
    }
    void printrtllevel(Node root , int level)
    {
        if(root == null)
        {
            return;
        }
        if(level == 1)
        {
            System.out.print(root.data + " " );
        }
        else if(level>1)
        {
            printrtllevel(root.right, level-1);
            printrtllevel(root.left, level-1);
        }
    }
   
    void spiral()
    {
        printinSpiral(root);
    }
    void printinSpiral(Node root)
    {
        int h = height();
        for(int i = 1 ; i<=h ; i++)
        {
            if(i%2==1)
            {
                printrtllevel(root, i);
                System.out.println();
            }
            else
            {
                printlevel(root, i);
                System.out.println();
            }
        }
    }
 public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        Spiral r=new Spiral();
      int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
int data=sc.nextInt();
r.insert(data);

        }
           System.out.println("Edge height " + (r.height()-1));
      System.out.print("Left to Right printing"); 
        r.rightlevel(); //left to right printing;
         System.out.println();
        System.out.println("Spiral");
        r.spiral(); //printing in spiral form
    }
}