/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gakroppongi
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;

public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        
        MaxHeap mh = new MaxHeap();
        File file = new File ("tale.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        
        //i is the number of words in the txt file 
        //meaning that i is the size of the array
        //this reads in the file using scanner class
        //this one estimates the length of the array
        //however this was unecessary
        int i = 0;
        
        while ((str = br.readLine()) != null)
        {
            String stringArray[] = str.split(" ");
            
            for (int j = 0; j < stringArray.length; j++)
            {
                i++;
            }
        }
        
        
        //this reads in the file using scanner class 
        String StringArray[] = new String[i];
        
        File newFile = new File ("tale.txt");
        Scanner scnr = new Scanner(newFile);
        //BufferedReader newBr = new BufferedReader(new FileReader(newFile));
        String newStr;
        
        int n = 0;
        
        //while ((newStr = newBr.readLine()) != null)
        while(scnr.hasNext())
        {
            //String string[] = newStr.split(" ");
            
            String string = scnr.next();
            StringArray = mh.add(StringArray, string, n);
            //StringArray[n] = string;
            n++;
            
            /*
            for (int m = 0; m < string.length; m++)
            {
                StringArray[n] = string[m];
                n++;
            }
            */
        }
        
        String newStringArray[] = mh.deleteDup(StringArray);
        //int size1 = mh.size(newStringArray);
        //String string[] = mh.arrayReplace(newStringArray);
        //mh.print(newStringArray);
        
        String newString[] = mh.sort(newStringArray);
        //String newString[] = mh.sort(string);
        
        System.out.println("all the unique words are:  \n");
        mh.print(newString);
        //mh.print(newStringArray);
        //mh.print(StringArray);
        //mh.print(string);
        
        int size2 = mh.size(newString);
        //int size2 = mh.size(newStringArray);
        //int size2 = mh.size(StringArray);
        //int size2 = mh.size(string);
        System.out.println("\nthe number of unique words is: "+size2);
        
    }
}
