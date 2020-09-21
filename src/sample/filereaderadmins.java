package sample;
/**
 * Write a description of class Testfilereadtoarray here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;
import java.io.IOException;



public class filereaderadmins
{
    // instance variables - 
   
    ArrayList<Admin>  admins = new ArrayList<Admin>();
    static String filename=null;
    static Scanner sc=new Scanner(System.in);
    static StringBuffer stringBufferOfData = new StringBuffer();

    public filereaderadmins() 
    {
    
    
        
    }
    
    
    
    public ArrayList<Admin> getadmins()  {
    //System.out.println("Please enter your files name and path i.e C:\\test.txt: ");//prompt for file name
    //filename = sc.nextLine();//read in the file name
    String name = "";
    
    
    int password = 0;
    
 try {
         Scanner scanner =
           new Scanner(new File("C:\\Users\\Liam\\Downloads\\Admin.txt"));
         scanner.useDelimiter
           (System.getProperty("line.separator")); 
         while (scanner.hasNext()) {
            String line = scanner.next();
            Scanner input = new Scanner(line);
            input.useDelimiter(",|\n"); 
            name = input.next();
            //System.out.println(name);
            
            //System.out.println(credit);
            password = input.nextInt();
            //int stock = Integer.valueOf(stockstr);
            //System.out.println(password);
            // create a Customer object for the new Customer taken from txt file 
            admins.add(new Admin(name, password));
        
         }
         scanner.close();
       } catch (FileNotFoundException e) {
         e.printStackTrace();
       }
       return admins;
     }   

}    
       
    
/*    
try{    
    Scanner input = new Scanner(new File("C:\\Users\\LiamK\\Admin.txt"));
        
    //Scanner input = new Scanner(new File(".txt"));
    input.useDelimiter("\n|,");

    //ArrayList<Product> products = new ArrayList<Product>();
    while(input.hasNext()) {
        //int id = input.nextInt();
        //String department = input.next();
        name = input.next();
        System.out.println(name);
        
        password = input.nextInt();
        //int stock = Integer.valueOf(stockstr);
        System.out.println(password);
        // create a Customer object for the new Customer taken from txt file 
        admins.add(new Admin(name,  password));
        // 
        
    }
   } catch(IOException e){
 e.printStackTrace();
 
}
    return admins;
    
    
}
}   
    
    
    
    
/*    
    public static void main () {
        System.out.println("Please enter your files name and path i.e C:\\test.txt: ");//prompt for file name
        filename = sc.nextLine();//read in the file name
        Scanner fileToRead = null;
        try {
            fileToRead = new Scanner(new File(filename)); //point the scanner method to a file
            //check if there is a next line and it is not null and then read it in
            for (String line; fileToRead.hasNextLine() && (line = fileToRead.nextLine()) != null; ) {
                //System.out.println(line);//print each line as its read
                stringBufferOfData.append(line).append("\r\n");//this small line here is to append all text read in from the file to a string buffer which will be used to edit the contents of the file
            }
            fileToRead.close();//this is used to release the scanner from file
            //return true;
        } catch (FileNotFoundException ex) {//if the file cannot be found an exception will be thrown
            System.out.println("The file " + filename + " could not be found! " + ex.getMessage());
            //return false;
        } finally {//if an error occurs now we close the file to exit gracefully
            fileToRead.close();
            System.out.println(stringBufferOfData);
            //return true;
        }
}
}
*/    
    
    
  
