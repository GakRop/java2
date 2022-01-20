/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Stack {    
    private Node first;
    private Node end;
    //created the two nodes, first and end
    
    Stack()
    {
        first = null; 
        end = null;
        //set the default value of the two created nodes
    }

    public void Push(String str){
        //defined the method
        Node temp  = new Node(str);
        //created the node that is going to be added in a stack
        if (str == "$")
            Pop();
        //check if the string is $ or not. if it is $, call Pop()
        
        else if (first == null)
            //defined the if statement to add the first node to the stack
        {
        first = temp;
        //defined the temp as first
        temp.setNext(null);
        end = temp;
        //make this first added node point null
        //and update the "end" node
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
    
    public void Pop()
    {
        Node temp = first.getNext();
        
        System.out.println("'"+first.getData()+"'"+" is deleted");
        
        first.setNext(null);
        first = temp;
    }
       
    public void Print()
    //defined the method
    {
        Node temp = first;
        //name the first node as temp
        System.out.println("\nthese\n");
        while(temp != null)
        //set the loop condition
        {
        System.out.println(temp.getData());
        temp = temp.getNext();
        //print out the elements that is top on the stack
        //and update the temp node
        }
        
        System.out.println("\nremain in the list");
    }
}