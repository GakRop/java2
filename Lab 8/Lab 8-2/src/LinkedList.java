/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//linked list class to insert and get the nodes
public class LinkedList <Key extends Comparable<Key>, Value>{
    private Node first;
    private Node end;

    //node class to declare the nodes
    public class Node
    {
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val)
        {
            this.key = key;
            this.val = val;
        }

        public Node getNext()
        {
            return this.next;
        }

        public void setNext(Node temp)
        {
            this.next = temp;
        }
    }

    LinkedList()
    {
        first = null;
        end = null;
    }

    //this inserts the node in the appropriate place
    //node is inserted after the previous node
    public void insert(Key str, Value order)
    {
        Node temp = new Node(str, order);
        if (first == null)
        {
            first = temp;
            end = temp;
            temp.setNext(null);
        }

        else
        {
            end.setNext(temp);
            end = temp;
        }
    }

    //this looks for the value corresponding to the key
    //which linked list to go is already defined
    // in the get method in separate chaining class
    //looks from the first node to the end node
    //see if the key is equals to the key of the temporary node
    //then returns the value
    public Value get(Key key)
    {
        Node temp = first;
        Value val = null;

        while (temp != null)
        {
            if (key.equals(temp.key))
                val = temp.val;

            temp = temp.getNext();
        }
        return val;
    }
}