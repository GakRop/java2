/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// the source code was taken from Lab 1

public class Node {
    private int key;
    private int value;
    private Node next;
    //define the elements of node
    //since this is a symbol table we need to have key and value elements
    
    public Node(Integer key, Integer value)
    { 
        this.key = key;
        this.value = value;
        //define the property
        //since this is a symbol table we need to define the propertry
        //of two elements inside a node
    }
    
    public void setNext(Node temp) 
    {
        this.next = temp;
        //define the setNext method
    }
    
    public Node getNext()
    {
        return this.next;
        //define the getNext method
    }
    
    public Integer getValue()
    {
        return this.value;
        //define the getValue method
        //this returns the value in the node
    }
    
    public Integer getKey()
    {
        return this.key;
        //define the getKey method
        //this returns the key in the node
    }
    
    public void setValue(Integer value)
    {
        this.value = value;
        //define the setValue method
        //this updates the value in a node to the input value
    }
}