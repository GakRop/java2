/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gakroppongi
 */
import java.util.*;

//Key is the alphabetical order of the string
//and the Value is the actual string
public class MaxHeap{
    
    public String[] deleteDup(String string[])
    {
        /*
        the word at index i is compared to the word at index j
        if they are the same, j is replaced with null
        if they are not, they are beheld there
        then eventually the j reaches the end, 
        the i moves to the next index
        when i reaches the end, all the duplicated words are replaced with null
        after that, new array is created and words are put in the list
        if they are not null
        */
        for (int i = 0; i < string.length; i++)
        {
            if (string[i] == null)
            {
                string[i] = " ";
            }
            
            else
            {
                for (int j = i + 1; j < string.length; j++)
                {
                    if (string[i].equals(string[j]))
                    {
                        string[i] = " ";
                    }
                }
            }
        }
        
        //reads the values in the old array
        //if the index is not null, put the value in the new array
        //if null, skip it and proceeds to the next idex of the old array
        //the unsorted array of the old array without null 
        //should be returned as newString
        String newString[] = new String[string.length];
        int m = 0;
        
        for (int n = 0; n < string.length; n++)
        {
            if (string[n] != " ")
            {
                //System.out.println("here");
                newString[m] = string[n];
                m++;
            }
        }
        
        return newString;
    }
    
    //print out all the elements other than null
    public void print(String string[])
    {
        int i = 0;
        while (//string[i] != null
                i<string.length+1)
        {
            if(string[i] != null)
            {
                System.out.println(string[i]);
                i++;
            }
            
            if(string[i] == null)
                return;
        }
    }
        
    //returns the size of the array
    //the size of the array is defined as the beginning 
    //to the last index that hits null
    //current size is 10675
    //the correct size is 10674
    //+1 size is because of the space after "comparison"
    public int size(String string[])
    {
        int i = 0;
        int size = 0;
        
        while (string[i] != null)
        {
            size++;
            i++;
        }
        
        return size;
    }
    
    /*
    this is a max heap sort method
    the largest element by StringA.compareTo(StringB)
    goes to the root (int root = (index of the children)/2) of the children
    Starting at the last index of the array, compare to its root.
    If the children is larger than the parent, swap them.
    Compare it to its parent again and make sure it is smaller than its root.
    If it is larger, swap it again.
    Continue this until either it reaches to the index 0,
    or the case where the child is smaller than the parent.
    */
    public String[] sort(String[] pq)
    {
        //System.out.println("this is being sorted: "+pq[k]);
        int n = size(pq);
        //System.out.println("this is n: "+pq[n-1]);
        
        for (int k = n/2; k>= 1; k--)
        {
            //System.out.println("this is being sorted: "+pq[k]);
            sink(pq, k, n);
        }
        
        int k = n;
        while (k > 1)
        {
            exch(pq, 1, k--);
            sink(pq, 1, k);
        }
        
        return pq;
    }
    
    /*
    this is a sink method 
    if the parent is smaller than the children
    the parents will go down the tree
    */
    private void sink(String[] pq, int k, int n) 
    {
        while (2*k <= n) {
            int j = 2*k;
            
            if (j < n && less(pq, j, j+1)) 
                j++;
            
            if (!less(pq, k, j))
                break;
            
            exch(pq, k, j);
            k = j;
        }
    }
    
    /*
    this estimates the size of elements
    */
    private boolean less(String[] pq, int i, int j) 
    {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }
    
    /*
    exchange or swap the elements being compared now
    */
    private void exch(String[] pq, int i, int j) 
    {
        String swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }
    
    /*
    adds the elements if the read word from the scanner is not null
    */
    public String[] add(String [] pq, String string, int n)
    {
        if (string != null)
        {
            pq[n] = string;
        }
        
        return pq;
    }
    
    /*
    this is not used
    */
    public String[] arrayReplace(String pq[])
    {
        int size = sizeWithoutSpace(pq);
        String newArray[] = new String[size];
        int j = 0;
        
        for (int i = 0; i < pq.length; i++)
        {
            if (pq[i] != null)
            {
                pq[i] = newArray[j];
                j++;
            }
        }
        return newArray;
    }
    
    public int sizeWithoutSpace (String[] pq)
    {
        int size = 0;
        for (int i = 0; i < pq.length; i++)
        {
            if (!pq[i].equals(" "))
            {
                size++;
            }
        }
        return size;
    }
}