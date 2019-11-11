import java.util.*;
class Node{
    int data;
    Node left,right;
Node(int data)
{
    this.data=data;
    left=right=null;
}
}
class RevLevel
{
    Node root;
    RevLevel()
    {
        root=null;
    }
    void insert(int data)
    {
        root=Insert(root,data);
    }
    Node Insert(Node n,int data)
    {
        if(n==null)
        {
            n=new Node(data);
            return n;
        }
        if(data<n.data)
        {
            n.left=Insert(n.left,data);

        }
    else
    {
        n.right=Insert(n.right,data);
    }
    return n;
    }
//height function
int height(Node root)
{
    int leftheight,rightheight;
    if(root==null)
    return 0;
    else
    leftheight=height(root.left);
     rightheight=height(root.right);
    if(leftheight>rightheight)
    {
        return (leftheight+1);
    }
    else
    {
    return (rightheight+1);
}
}
void print(Node root,int lev)
{
    if(root==null)
 return;
    if(lev==1)
    System.out.print(root.data+" ");
   else
    print(root.left,lev-1);
    print(root.right,lev-1);

}
void print(Node root)
{
    int height=height(root);
for(int i=height;i>=1;i--)
{
print(root,i);
}
}
   public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        RevLevel r=new RevLevel();
      int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
int data=sc.nextInt();
r.insert(data);

        }
        r.print(r.root);
    }
}