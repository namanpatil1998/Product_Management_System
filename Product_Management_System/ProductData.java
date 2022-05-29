
package Product_Management_System;

import java.util.UUID;

/**
 *
 * @author naman
 */
//Implemented comparable interface for Product data class of type product data.
public class ProductData implements Comparable<ProductData>{
    //created instance variables for product data storage.
    String productName;
    String make;
    String type;
    double price;
    int quantity;
    String uniqueid;//generates Unique ID for each instrument.
    //made an five argument constructor to initialise the instance variables for every object created in main method.
    ProductData(String productName, String make, String type, double price, int quantity )
    {
        this.productName=productName;
        this.make=make;
        this.price=price;
        this.quantity=quantity;
        this.type=type;
        this.uniqueid=UUID.randomUUID().toString();
    }
    //used getter and setters method to set or get specific instance of an object.
    String getProductName()
    {
        return productName;
    }
    void setProductName(String productName)
    {
        this.productName=productName;
    }
    String getMake()
    {
        return make;
    }
    void setMake(String make)
    {
        this.make=make;
    }
    String getType()
    {
        return type;
    }
    void setType(String type)
    {
        this.type=type;
    }
    double getPrice()
    {
        return price;
    }
    void setPrice(double price)
    {
        this.price=price;
    }
    int getQty()
    {
        return quantity;
    }
    void setQty(int quantity)
    {
        this.quantity=quantity;
    }
    String getUniqueid()
    {
        return uniqueid;
    }
    //used to comapare the obj with instance of its own class. 
    boolean equals(ProductData obj)
    {
        if(obj instanceof ProductData)
        {
            return (obj.productName.equalsIgnoreCase(productName));
        }
        else
        {
            return false;
        }
    }
    //overriden the compare to method in comparable interface for comparing the product name.  
    @Override
   public int compareTo(ProductData px){
		
		return (this.productName.compareToIgnoreCase(px.productName));
		
	}
//Overriden the toString method and converted the data in single string. easy to print all the data of object.
    @Override
    public String toString()
    {
        return (this.productName+"\t\t"+this.uniqueid+"\t"+this.make+"\t"+this.type+"\t"+this.price+"\t"+this.quantity);
    }
    
}
