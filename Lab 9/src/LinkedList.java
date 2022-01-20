//linked list class to insert and get the nodes
//all information in the graph is technically stored in linked lists
//each linked list has the name of a state as the head,
//which is like a root to its neighboring states
//then the rest of nodes in a lined list stores
//the name of root's neighbors
public class LinkedList {
    private Node first;
    private Node end;

    //node class to declare the nodes
    //each node stores the information of state's name
    //and the address of next node
    public class Node
    {
        private String edge;
        private Node next;

        //this declares a node
        public Node(String edge)
        {
            this.edge = edge;
        }

        //this returns the next node of a node
        public Node getNext()
        {
            return this.next;
        }

        //this sets the next pointer of a node to a given address
        public void setNext(Node temp)
        {
            this.next = temp;
        }

        //this returns the vertex stored in a node
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
    //if the linked list is not empty
    //if empty, the node is put in the linked list
    //and points to null
    public void insert(String edge)
    {
        Node temp = new Node(edge);
        //System.out.println("inserted: "+edge);
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
    prints out the elements in the liked list except for the first node
    by combining all the string information stored in a list
    then returns the information of the states that are neighboring
    to the first state in the linked list
    */
    public String print()
    {
        Node temp = first;
        String states = "";
        temp = temp.getNext();
        while (temp != null)
        {
            states = states + " " +temp.getEdge();
            temp = temp.getNext();
        }
        return states;
    }

    /*
    this returns the data of the state's name stored in a node
    by calling the getEdges method in the node class
     */
    public String getString()
    {
        return first.getEdge();
    }
}