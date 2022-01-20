/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// I took the original code from CSCI132 and modified it

public class Node {
    private String data;
    private Node next;
    //define the elements of node
    
    public Node(String data)
    { 
        this.data = data;
        //define the property
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
    
    public String getData()
    {
        return this.data;
        //define the getData method
    }
}