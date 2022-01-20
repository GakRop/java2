/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gakroppongi
 */

//the codes i refered to is listed below

import java.util.*;
import java.io.*;
public class Scanner
{
public static void main(String[] args)throws Exception
{
      
//count the numbers of elements in the input file
File file = new File("lab2in.txt");
//read the file
  
BufferedReader br = new BufferedReader(new FileReader(file));
//read line
  
int size = 0;
  
String st;
//read each line while counting the numbers of elements
while ((st = br.readLine()) != null)
{
    size++;
}
//System.out.println("size: "+size);
  
  
  
//convert the string into double and store in array  
File file_again = new File("lab2in.txt");
//read file again
  
BufferedReader br_again = new BufferedReader(new FileReader(file_again));
//read line again
  
double[] arr;
arr = new double[size];
//initiate the double array
  
String str;
int index = 0;
//store each value in the array
while ((str = br_again.readLine()) != null)
{
    double db = Double.parseDouble(str);
    arr[index] = db;
    index++;
}
Arrays.sort(arr);
//sort the array from min to max
  
int number = 0;
//int line = 0;
double smallest = 100;
double first = 0;
double second = 0;
double def = 0;
double head = 0;
double tail = 0;
//calculate the difference of neighboring two numbers and show the result
while (number != size)
{
    first = arr[number];
    second = arr[number+1];
    def = second - first;
  
    if (smallest > def)
    {
        smallest = def;
        head = first;
        tail = second;
    }
number += 2;
  
}
  
//format the output to 6 decimal places.
double dVal = smallest;
System.out.format("\nThe numbers "+ head +" and "+ tail +
        " are the closest pair with a difference of %.6f.",dVal);
}
  
}
  
// set the array
// read input again
// store double values to array
// sort
// System.out.pirntln(number 1 + number 2 + difference);


// I refered to the code listed below.
/* reference
file reading
https://www.geeksforgeeks.org/different-ways-reading-text-file-java/

string-double conversion
https://www.geeksforgeeks.org/convert-string-to-double-in-java/

array initialization
https://www.geeksforgeeks.org/arrays-in-java/
*/

/* 
the big O notation of the program is Big O(n) 
because we have 3 while loops in parallel.
Not any of the while loop goes inside the other.
Therefore even the input of while loops are n,
the big O notation should be 3n and thus n.
The first while loop that defines
the size of the input file is Big O(n).
The second while loop that puts the input
in the array is Big O(n).
The third while loop that looks for the difference
between two numbers and updates the smallest difference
has input = n/2 because we take two numbers at once
and the loop should go a half of the total input size
is Big O(n).
The overall big o notation is n. 
*/