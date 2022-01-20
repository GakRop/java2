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
import java.util.Arrays;

public class Driver {

    /*
    this method returns the alphabetical order of the input letter as the hashcode
    */
    public static int hash(String s)
    {
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here

        File file = new File ("inhash.txt");
        Scanner scnr = new Scanner(file);

        //System.out.println("n: "+key('n'));
        //System.out.println("m: "+key('m'));

        /*
        this while loop reads in each word from the input file
         */
        while(scnr.hasNext())
        {
            String str = scnr.next();
            String strArr[] = new String[27];
            System.out.println("word: " + str);

            for (int i = 0; i < str.length(); i++)
            {
                /*
                the read string is sliced into each letter
                then convert back to string datatype because char does not support .isEmpty()
                 */
                char c = str.charAt(i);
                String s = String.valueOf(c);
                int key = hash(s);
                //System.out.println(key+" "+s);
                //System.out.println(i);
                //System.out.println(" ");

                /*
                if the cell in the array corresponding to its alphabetical index
                is not occupied, the letter is inserted in the cell
                 */

                if (strArr[key] == null || strArr[key].isEmpty())
                {
                    strArr[key] = s;
                }
            }
            /*
            if the length of the original word and the number of characters in the array
            is different, all letters are not unique because some of them are thrown away
            because of the duplication in line 143
            if not, all letters are unique
             */
            int size = str.length();
            //System.out.println("this is the size of the string: "+size);

            int uniqueLetters = 0;
            for (int j = 0; j < strArr.length; j++)
            {
                if (strArr[j] != null)
                {
                    uniqueLetters++;
                }
            }
            //System.out.println("this is the number of the unique letters: "+uniqueLetters);

            if (size == uniqueLetters)
            {
                System.out.println("all characters in the string are unique");
            }

            else if (size != uniqueLetters)
            {
                System.out.println("all characters in the string are not unique");
            }

            //print out all unique letter in the alphabetical order
            for (int k = 0; k < strArr.length; k++)
            {
                if (strArr[k] != null)
                {
                    System.out.print(strArr[k]+" ");
                }
            }
            System.out.println("\n");
        }
    }
}