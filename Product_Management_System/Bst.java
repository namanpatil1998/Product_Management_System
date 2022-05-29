
package Product_Management_System;

import java.util.ArrayList;

/**
 *
 * @author naman
 */
//created class for Binary Search Tree.
public class Bst {
    ArrayList<ProductData> al;
    Treenode root;//created refernce "root" of tree node class.
    Bst()//created non parameterised constructor to initiallise root.
    {
        root=null;
    }
    boolean isEmpty()//checking wheather root is empty or not.
    {
        return (root==null);
    }
    void insert(ProductData data)//inserting data in node of tree.
    {
        if(root==null)//if root refernce(node) is null then it creates a new node and assign data to it.
        {
            root = new Treenode(data , null, null);
        }
        else// if already root node is present then it calls the insert function.  
        {
            insert(data, root);
        }
    }
    //overloading insert function 
    void insert(ProductData pd,Treenode current)
    {
        //checking if passed object name is lexicographically smaller than root/current object name.
        if(pd.compareTo(current.getProductData())<0)
        {
            if(current.getLeft()==null)//check if left node of current node is null or not.
                //if found null then create a new tree node object.
            {
                current.setLeft(new Treenode(pd,null,null));
            }
            else//else called recursively insert function.
            {
               insert(pd,current.getLeft());
            }
            //checking if passed object name is lexicographically greater than or equal to root/current object name.
        }else if(pd.compareTo(current.getProductData())>=0)
        {
            if(current.getRight()==null)//check if right node of current node is null or not.
                //if found null then create a new tree node object.
            {
                current.setRight(new Treenode(pd,null,null));
            }else//else called recursively insert function.
            {
                insert(pd,current.getRight());
            }
        }else//if above condition not satisfied then we return the control back. 
        {
                    return;
        }
    }
    //created count method to count no of nodes.
    public int count()
    {
        return count(root);//calling overloaded count method.
    }
    //overloading count method.
    int count (Treenode current)
    {
        if(current==null)//check if current Treenode obj is null, if null then return zero. 
        {
            return 0;
        }else//else return count of nodes in the tree.
        {
            return (1+count(current.getLeft())+count(current.getRight()));//calling count method twice recursively
            //and returning count. 
        }
    }
    public ProductData search(ProductData pd)//created search method for searching product data.
    {
        if(root==null)//check if root is null or not, if null then ret
        {
            return null;
        }else
        {
            return search(pd,root); // calling overriden method
        }
    }//overriding search method
    public ProductData search(ProductData pd,Treenode current)
    {
        ProductData p=null; //initialing p to null
        try//used try catch to handel exception.
        {
            if(pd.equals(current.getProductData()))//comparing passed object pd of product class with object present in current node
                //of Treenode class
            {
                p=current.getProductData();//if true then assigning product data cobject getting from get data method to p and 
                //returning p as searched data found.
                return p;//returning serached data.
            }
            else if(pd.compareTo(current.getProductData())<0)//sending sarching function to left if data serached is smaller than
                //current or root node data.
            {
                return search(pd,current.getLeft());//recursive call for left search.
            }
            else//sending sarching function to left if data serached is smaller than current or root node data. 
            {
                return search(pd,current.getRight());//recursive call for right search.
            }
        }
        catch(NullPointerException ex)//catching null pointer exception.
        {
            return null;
        }
    }
     void delete(ProductData pd)//deleting the node.
    {
        //check if empty
        if(isEmpty())
        {
            System.out.println("Tree Empty");
        }else if(search(pd)!=pd)//if data to be deleted is not present.
        {
            System.out.println("Sorry "+pd.productName+" is not present");
        }
        else
        {
            root = delete(root,pd);//calling the overriden delete method and replacing node with right node.
            System.out.println(pd+"\n is deleted from the tree");
        }
    }
     //overloading delete method.
    Treenode delete(Treenode current,ProductData pd)
    {
        Treenode n,p,p2;//Creating objects of treenode class.
        if(current==null)//check if root is null and if null then return current root
        {
            return current;
        }
        if(pd.compareTo(current.getProductData())<0)//sending and searching function to left if data serached is smaller than
                //current or root node data.
        {
            current.left=delete(current.left,pd);
        }else if(pd.compareTo(current.getProductData())>0)//sending and searching function to right if data serached is smaller than
                //current or root node data.
        {
            current.right=delete(current.right,pd);
        }else
        {
            Treenode lt,rt;//created left and right nodes
            lt=current.getLeft();//assigned left of cuurent to left. 
            rt=current.getRight();//assigned right of cuurent to right. 
             if(current.left==null)//if left of current is null then right node is returned
            {
                return current.right;
            }else if(current.right==null)//if right of current is null then left node is returned
            {
                return current.left;
            }else//if data is present in both nodes
            {
                p2=rt;//assigning rt to p2
                p=rt;//assigning rt to p
                while(p.getLeft()!=null)//if left of p is not null then traverse to left most of tree.
                {
                    p=p.getLeft();
                }
                p.setLeft(lt);//passing left of currnt node to left most node of BST 
                return p2;//returning right node of current node.
            }
        }
        return current;//returning current node of updated tree.
    }
    
    ArrayList inOrder()//creating inOrder function of arraylist type
    {
         al = new ArrayList <ProductData>();//initiallising arraylist object.
        if(root==null)//if root is null then trree is empty.
        {
            System.out.println("Tree is empty");
        }
        else
        {
            inOrder(root);//calling overloaded function 
        }
        return al;//returning arraylist object al.
    }
    //overloading inorder function
    void inOrder(Treenode current)
    {
        if(current!=null)//if current is not null  
        {
            inOrder(current.getLeft());//recursively calling inorder for left traversal.
            System.out.println(current.getProductData().toString());//printing current node data 
                                                                    //while returning from recursive call
            inOrder(current.getRight());//traversing right of every left node  
        }
        
    }
    
}
