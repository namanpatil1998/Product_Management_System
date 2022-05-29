
package Product_Management_System;

/**
 *
 * @author naman
 */
//Created Treenode class for creation of node.
public class Treenode {
    Treenode left ,right;//created left , right nodes.
    ProductData data;//created product data class reference.
    Treenode(ProductData p)//single parameterised constructor.
    {
        this.data=p;
        this.left=this.right=null;
    }
    //created three parameterised constructor for initiallisation of data.
    Treenode(ProductData data, Treenode left, Treenode right)
    {
        this.data=data;
        this.left=left;
        this.right=right;
    }
    //Used getter setter methods to get and set objects of Treenode and Product data class.
    public ProductData getProductData()
    {
        return data;
    }
    public void setData(ProductData data)
    {
        this.data=data;
    }
    public Treenode getLeft()
    {
        return left;
    }
    public void setLeft(Treenode left)
    {
        this.left=left;
    }
    public Treenode getRight()
    {
        return right;
    }
    public void setRight(Treenode right)
    {
        this.right=right;
    }
    //here we are created and checking that the node is leaf node or not. 
    public boolean isLeaf()
    {
        if(left==null&&right==null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
