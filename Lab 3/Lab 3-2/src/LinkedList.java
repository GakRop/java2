/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// the source code was taken from Lab 1

public class LinkedList {    
    private Node first;
    private Node end;
    private Node now;
    //created three nodes, first, end, and now
    
    LinkedList()
    {
        first = null; 
        end = null;
        now = null;
        //set the default value of the three created nodes
    }

    //node insertion method in a linked list
    //a new node is inserted at the end of the list
    public void put(String st){
        //since the read line contains two strings with a space
        //i splited it with space and define them as key and val
        String[] splited = st.split("\\s+");
        int key = Integer.parseInt(splited[0]);
        int val = Integer.parseInt(splited[1]);
                                
        //create a new node
        Node temp = new Node (key, val);
        
        //search the linked list if we can find the same key
        //if the same key is not found jsut add the new node at the end
        //if found, update the value of the node by .setValue() method
        int search = get(key);
        
        if (search == 0)
        {                   
            if (first == null)
            {
                temp.setNext(null);
                first = temp;
                end = temp;
            }
        
            else
            {
                end.setNext(temp);
                temp.setNext(null);
                end = temp;
            }
        }
        
        else if (search != 0)
        {
            now.setValue(val);
        }
    }
    
    //search for the value that is corresponding to a given key in a linked list
    //search through the list
    //if it finds the node with the given key, it returns the corresponding value
    //if not, it returns 0
    public int get(int key)
    {
        Node temp = first;
        while (temp != null)
        {
            if (temp.getKey() == key)
            {
                now = temp;
                return now.getValue();
            }
            
            temp = temp.getNext();
        }
        
        return 0;
    }
    
    //search for the key that is corresponding to a given value in a linked list
    //search through the list
    //if it finds the node with the given value, it returns the corresponding key
    //if not, it returns 0
    public int getKey(int val)
    {
        Node temp = first;
        while (temp != null)
        {
            if (temp.getValue() == val)
            {
                now = temp;
                return now.getKey();
            }
            
            temp = temp.getNext();
        }
        
        return 0;
    }
    
    
    //delete the node containing a given key
    //it first search through the list to look for the given key
    //if found, it deletes the node, then it prints out the entire list
    public void delete(int key)
    {
        Node temp = first;
        
        while (temp != null)
        {
            if (temp.getKey() == key)
            {
                if (temp == first)
                {
                    first = temp.getNext();
                    temp.setNext(null);                    
                }
                
                else 
                {
                    Node prev = first;
                    while (prev.getNext() != temp)
                    {
                        prev = prev.getNext();
                    }
                    prev.setNext(temp.getNext());
                    temp.setNext(temp);
                }
            }            
            temp = temp.getNext();
        }       
        
        print();
    }   
    
    //this prints out the elements in the nodes in the list
    public void print()
    {
        Node temp = first;
        while(temp != null)
        {
            System.out.println("Key: "+temp.getKey()+" Value: "+temp.getValue());
            temp = temp.getNext();
        }
    }
    
    //this looks for the smallest value in the list
    //the minimum value is set at 99999999 as default
    //if it finds the value smaller than the default minimum value,
    //it updates the minimum value, prints out the min value its key
    //then return the min value
    public int min()
    {
        Node temp = first;
        int min  = 99999999;
        int key = 0;
        while(temp != null)
        {
            if (temp.getValue() < min)
            {
                min = temp.getValue();
                key = temp.getKey();
            }
            temp = temp.getNext();
        }
        
        System.out.println("\nthe minimum pair is: "+key+", "+min);
        return min;
    }
    
    //this looks for the largest value in the list
    //the max value is set at 0 as default
    //if it finds the value larger than the default max value,
    //it updates the max value, prints out the max value its key
    //then return the max value
    public int max()
    {
        Node temp = first;
        int max  = 0;
        int key = 0;
        while(temp != null)
        {
            if (temp.getValue() > max)
            {
                max = temp.getValue();
                key = temp.getKey();
            }
            temp = temp.getNext();
        }
        
        System.out.println("\nthe maximum pair is: "+key+", "+max);
        return max;
    }    
    
    //this looks for the next smallest value in the list
    //this method gets an input of the smallest value in the list
    //this looks for the value larger than the input min value 
    //however this value should be smaller than 99999
    //the min in this case is 108.
    //the nextSmallest in this case is 99999 at default
    //this looks for 108 < smallest value < 99999
    //then this prints out the key value pair
    public void ceiling(int min)
    {
        Node temp = first;
        int nextSmallest = 99999;
        while(temp != null)
        {
            if (temp.getValue() > min && temp.getValue() < nextSmallest)
            {
                nextSmallest = temp.getValue();
            }
            temp = temp.getNext();
        }
        
        int key = getKey(nextSmallest);
        System.out.println("\nthe next smallest pair is: "+key+", "+nextSmallest);
    }
    
    //this looks for the next largest value in the list
    //this method gets an input of the largest value in the list
    //this looks for the value smaller than the input max value 
    //however this value should be larger than 0
    //the max in this case is 7510.
    //the nextLargest in this case is 0 at default
    //this looks for 0 < laergest value < 7510
    //then this prints out the key value pair
    public void floor(int max)
    { 
        Node temp = first;
        int nextSmallest = 0;
        while(temp != null)
        {
            if (temp.getValue() < max && temp.getValue() > nextSmallest)
            {
                nextSmallest = temp.getValue();
            }
            temp = temp.getNext();
        }
        
        int key = getKey(nextSmallest);
        System.out.println("\nthe next largest pair is: "+key+", "+nextSmallest);
    }
}