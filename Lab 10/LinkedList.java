import java.util.ArrayList;

//linked list class to insert and get the nodes
public class LinkedList {
    private Node first;
    private Node end;

    //node class to declare the nodes
    public class Node
    {
        private String edge;
        private Node next;
        private int label;
        private boolean marked;

        public Node(String edge, boolean marked)
        {
            this.edge = edge;
        }

        public Node getNext()
        {
            return this.next;
        }

        public void setNext(Node temp)
        {
            this.next = temp;
        }

        public String getEdge()
        {
            return this.edge;
        }
    }

    LinkedList()
    {
        first = null;
        end = null;
    }

    //this inserts the node in the appropriate place
    //node is inserted after the previous node
    public void insert(String edge)
    {
        Node temp = new Node(edge, false);
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

    /*
    prints out the elements in the liked list
    connects all the string elements in the linked list
    to return the string to print it out
     */
    public String print()
    {
        Node temp = first;
        String states = temp.getEdge()+":";
        temp = temp.getNext();
        while (temp != null)
        {
            states = states + " " +temp.getEdge();
            temp = temp.getNext();
        }
        return states;
    }

    /*
    return the string inside a node in a linked list
     */
    public String getString()
    {
        return first.getEdge();
    }

    public ArrayList traverse()
    {
        ArrayList arr = new ArrayList();
        //Node temp = first.getNext();
        Node temp = first;
        while (temp != null)
        {
            arr.add(temp.getEdge());
            temp = temp.getNext();
        }
        return arr;
    }
}