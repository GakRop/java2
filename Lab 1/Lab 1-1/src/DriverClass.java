 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class DriverClass {

    /**
     * @param args the command line arguments
     */
    
    // I took the original code from CSCI132 and modified it
    
    public static void main(String[] args) {
       LinkedList ll = new LinkedList();
       //call the LinkedList class
       
       ll.Insert("A");
       ll.Insert("A");      
       ll.Insert("A");
       ll.Insert("A");   
       ll.Insert("A");
       ll.Insert("A");
       System.out.println("insert is done");
       //called the Insert() method to create a node with a string in it
       
       
       ll.Print();
       //called the Print() method
       
       ll.DeleteDup();
       //called the DeleteDup() method
              
       System.out.println("\nPrint after DeleteDup");
       ll.Print();
       //called the Print() method again to see the remained elements in the LinkedList
    }
    
}