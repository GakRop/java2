/*
@author Gak Roppongi
this graph class is mostly taken from the lab 9 work
this class constructs the graph for the randomly generated numbers sequence
the generated sequence is stored in an arraylist in driver
and the edges are created by two rules
    1. if the numbers stored later in the input arraylist
    2. and the number store before in the array is smaller
        than the number stored after in the array

the sequences are stored in a linked list and each of them is store in arraylist
then the class goes through each arraylist to look for the longest sequence
 */
import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;

public class Graph {
    int M;
    ArrayList<LinkedList> arrayList = new ArrayList<LinkedList>(M);

    public class Node
    {
        private Integer vertex;
        private Node next;

        public Node(Integer vertex)
        {
            this.vertex = vertex;
        }
    }

    public Graph(int M){
        this.M = M;
    }
    
    /*
    this adds the vertex in arrayList by declaring a new linked list
    the vertex is added as the head of the list by calling
    insert function in linked list class
    */
    public void addVertex(int vertex)
    {
        //System.out.println("addVertex(): "+vertex);
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
    public void addEdge(Integer vertex, Integer edge)
    {
        //System.out.println("addEdge(): Vertex: " + vertex + ", Edge " + edge);
        for (int i = 0; i < arrayList.size(); i++)
        {
            int name = arrayList.get(i).getVertex();
            if (name == vertex)
            {
                arrayList.get(i).insert(edge);
            }
        }
    }

    public ArrayList<Integer> LIS(ArrayList<Integer> arr){
        /*
        @param nothing
        @return LinkedList LIS
        this method looks for the longest liked list stored in the arraylist
        the longest linked list means the longest increasing sequence
        based on the graph construction rule
        then this method puts the elements in the linked list in an ArrayList
        and returns the arraylist

        the arraylist of linked list is traversed to look for each element in the linked list
        the linked lists with the first number of each element in the linked list are visited
        to look for the LIS. For example if the linked list
        stored in the first index in the arraylist is 3, 8, 5, and the original sequence is 3,1,8,2,5
        this method then looks for the element in the linked list starting with number 8
        since this linked list starting with 8 does not contain any number, the LIS length is 2.
        if max (the current maximum length of LIS) is smaller than length (current length of LIS),
        the max is updated and the start integer of the path is also updated to the start of the integer
        of the max LIS.
        then the traverse start from the start integer and looks for the longest path from it
        */

        /*
        this method traverse through all linked lists stored in the graph.
        for each linked list, it calls the FLP method, which calls the dynamic programming
        LIS finding method in LIS class. then the max length of the subsequence is returned
        and added in the LIS ArrayList, which is returned to Driver.
         */

        ArrayList<Integer> LIS = new ArrayList<Integer>();

        for (int i = 0; i < arr.size(); i++)
        {
            int length = arrayList.get(i).FLP();
            LIS.add(length);
        }

        //System.out.println("LIS: "+LIS);
        //System.out.println("max: "+max);
        return LIS;
    }
}