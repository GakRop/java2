/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// I took the original code from CSCI132 and modified it

public class LinkedList {    
    private Node first;
    private Node end;
    //created the two nodes, first and end
    
    LinkedList()
    {
        first = null; 
        end = null;
        //set the default value of the two created nodes
    }

    public void Insert(String str){
        //define the method
        Node temp  = new Node(str);
        //created the node that is going to be added in a list
        if (first == null)
        //defined the if statement to add the first node to the list
        {
        first = temp;
        //defined the temp as first
        temp.setNext(end);
        //make temp point to end and end is going to be the last element of the list
        }
        
        else
        //defined the else statement to add nodes other than the first node
        {
        temp.setNext(first);
        //make temp node point the previously added node
        first = temp;
        //update the "previously added node"
        }
        //this insert method shows that I added the elements behind the previously added node like a stack
    }
    
    public void DeleteDup()
    //defined the method
    {
        Node temp = first;
        //defined the top of the node in the stack as first
        
        while (temp.getNext() != end)
        //defined the loop condition
        {
            Node prev = temp;
            //difined a new variable name for temp node as prev
            
            while (prev.getNext() != null)
            //defined the loop condition
            {
                
                if (temp.getData() == prev.getNext().getData())
                //check to see if the temp node and the prev.getNext() contain the same string data
                {
                Node deleted = prev;
                deleted = prev.getNext();
                //defined a new varibale name "deleted" and set it as the get.Next() which was compared in the if statement above in line 61
                Node next = deleted;
                next = deleted.getNext();
                //defined a new varibale name "next" and set it as the deleted.getNext(). this node is connected to the prev node
                prev.setNext(next);
                deleted.setNext(null);
                //make prev node point the next node to go around the "deleted" (depulication) node
                //and make deleted point null to remove this node from the list
                }
                
                if (prev.getNext() != null)
                //defined the if statement to check the next node of the prev not to be null
                //because if the prev.getNext() is null, prev is set null in line 80 and the while loop condition is not properly executed
                {
                prev = prev.getNext();   
                //update the prev node
                }
            }
        if (prev.getNext() != null)  
        //defined the if statement to check the next node of the temp not to be null
        //because if the temp.getNext() is null, temp is set null in line 88 and the while loop condition is not properly executed
        {
        temp = temp.getNext();
        //update the temp node
        }
        }
        System.out.println("deletedup is done");
    }
       
    public void Print()
    //defined the method
    {
        Node temp = first;
        //name the first node as temp
        while(temp != null)
        //set the loop condition
        {
        System.out.println(temp.getData());
        temp = temp.getNext();
        //print out the elements that is top on the stack
        //and update the temp node
        }
        System.out.println("print is done");
    }
}