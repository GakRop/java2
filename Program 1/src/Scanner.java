/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @version 1.0
 * @since 1.0
 */

/**
 *
 * @author gakroppongi
 */
public class Scanner {
    public Node scanner(String str)
    {
        //the received is splited by comma here
        String[] splited = str.split(",");
        
        //assigne the variable name to each element in the line
        String continent = splited[0];
        String country = splited[1];
        String date = splited[2];
        int total_cases = Integer.parseInt(splited[3]);
        int new_cases = Integer.parseInt(splited[4]);
        int population = Integer.parseInt(splited[5]);
        
        //create new node and use the assigned variables as the input
        Node temp = new Node (continent, country, date, total_cases, new_cases, population);
        
        //returns the temp node to the driver class
        return temp;
    }
}

/*
this scanner class just recieves the read line
and assign the variable name to each element
then create a new node
this returns a new node
*/