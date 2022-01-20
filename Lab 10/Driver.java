import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Queue;

public class Driver {
    public static void main(String[] args) throws Exception{
        File file = new File ("inlab9.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;

        String vertices = br.readLine();
        String edges = br.readLine();
        int nbOfVertices = Integer.parseInt(vertices);

        //System.out.println(nbOfVertices);
        //System.out.println(nbOfEdges);

        Graph arrayList = new Graph(nbOfVertices);

        while((str = br.readLine()) != null)
        {
            String[] stringArray = str.split(" ");
            String vertex = stringArray[0];
            String edge = stringArray[1];
            arrayList.addVertex(vertex);
            arrayList.addEdge(vertex, edge);
        }
        //arrayList.print();

        //calls the breadth first search method
        arrayList.breadthFirstSearch();

        //arrayList.Print("Montana");
        //call the breadth first method and returns the arraylist
        //with the state they can visit in distTo range
    }
}