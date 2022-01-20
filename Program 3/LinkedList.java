/*
@author Gak Roppongi
this linkedlist class was taken from the lab 9 work
linked list class to insert and get the nodes
all information in the graph is technically stored in linked lists
each linked list stores the sequence of
*/

import java.util.ArrayList;

public class LinkedList {
    private Node first;
    private Node end;
    private Node LIS;

    //node class to declare the nodes
    //each node stores the information of state's name
    //and the address of next node
    public class Node {
        private int vertex;
        private Node next;

        //this declares a node
        public Node(int vertex) {
            this.vertex = vertex;
        }

        //this returns the next node of a node
        public Node getNext() {
            return this.next;
        }

        //this sets the next pointer of a node to a given address
        public void setNext(Node temp) {
            this.next = temp;
        }

        //this returns the vertex stored in a node
        public int getVertex() {
            return this.vertex;
        }
    }

    public LinkedList()
    {
        first = null;
        end = null;
        LIS = null;
    }

    //this inserts the node in the appropriate place
    //node is inserted after the previous node
    //if the linked list is not empty
    //if empty, the node is put in the linked list
    //and points to null
    public void insert(int vertex) {
        Node temp = new Node(vertex);

        if (first == null)
        {
            first = temp;
            end = temp;
            LIS = temp;
            temp.setNext(null);
        }

        else
        {
            end.setNext(temp);
            end = temp;
        }
    }

    /*
    prints out the elements in the liked list except for the first node
    by combining all the string information stored in a list
    then returns the information of the states that are neighboring
    to the first state in the linked list
    */
    public int length() {
        int length = 0;
        return length;
    }

    /*
    this returns the data of the state's name stored in a node
    by calling the getEdges method in the node class
     */
    public int getVertex() {
        return first.getVertex();
    }

    public void print()
    {
        Node temp = first.getNext();
        while (temp != null)
        {
            System.out.println(first.getVertex() + "-> "+ temp.getVertex());
            temp = temp.getNext();
        }
    }

    /*
    this method is called in LIS method in graph class
    it traverse through the linked list and puts everything in an integer array
    then calls the LIS method in LIS class by passing the integer array
    then this method returns the max length of the integer array
     */
    public int FLP()
    {
        Node temp = first;
        int size = size();
        int arr[] = new int [size];

        for (int i = 0; i < size; i++)
        {
            arr[i] = temp.getVertex();
            temp = temp.getNext();
        }

        LIS lis = new LIS();
        int length = lis.lis(arr, size);
        return length;
    }

    /*
    this method calculates the length of the linked list
     */
    public int size()
    {
        Node temp = first;
        int size = 0;
        while (temp != null)
        {
            size++;
            temp = temp.getNext();
        }

        //System.out.println("size: "+size);
        return size;
    }
}