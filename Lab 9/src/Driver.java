import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

//Driver class to read the text input file
//then read each line by buffered reader class
//initiate the vertex and edge property
//the vertex and edge information are sent to initiateLinkedList method
//to see if there is a linked list that has the vertex input as its head
//then they will process the information to store and build the graph
//then print out all the element by each linked list
//which means what the root state is
//and what states are neighboring to the root state

public class Driver {
    public static void main(String[] args) throws Exception{
        File file = new File ("inlab9.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;

        String vertices = br.readLine();
        String edges = br.readLine();
        int nbOfVertices = Integer.parseInt(vertices);

        Graph arrayList = new Graph(nbOfVertices);

        while((str = br.readLine()) != null)
        {
            String[] stringArray = str.split(" ");
            String vertex = stringArray[0];
            String edge = stringArray[1];
            arrayList.initiateLinkedList(vertex, edge);
        }

        arrayList.print();
    }
}