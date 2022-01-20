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
import java.io.*;

public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here   
        
        //file is read and bufferedreader is called 
        //to read each line in the text file
        File file = new File ("inrbt.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        
        //RedBlackTree is called here
        
        RedBlackTree rbt = new RedBlackTree();
        
        //this while loop reads each line and split the strings by comma
        //since the semi-colon is not wanted here, it is replaced with nothing
        //if the input is int without any default value,
        //the loop calls the key() function 
        //in the bottom assign the alphabetical order
        //and set the default value as 0
        //if the input is float without any default value,
        //the loop calls the key() function 
        //in the bottom assign the alphabetical order
        //and set the default value as 0.0
        //then the alphabetical order, data type, data name, 
        //and the default value are passed to the put function 
        
        while((str = br.readLine()) != null)
        {
            str = str.replaceAll(";", "");  
            String splited[] = str.split(" ");
            String var;
            int key;
            String type = splited[0];
            String val;
            
            if (type.equals("int"))
            {
                var = splited[1];
                key = key(var);
                val = "0";
                rbt.put(var, key, type, val);
            }
            
            else if (type.equals("float"))
            {
                var = splited[1];
                key = key(var);
                val = "0.0";
                rbt.put(var, key, type, val);
            }
            
            else 
            {
                var = splited[0];
                val = splited[2];
                rbt.update(var, val);
            }
                
        }
        
        //this calls the keys() function and recieves Queue named queue
        Queue queue = rbt.keys();
        
        //this iterates through the queue and calls the get fuction
        //by passing the key
        for (Object item: queue) {
            rbt.get(item.toString());
        }
        
    }
    
    public static int key(String str)
    {
        for (int i = 0;i < str.length(); i++)
        {
            
        }   
        
        char c = str.charAt(0);
        String s = String.valueOf(c);
        
        if (s.equals("a"))
            return 1;
        
        else if (s.equals("b"))
            return 2;
        
        else if (s.equals("c"))
            return 3;
        
        else if (s.equals("d"))
            return 4;
        
        else if (s.equals("e"))
            return 5;
        
        else if (s.equals("f"))
            return 6;
        else if (s.equals("g"))
            return 7;
            
        else if (s.equals("h"))
            return 8;
        
        else if (s.equals("i"))
            return 9;
        
        else if (s.equals("j"))
            return 10;
        
        else if (s.equals("k"))
            return 11;
        
        else if (s.equals("l"))
            return 12;
        
        else if (s.equals("m"))
            return 13;
        
        else if (s.equals("n"))
            return 14;
        
        else if (s.equals("o"))
            return 15;
        
        else if (s.equals("p"))
            return 16;
        
        else if (s.equals("q"))
            return 17;
        
        else if (s.equals("r"))
            return 18;
        
        else if (s.equals("s"))
            return 19;
        
        else if (s.equals("t"))
            return 20;
        
        else if (s.equals("u"))
            return 21;
        
        else if (s.equals("v"))
            return 22;
        
        else if (s.equals("w"))
            return 23;
        
        else if (s.equals("x"))
            return 24;
        
        else if (s.equals("y"))
            return 25;
        
        else
            return 26;
    }
}

/*
Sample output

Key datatype value Nodetype
Key Value Value Value

rfl float 5.5 Black
sfl float 6.5 Red
tfl float 0.0 Red
xvar int 5 Black
yvar int 7 Black
zvar int 0 Black


Input

int xvar;
int yvar;
int zvar;
float rfl;
float sfl;
float tfl;
xvar = 5;
yvar = 7;
rfl = 5.5;
sfl = 6.5;

*/