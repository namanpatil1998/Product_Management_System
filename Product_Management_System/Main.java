
package Product_Management_System;

/**
 *
 * @author naman
 */
import java.util.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Main {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Main m=new Main();//created object of main class.
        System.out.println("\t\t\t\t\t***Product Management System***");
        m.timeDate();//calling method for time and date
        System.out.println("\nPlease Enter UserID:-");
        String UserID=sc.nextLine();//taking user ID from user.
        System.out.println("Please Enter Password:-");
        String Password=sc.next();//taking password from user.
        String pwd="Naman@||Patil";//predefined password
         Bst b=new Bst();//BST class object is created
        while(true){
         if(Password.equals(pwd))//comparing user input pass word with predefined password
        {
              System.out.println("\t\t\t\tAccess Granted!!!\n\t\t\t\tWelcome to Product Management System "+UserID);
         //creating objects of Product data class and passing values to objects.
         ProductData pd1=new ProductData("F", "Emerson", "\tmass flow", 28000, 5);
         ProductData pd2=new ProductData("F", "Siemens", "\tlevel\t", 32000, 3);
         ProductData pd3=new ProductData("T", "ABB", "\ttemp\t", 2800, 4);
         ProductData pd4=new ProductData("H", "Honeywell", "hygro\t", 12000, 2);
         ProductData pd5=new ProductData("D", "Emerson", "\tData flow", 23000, 5);
         ProductData pd6=new ProductData("Q", "Emerson", "\tsd flow\t", 28400, 5);
          while(true)//infinite while loop.
          {
              System.out.println("Please Select Options From Below:-\t"+"\n1.Insert and Update the Stock.\n2.Print the Stock.\n3.Delete and Update the Stock.\n4.Search In the Stock.\n5.Exit");
              int i=sc.nextInt();//taking user choice to select function to perform.   
              if(i<6)
              {
                switch(i)
                {
                    case 1://Inserting and printing the products 
                   System.out.println("Product Name\t"+"\tProduct Unique ID"+"\t\tMake"+"\t\tType"+"\t\tPrice"+"\tQty");
                   System.out.println("=====================================================================================================");
                   b.insert(pd1);
                   b.insert(pd2);
                   b.insert(pd3);
                   b.insert(pd4);
                   b.insert(pd5);
                   b.insert(pd6);
                   ArrayList listToDis =  b.inOrder();//print the products through arraylist
                     for(int j=0;j<listToDis.size();j++)
                     {
                        System.out.println(listToDis.get(j)); 
                     }
                     System.out.println("Total no of Products in Stock :- "+b.count()); 
                   System.out.println("=====================================================================================================");
                    break;
                    case 2://using inOrder function to print the tree
                   System.out.println("Product Name\t"+"\tProduct Unique ID"+"\t\tMake"+"\t\tType"+"\t\tPrice"+"\tQty");
                   System.out.println("=====================================================================================================");
                   b.inOrder();
                   System.out.println("Total no of Products in Stock :- "+b.count()); 
                   System.out.println("=====================================================================================================");
                    break;
                    case 3://deleting the tree node as product
                   System.out.println("Product Name\t"+"\tProduct Unique ID"+"\t\tMake"+"\t\tType"+"\t\tPrice"+"\tQty");
                   System.out.println("=====================================================================================================");
                   b.delete(pd1);
                   System.out.println("=====================================================================================================");
                   b.inOrder();//printing the tree after deleting.
                   System.out.println("Total no of Products in Stock :- "+b.count()); 
                   System.out.println("=====================================================================================================");
                    break;
                    case 4://searching the object in the tree.
                   System.out.println("====================================================================================================="); 
                   try
                   {
                        System.out.println("\n"+(b.search(pd2).toString()));
                   }
                   catch(Exception ex)
                   {
                       System.err.println("Searched Element is Out of Stock!!!");
                   }
                   System.out.println("================================================================================================"); 
                         break;
                    case 5://exit condition for infinite while loop.
                        return;
                }
            }else//error condition for wrong user choice
              {
                  System.err.println("Wrong Input!!!,\nPlease select valid Input.");
              }
        }        
        }
        else//error condition for wrong password
        {
            System.err.println("Wrong Password!!!");
             System.err.println("Please enter 1 to exit or Any Number key to re-enter the password");
            int Choice=sc.nextInt();
            if(Choice==1)
            {
                 return;
            }
            else
            {
              Password=sc.next();
            }
        }
         
      }
    }
     void  timeDate()//created timedate method to print date and time .
	  {
	  
		//  DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy/MM/dd");
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd\t\t\t\t\t\t\t\t\t\t HH:mm:ss");
	   
		  LocalDateTime now = LocalDateTime.now();

		   System.out.println("Date : "+dtf.format(now));

		
	  } 

}
