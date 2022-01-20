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
import java.util.concurrent.*;

public class TreeMapImplementation {
    TreeMap<Integer, Integer> tree_map;
  
    //function to create TreeMap
    public TreeMapImplementation()
    {
        //creating an empty TreeMap
        tree_map = new TreeMap<Integer, Integer>();
    }
    
    //this gets an input from the file reader
    //it splits the string data by space
    //and defines key and val
    //then puts each kay and val in tree_map
    public void insert(String st)
    {
        String[] splited = st.split("\\s+");
        int key = Integer.parseInt(splited[0]);
        int val = Integer.parseInt(splited[1]);
        tree_map.put(key, val);
    }
    
    //this search for a value assiciated with a given input
    //if the symbol table contains the key 
    //it returns teh value associated with the key
    //otherwise it returns 0
    public int search(int key)
    {
        if (tree_map.containsKey(key) == true)
        {
            return tree_map.get(key);
        }
        
        else
            return 0;
    }
    
    //this deletes the key and value pair from the symbol table
    //the pair of a given iput is deleted
    public void delete(int key)
    {
    tree_map.remove(key);
    }
    
    //this iterates through the tree_map and prints the key and value
    //and prints out the key and value
    public void printall()
    {
        for (Map.Entry<Integer, Integer> entry : tree_map.entrySet())
        {
                System.out.println("Key: " + entry.getKey()+ " Value: " + entry.getValue());
        }
    }
       
    //this looks for the minimum value of the tree_map
    //and prints the key-value pair
    public void min()
    {
        System.out.println("\nthe minimum pair is: "+tree_map.firstEntry());
    }
    
    //this looks for the maximum value of the tree_map
    //and prints the key-value pair
    public void max()
    {
        System.out.println("the maximum pair is: "+tree_map.lastEntry());
    }
    
    //this looks for the second minimum value of the tree_map
    //and prints the key-value pair
    public void ceiling()
    {
        System.out.println("the next smallest pair is: "+tree_map.higherEntry(tree_map.firstKey()));
    }
    
    //this looks for the second maximum value of the tree_map
    //and prints the key-value pair
    public void floor()
    {
        System.out.println("the next largest pair is: "+tree_map.lowerEntry(tree_map.lastKey()));
    }
}