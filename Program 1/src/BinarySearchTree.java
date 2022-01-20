/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gakroppongi
 */
import java.util.NoSuchElementException;
public class BinarySearchTree {
    
    public Node root;
    
    private class Node 
    {
        //defines the elemests in the node in the binary search tree
        //and create the left and rightchild nodes
        private int new_cases;
        private String continent;
        private String country;
        private String date;
        private int total_cases;
        private int population;
        private Node left;
        private Node right;
        
        private Node (String continent, String country, String date, int total_cases, int new_cases, int population)
        {
            //assign the input value to each variable
            this.continent = continent;
            this.country = country;
            this.date = date;
            this.total_cases = total_cases;
            this.new_cases = new_cases;
            this.population = population;
        }
        
        public Integer getNewCases()
        {            
            return this.new_cases;
        }
    }
    
    public BinarySearchTree ()
    {
        // the root is defined as null as the default value
        root = null;
    }
    
    //this method is called by outside of the class
    //then calls the other insert method in the class by giving the input values
    public void insert(String continent, String country, String date, int total_cases, int new_cases, int population)
    {
        this.root = insert(this.root, continent, country, date, total_cases, new_cases, population);
    }
    
    //this method inserts nodes in the binary search tree
    private Node insert(Node x, String continent, String country, String date, int total_cases, int new_cases, int population)
    {
        //if it reaches the null node,
        //the new node is created and node is put there
        if (x == null)
        {
            x = new Node (continent, country, date, total_cases, new_cases, population);
            return x;
        }
        
        //if the key is the same value as a node
        //nothing happens
        if (new_cases == x.getNewCases())
        {
            
        }
        
        //if the key is smaller than the root,
        //it goes down the leftchild of the root
        else if (new_cases < x.getNewCases())
        {
            
            x.left = insert(x.left, continent, country, date, total_cases, new_cases, population);
        }
        
        //if the key is not smallest than the root nor equals to the root,
        //it goes down the rightchild of the root
        else
        {
            x.right =  insert(x.right, continent, country, date, total_cases, new_cases, population);
        }
        
        return x;
    }
    
    //this method is called from outside of the function
    //this calls the other printing method and gives the input
    public void printInOrder()
    {
        printInOrder(root);
    }
    
    //this is an inorder printing method
    //if the node is null, return nothing
    //this prints out the leftchild of a root deepest in the bst
    //then prints out its root,
    //then prints out its rightchild
    public void printInOrder(Node x)
    {
        if (x == null)
        {
            return;
        }
        
        printInOrder(x.left);
        System.out.println("New Cases: "+x.new_cases+" at "+x.country+"/"+x.continent+
                " on "+x.date+" Total: "+x.total_cases+", Pop: "+x.population);
        printInOrder(x.right);
    }
}