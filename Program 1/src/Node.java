/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @version 1.0
 * @since 1.0
 */

// the source code was taken from Lab 3
/*
this creates the nodes
and defines some node classes
*/

//defines the variables in the node in linked list
public class Node {
    private String continent;
    private String country;
    private String date;
    private Integer total_cases;
    private Integer new_cases;
    private Integer population;
    private Node next;
    
    public Node(String continent, String country, String date, int total_cases, int new_cases, int population)
    { 
        //assign the input values to the values in the node
        this.continent = continent;
        this.country = country;
        this.date = date;
        this.total_cases = total_cases;
        this.new_cases = new_cases;
        this.population = population;
    }
    
    //set the next pointer of node to input node
    public void setNext(Node temp) 
    {
        this.next = temp;
    }
    
    //get the content of a node next to a node
    public Node getNext()
    {
        return this.next;
    }
    
    //get the information of a node
    public String getContinent()
    {
        return this.continent;
    }
    
    //get the information of a node
    public String getCountry()
    {
        return this.country;
    }
    
    //get the information of a node
    public String getDate()
    {
        return this.date;
    }
    
    //get the information of a node
    public Integer getTotalCases()
    {
        return this.total_cases;
    }
    
    //get the information of a node
    public Integer getNewCases()
    {
        return this.new_cases;
    }
    
    //get the information of a node
    public Integer getPopulation()
    {
        return this.population;
    }
}