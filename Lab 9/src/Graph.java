import java.util.ArrayList;

//I wrote the entire graph structure by myself
//the graph class to store the vertex and edge data
//reads in the file and store the vertex in the arraylist
//when adding the edge, the program first looks for
//the linked list named with its connected vertex
//then elongate the linked list to store the edge to its vertex
//the Node class is created to accommodate the edge

public class Graph{
    //int M is the number of vertex that is written in the input file
    //arrayList stores the actual graph data
    //and the array store the data of root vertex that has already been added to the graph
    int M;
    ArrayList<LinkedList> arrayList = new ArrayList<LinkedList>(M);
    ArrayList<String> array = new ArrayList<String>(M);

    //node class to declare the nodes/
    //each node stores the vertex name in string data type
    //and the address of the next node
    public class Node
    {
        private String vertex;
        private Node next;

        public Node(String vertex)
        {
            this.vertex = vertex;
        }
    }

    //this function looks into array to see if the linked list
    //with the vertex name already exists or it is a new linked list
    //if the input is the first data that is processed in the graph
    //they are added no matter what they are because there is nothing to compare
    //if the vertex of the input does not exist in the graph as a linked list
    //this adds a new linked list and the head of the list is the new vertex
    //if the linked list with the same name as the vertex exists
    //then this only adds the edge of the input
    public void initiateLinkedList (String vertex, String edge)
    {
        if (array.isEmpty())
        {
            addVertex(vertex);
            addEdge(vertex, edge);
            array.add(vertex);
        }

        else if (array.contains(vertex))
        {
            addEdge(vertex, edge);
        }

        else
        {
            addVertex(vertex);
            addEdge(vertex, edge);
            array.add(vertex);
        }
    }

    /*
    //initiate the linked lists for each arraylist element
    LinkedList alabama = new LinkedList();
    LinkedList arizona = new LinkedList();
    LinkedList arkansas = new LinkedList();
    LinkedList california = new LinkedList();
    LinkedList colorado = new LinkedList();
    LinkedList delaware = new LinkedList();
    LinkedList florida = new LinkedList();
    LinkedList georgia = new LinkedList();
    LinkedList idaho = new LinkedList();
    LinkedList illinois = new LinkedList();
    LinkedList indiana = new LinkedList();
    LinkedList iowa = new LinkedList();
    LinkedList kansas = new LinkedList();
    LinkedList kentucky = new LinkedList();
    LinkedList louisiana = new LinkedList();
    LinkedList maryland = new LinkedList();
    LinkedList massachusetts = new LinkedList();
    LinkedList michigan = new LinkedList();
    LinkedList minnesota = new LinkedList();
    LinkedList mississippi = new LinkedList();
    LinkedList missouri = new LinkedList();
    LinkedList montana = new LinkedList();
    LinkedList nebraska = new LinkedList();
    LinkedList nevada = new LinkedList();
    LinkedList newjersey = new LinkedList();
    LinkedList newmexico = new LinkedList();
    LinkedList newyork = new LinkedList();
    LinkedList northcarolina = new LinkedList();
    LinkedList northdakota = new LinkedList();
    LinkedList ohio = new LinkedList();
    LinkedList oklahoma = new LinkedList();
    LinkedList oregon = new LinkedList();
    LinkedList pennsylvania = new LinkedList();
    LinkedList rhodeisland = new LinkedList();
    LinkedList southdakota = new LinkedList();
    LinkedList tennessee = new LinkedList();
    LinkedList texas = new LinkedList();
    LinkedList utah = new LinkedList();
    LinkedList vermont = new LinkedList();
    LinkedList virginia = new LinkedList();
    LinkedList washington = new LinkedList();
    LinkedList westvirginia = new LinkedList();
    LinkedList wisconsin = new LinkedList();
    LinkedList wyoming = new LinkedList();
    LinkedList connecticut = new LinkedList();
    LinkedList newhampshire = new LinkedList();
    LinkedList maine = new LinkedList();
    LinkedList southcarolina = new LinkedList();
    */

    public Graph(int M)
    {
        this.M = M;
    }

    /*
    this adds the vertex in arrayList by declaring a new linked list
    the vertex is added as the head of the list by calling
    insert function in linked list class
    */
    public void addVertex(String vertex)
    {
        LinkedList ll = new LinkedList();
        arrayList.add(ll);
        ll.insert(vertex);
    }

    /*
    this adds the vertex that is neighboring to the vertex at the head
    of the linked list
    the for loop traverses arrayList and looks for the appropriate list
    to insert the input information, edge,
    according to the other input information, vertex
    */
    public void addEdge(String vertex, String edge)
    {
        for (int i = 0; i < arrayList.size(); i++)
        {
            String name = arrayList.get(i).getString();
            if (name.equals(vertex))
            {
                arrayList.get(i).insert(edge);
            }
        }
    }

    /*
    this will print out the information in the graph
    this will get the head of each linked list as the root vertex
    and traverse through the linked list to look for which vertices
    are neighboring to the root vertex.
    then prints out the vertex and the neighbors
    */
    public void print()
    {
        for (int i = 0; i < arrayList.size(); i++)
        {
            LinkedList temp = arrayList.get(i);
            String edges = ":"+temp.print();
            String vertex = temp.getString();
            System.out.format("%-15s %8s", vertex, edges + "\n");
        }
    }

    /*
    checks if the vertex is duplicated or not
    if not, returns true and adds the vertex in the arraylist
     */
    public boolean check(String str)
    {
        //System.out.println("checked: "+str);
        boolean b = true;
        for (int i = 0; i < arrayList.size(); i++)
        {
            if (str.equals(arrayList.get(i).getString()))
            {
                b = false;
            }
        }
        return b;
    }
}