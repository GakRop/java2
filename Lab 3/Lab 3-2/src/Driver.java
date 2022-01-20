/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gakroppongi
 */

// this is for lab 3-2
import java.util.*;
import java.io.*;
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        
        //read the input file
        File file = new File("lab3in.txt");
  
        BufferedReader br = new BufferedReader(new FileReader(file));
        
        //create new linked list
        LinkedList ll = new LinkedList();
        
        String st;
        while ((st = br.readLine()) != null)    
        {
            //insert the read line in the linked list
            ll.put(st);
        }
        
        //defines the key to look for in the list
        //and call the method to search for the corresponding value
        //prints out key is not found if key is not in the list
        //prints out key is found and its value is something if key is found
        //then delete the node by delete() method
        int key = 5;
        int search = ll.get(key);
        
        if (search == 0)
        {
            System.out.println("Key is not found\n");
        }
        
        else
        {
            System.out.println("Key is found and its value is: "+search+"\n");
            ll.delete(key);  
        } 
        
        //look for the min, max, next smallest, and next largest values and print them out
        int min = ll.min();
        int max = ll.max();
        ll.ceiling(min);
        ll.floor(max);
        
        //ll.print();
    }
}

/*
Key is found and its value is: 560
Key: 1 Value: 108
Key: 60 Value: 6051
Key: 15 Value: 1510
Key: 22 Value: 2220
Key: 23 Value: 2330
Key: 75 Value: 7510
Key: 67 Value: 6710
Key: 4 Value: 420
Key: 65 Value: 6505
Key: 12 Value: 1202
Key: 11 Value: 1103
Key: 8 Value: 807
Key: 7 Value: 708
the minimum pair is: 1, 108
the maximum pair is: 75, 7510
the minimum pair is: 0, 6710
the maximum pair is: 0, 420

Key 5 is found and its value is: 560

the tree_map after 5 deleted is: 

[1, 108]
[4, 420]
[7, 708]
[8, 807]
[11, 1103]
[12, 1202]
[15, 1510]
[22, 2220]
[23, 2330]
[60, 6051]
[65, 6505]
[67, 6710]
[75, 7510]

the minimum pair is: 1=108
the maximum pair is: 75=7510
the next smallest pair is: 4=420
the next largest pair is: 67=6710
*/