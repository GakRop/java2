 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gak
 */

// I took the original code from CSCI132 and modified it

public class DriverClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Stack st = new Stack();
       //call the Stack class
       
       // to be $ or not $ $ to be that is the question $ $ $
       
       st.Push("to");
       st.Push("be");
       st.Push("$");
       st.Push("or");
       st.Push("not");
       st.Push("$");
       st.Push("$");
       st.Push("to");
       st.Push("be");
       st.Push("that");
       st.Push("is");
       st.Push("the");
       st.Push("question");
       st.Push("$");
       st.Push("$");
       st.Push("$");
       //called the Stack() method to create a node with a string in it
       
       st.Print();
       //called the Print() method
    }
    
}