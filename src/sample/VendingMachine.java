package sample;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;
import java.io.IOException;

/**
   A vending machine.
*/
public class VendingMachine { 
   
    public ArrayList<Product> products;
   
   
   /**
      Constructs a VendingMachine object.
   */
   public VendingMachine()  {
   
      //filereader fileread = new filereader();
      //ArrayList<Product> products = new ArrayList<>();
      //products = fileread.getproducts();
      //for (Product p:products)
      //System.out.println(p);
      //products.printProducts(products);
      
    }
      
    
    /**
      Gets the type of products in the vending machine.
      @return an array of products sold in this machine.
   */
   public ArrayList<Product> getProducts()
   { 
      filereaderproducts filereadproducts = new filereaderproducts();
      ArrayList<Product> products = new ArrayList<>();
      products = filereadproducts.getproducts();
       
      
      return products;
   }
    
   

  /*
      Buys a product from the vending machine.
      @param p the product to buy
  */
    public double buyProduct(Product p, double credit, Customer c,int cindex)
    { 
      filereaderproducts filereadproducts = new filereaderproducts();
      ArrayList<Product> products = new ArrayList<>();
      products = filereadproducts.getproducts();
      
      filereadercustomers fileread = new filereadercustomers();
      ArrayList<Customer> customers = new ArrayList<>();
      customers = fileread.getcustomers();   
      Customer cust=customers.get(cindex);


      System.out.println(p);
      for (int i = 0; i < products.size(); i++)
      { 
         Product prod = products.get(i);
         
         //System.out.println(prod);
          if (prod.equals(p))
         
         {  
            
            if ((p.getPrice() <= credit) & (p.getstock() > 0))
            {  
               //System.out.println(p);
               p.removeastock();
               products.set(i,p);
               //System.out.println(products);
               //write to file with new list
               try {
                FileWriter fr = new FileWriter("C:\\Users\\Liam\\Downloads\\Products.txt");
                BufferedWriter br = new BufferedWriter(fr);
                PrintWriter out = new PrintWriter(br);
                for(Product pr : products){
              
                out.println(pr);}
            
                out.close();
                
                
                
                
                //return credit-p.getPrice();
                
                } 
                catch(IOException e)
                {
                System.out.println(e);  
                }
                //update the cust credit
                //System.out.println(credit);
                //System.out.println(p.getPrice());
                //System.out.println(c);
                //double newcustbalance = ();
                c.setcredit(credit - p.getPrice());
                customers.set(cindex,c);
                
               try {
                FileWriter custfr = new FileWriter("C:\\Users\\Liam\\Downloads\\Customers.txt");
                BufferedWriter br = new BufferedWriter(custfr);
                PrintWriter out = new PrintWriter(br);
                for(Customer cr : customers){
              
                out.println(cr);}
            
                out.close();
                
                
                
                
                return credit-p.getPrice();
                
                } 
                catch(IOException e)
                {
                System.out.println(e);  
                }
             }
         
            else
            { 
        
               throw new VendingException("Insufficient Qty or Credit");  
            }
         }
        }
        System.out.println("No such product - select from available products");
        return credit; 
   }
   

 public boolean reloadProduct(Product p, int addstock)
    { 
      filereaderproducts filereadproducts = new filereaderproducts();
      ArrayList<Product> products = new ArrayList<>();
      products = filereadproducts.getproducts();
      
      
      
      for (int i = 0; i < products.size(); i++)
      { 
         Product prod = products.get(i);
         
         //System.out.println(prod);
         if (prod.equals(p))
         
         {  
            p.addtostock(addstock);
            products.set(i,p);
             
               //System.out.println(p);
               
               //System.out.println(products);
               //write to file with new list
               try {
                FileWriter fr = new FileWriter("C:\\Users\\Liam\\Downloads\\Products.txt");
                BufferedWriter br = new BufferedWriter(fr);
                PrintWriter out = new PrintWriter(br);
                for(Product pr : products){
              
                out.println(pr);}
            
                out.close();
                
                
                
                
                return true;
                
                } 
                catch(IOException e)
                {
                System.out.println(e);  
                }
                

               
             
         }
        }
        System.out.println("No such product - select from available products");
        return false; 
   }  
   
   public boolean addProduct(Product p)
    { 
      filereaderproducts filereadproducts = new filereaderproducts();
      ArrayList<Product> products = new ArrayList<>();
      products = filereadproducts.getproducts();
      
      products.add(p);
      
      try {
                FileWriter fr = new FileWriter("C:\\Users\\Liam\\Downloads\\Products.txt");
                BufferedWriter br = new BufferedWriter(fr);
                PrintWriter out = new PrintWriter(br);
                for(Product pr : products){
              
                out.println(pr);}
            
                out.close();
                
                
                
                
                return true;
                
                } 
                catch(IOException e)
                {
                System.out.println(e);  
                }
      
      
      
      
        System.out.println("No such product - select from available products");
        return false; 
   }  
    //   throw new VendingException("No such product");
   //}

    public boolean removeProduct(Product p)
    {
        filereaderproducts filereadproducts = new filereaderproducts();
        ArrayList<Product> products = new ArrayList<>();
        products = filereadproducts.getproducts();

        products.remove(p);

        try {
            FileWriter fr = new FileWriter("C:\\Users\\Liam\\Downloads\\Products.txt");
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter out = new PrintWriter(br);
            for(Product pr : products){

                out.println(pr);}

            out.close();




            return true;

        }
        catch(IOException e)
        {
            System.out.println(e);
        }




        System.out.println("No such product - select from available products");
        return false;
    }
    //   throw new VendingException("No such product");
    //}




   /**
      Adds a product to the vending machine.
      @param p the product to add
      @param quantity the quantity 
   
    public void addProduct(Product p, int quantity)
   {
      for (int i = 0; i < quantity; i++)
         products.add(p);
   }
   
*/ 
}
