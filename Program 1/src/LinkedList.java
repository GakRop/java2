/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @version 1.0
 * @since 1.0
 */

public class LinkedList {    
    private Node smallest;
    private Node middle;
    private Node largest;
    
    LinkedList()
    {   
        largest = null;
        middle = null;
        smallest = null;
    }
    
    /*
    this class creates linked list for each country
    the data structure is MinQ that stores only the country name, total cases and new cases
    the insertion method searches for the appropriate place to put the current value
    then insert the current value to the appropriate place
    this linked list only creates a linked list for each country
    then it picks up 3 nodes with the largest new nodes to put it in a MinQ of each country
    */
    
    
    /*
    MinPQ method creates MinPQ
    it recieves the node and judge if it has to be in the MinPQ
    or if it is disposed because the number of new cases small
    also if the country names are different, 
    this method calls the binarysearchtree to put data in the tree
    then the nodes are implemented in a new linked list
    */
    
    
    //this class search is the current input node and the nodes in the current minPQ are different or not
    //if different return 0
    //if same return 1
    public int search(Node x)
    {
        if (largest != null)
        {
            if (!x.getCountry().equals(largest.getCountry()))
            {
                return 0;
            }
        
            else 
            {
                return 1;
            }
        }
        
        else 
            return 1;
    }
    
    //this method puts the node in the minPQ
    //the if statements decide where to put the node due to the size
    //and put all the nodes from smallest to largest
    //the size is limited to 3
    public void MinPQ(Node temp)
    {
        if (largest != null)
        {
            if (temp.getCountry().equals(largest.getCountry()))
            {
                if(largest.getNewCases() < temp.getNewCases())
                {
                    smallest = middle;
                    middle = largest;
                    largest = temp;
                }
            }
        }
        
        else if (largest == null && middle == null && smallest == null)
        {
            smallest = temp;
            smallest.setNext(middle);
            //middle.setNext(largest);
            //largest.setNext(null);
        }
        
        else if (largest == null && middle == null && smallest != null)
        {
            if (temp.getNewCases() > smallest.getNewCases())
            {
                middle = temp;
                smallest.setNext(middle);
                middle.setNext(largest);
                //largest.setNext(null);
            }
            
            else if (temp.getNewCases() < smallest.getNewCases())
            {
                middle = smallest;
                smallest = temp;
               smallest.setNext(middle);
                middle.setNext(largest);
                //largest.setNext(null);
            }
        }
        
        else if (largest == null && middle != null && smallest != null)
        {
            if (temp.getNewCases() < smallest.getNewCases())
            {
                largest = middle;
                middle = smallest;
                smallest = temp;
                smallest.setNext(middle);
                middle.setNext(largest);
                largest.setNext(null);
            }
            
            else if (temp.getNewCases() > smallest.getNewCases())
            {
                if (temp.getNewCases() < middle.getNewCases())
                {
                    largest = middle;
                    middle = temp;
                    smallest.setNext(middle);
                    middle.setNext(largest);
                    largest.setNext(null);
                }
                
                else if (temp.getNewCases() > middle.getNewCases())
                {
                    largest = temp;
                    smallest.setNext(middle);
                    middle.setNext(largest);
                    largest.setNext(null);
                }
            }
        }
    }
    
    /*
    this investigates the size of the linkedlist
    this helps the MinPQ method to choose its action
    if the linkedlist is longer than 3, 
    MinPQ has to think whether or not to put the node in the list
    if not, the node is put in an appropriate position
    */
    
    //this size method was used when the program was coded
    //but this is not used in the final product
    //however this returns the size of the linked list
    public int size()
    {
        //System.out.println("size is called");
        Node temp = smallest;
        int size = 0;
        
        while (temp != null)
        {   
            size++;
            temp = temp.getNext();
        }
        //System.out.println(size);
        return size;
    }
    
    //this method prints out the nodes in linked list
    public void print()
    {
        Node temp = smallest;
        
        while (temp != null)
        {
            System.out.println(temp.getCountry() + temp.getNewCases());
            temp = temp.getNext();
        }
    }
    
    //this method deletes the minimum node in the linked list
    //the smallest node is determined by the bunch of if statements
    //and the smallest node is deleted
    public void deleteMin()
    {
        Node temp = null;
        
        if (smallest != null)
            temp = smallest;
        
        else if(smallest == null && middle != null)
            temp = middle;
        
        else if (smallest == null && middle == null && largest != null)
            temp = largest;
        
        temp.setNext(temp);
        temp = null;
    }
}