/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gakroppongi
 */
//this is for lab 3-1
import java.util.*;
import java.io.*;
public class Driver
{
    public static void main(String[] args)throws Exception
    {
        //creates a new tree_map
        TreeMapImplementation tree_map = new TreeMapImplementation();
        
        //read the input file
        File file = new File("lab3in.txt");
  
        BufferedReader br = new BufferedReader(new FileReader(file));
        //read line
        
        
        //sends the read line to the tree_map
        String st;
        while ((st = br.readLine()) != null)
            {                
                tree_map.insert(st);
            }
        
        //defines the key to be searched
        //calls the search method and returns the corresponding value if found
        //if not found, 0 is returned
        int key = 5;
        int val = tree_map.search(key);
        
        //0 is returned it prints out key is not found
        //otherwise it prints out the key and the value
        if (val != 0)
        {
            System.out.println("Key "+key+" is found and its value is: "+val+"\n");
            tree_map.delete(key);
        }
        
        else
        {
            System.out.println("Key "+key+" is not found.\n");
        }
        
        //printing out the nodes after deletion is done
        System.out.println("the tree_map after "+key+" deleted is: \n");
        tree_map.printall();
        
        //min, max, next smallest, next largest values are searched and printed out.
        tree_map.min();
        tree_map.max();
        tree_map.ceiling();
        tree_map.floor();
    }
}