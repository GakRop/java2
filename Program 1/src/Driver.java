/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gakroppongi
 * @version 1.0
 * @since 1.0
 */

// this is for lab 3-2
import java.util.*;
import java.io.*;
public class Driver {

    /**
     * @param args the command line arguments
     */
    
    /*
    this main class only reads in the input file and calls the methods.
    */
    public static void main(String[] args) throws Exception{
        
        File file = new File ("covid_data_world.csv");
  
        BufferedReader br = new BufferedReader(new FileReader(file));
        
        Node largest = null;
        
        //initialize the read line
        String str;
        //throw away the first line read in csv
        br.readLine();
        //creates new linked list and bst
        LinkedList ll = new LinkedList();
        BinarySearchTree bst  = new BinarySearchTree();
        while ((str = br.readLine()) != null)    
        {
            //sends each line to scanner class
            //scanner class gives back a node called temp
            Scanner sc = new Scanner();
            Node temp = sc.scanner(str); 
            
            //call search method
            int num = ll.search(temp);
            
            //if statement to decide if or not to normally insert the node in to ll
            //or to put the minPQ in teh bst and then execeute the normal minPQ insertion
            if (num == 1)
            {
                ll.MinPQ(temp);
            }
            
            else if (num == 0)
            {
                //calls the bst insertion method 
                //then deletes the first 3 nodes in minPQ
                //then put the node in minPQ
                bst.insert(temp.getContinent(), temp.getCountry(), temp.getDate(), temp.getTotalCases(), temp.getNewCases(), temp.getPopulation());
                ll.deleteMin();
                ll.deleteMin();
                ll.deleteMin();
                ll.MinPQ(temp);
            }
            
        }
        
        //calls the inorder printing method
        bst.printInOrder();
        
        
        /*
        this reads in the covid_data_world.csv file
        and creates a new linked list.
        the first line is thrown away
        scanner class is called and the strings are splited by comma
        then the print method is called and the list is printed out.
        */
    }
}