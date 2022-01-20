/*
@author: Gak Roppongi
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Driver{

    /*
    @param ArrayList graphLIS, int length, int time
    @return nothing
    this method receives the arraylist of LIS, length of the LIS,
    and the execution time
    then it prints all the input parameters out in a txt file
    the txt file is named as graphResult.txt
     */
    public static void graphResultWriter(List graphLIS, int length, double time) throws IOException{
        PrintWriter out = new PrintWriter("graphResult.txt");
        out.println("LIS: " + graphLIS + "\n");
        out.println("The length of LIS: " + length + "\n");
        out.println("The execution time: " + time);
        out.close();
    }

    /*
    @param List dynamicLIS, int length, int time
    @return nothing
    this method receives the List of LIS in the dynamic programing,
    length of the LIS, and the execution time
    then it prints all the input parameters out in a txt file
    the txt file is named as dynamicProgramingResult.txt
     */
    public static void dynamicProgramingResultWriter (List dynamicLIS, int length, double time) throws IOException{
        PrintWriter out = new PrintWriter("dynamicProgramingResult.txt");
        out.println("LIS: " + dynamicLIS + "\n");
        out.println("The length of LIS: " + length + "\n");
        out.println("The execution time: " + time);
        out.close();
    }

    /*
    @param none
    this method generates the sequence of random numbers with the length of 10000
    the number is chosen between 1 ~ 100000
    the random number is put in arr ArrayList
    then the next for loop is to remove the duplication
    and stores the number in withoutDup arraylist
     */
    public static void main(String args[])throws IOException{
        /*
        this part generates the random number sequence
        the length is 5000 and the number is picked up from 1 to 10000
        then each of them is put in ArrayList arr
         */
        System.out.println("random number generator\n");
        int cap = 5000;
        ArrayList<Integer> arr = new ArrayList<Integer>(cap);
        int min = 1;
        int max = 10000;

        for (int i = 0; i < cap; i++)
        {
            int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
            arr.add(random_int);
        }

        /*
        this part removes the duplicated numbers
        the for loop traverse arr and if the number is contained
        in the newly initiated withoutDup ArrayList,
        it skips adding the number into the withoutDup ArrayList
        */
        System.out.println("Duplication removal");
        ArrayList<Integer> withoutDup = new ArrayList<Integer>(cap);
        for (int i = 0; i < arr.size(); i++)
        {
            if (!withoutDup.contains(arr.get(i)))
            {
                withoutDup.add(arr.get(i));
            }
        }

        //System.out.println("withoutDup: "+withoutDup);

        /*
        Graph Method
        this part constructs the graph based on the generated sequence
        then finds the longest path in the graph to look for the LIS
        then gets the length of the LIS
        and count the execution time to look for the longest path
        then passes the LIS sequence, the length of LIS, and the time
        to write  those in a file
        After it initiated a graph, the arraylist without duplicate
        is traversed through in the for loop.
        if the index does not hit the empty cell in an arraylist,
        it checks all other elements stored in the arraylist after index i
        if the arraylist.get(i) is smaller than the arraylist.get(j)
        arraylist.get(j) is stored in the linked list starting with arraylist.get(i).
        then the LIS method is called from the graph class to look for the longest path
        the LIS method return the longest path in the arraylist
        then the length of the return arraylist is the length of the LIS
        the execution time of the LIS method is timed
         */

        /*
        ArrayList<Integer> withoutDup = new ArrayList<Integer>(5);
        withoutDup.add(4);
        withoutDup.add(1);
        withoutDup.add(2);
        withoutDup.add(5);
        withoutDup.add(3);
        withoutDup.add(6);
        withoutDup.add(8);
        withoutDup.add(7);
         */

        /*
        after the duplication was removed
        the loop calculates how many numbers are stored
        after the duplication removal
         */
        int sequenceLength = 0;
        for (int i = 0; i < withoutDup.size(); i++)
        {
            if (withoutDup.get(i) != null)
            {
                sequenceLength++;
            }
        }

        /*
        a new ArrayList with the capacity of the sequenceLength is initiated
        and each number in the withoutDup ArrayList

         */
        //System.out.println(sequenceLength);
        ArrayList<Integer> Array = new ArrayList<Integer>(sequenceLength);
        for (int i = 0; i < sequenceLength; i++)
        {
            Array.add(withoutDup.get(i));
        }

        //System.out.println("Array: "+Array);

        /*
        the graph construction starts here
        the loop reads each number in Array and if the number is larger and coming
        after the number store at i index in Array, it calls the addEdge function
        and elongates the linked list
        for each time i is incremented, a new linked list is added in an arraylist
         */
        System.out.println("Graph method\n");
        Graph graph = new Graph(cap);

        for (int i = 0; i < sequenceLength; i++)
        {
            if (Array.get(i) != null)
            {
                //System.out.println(i);
                int vertex = Array.get(i);
                graph.addVertex(vertex);

                for (int j = i + 1; j < sequenceLength; j++)
                {
                    int edge = Array.get(j);
                    if (vertex < edge)
                    {
                        graph.addEdge(vertex, edge);
                    }
                }
            }
        }

        //System.out.println("\n");
        //graph.print();
        //System.out.println("\n");

        /*
        this part calculates the length of LIS
        it calls the LIS method and receives the ArrayList of LIS for each number
        and then looks for the maximum number of the LIS
         */
        System.out.println("Graph LIS\n");
        //the execution time of the LIS method here is timed
        StopwatchCPU timer1 = new StopwatchCPU();
        ArrayList<Integer> LISList = graph.LIS(Array);
        double graphTime = timer1.elapsedTime();

        int graphLength = 0;
        int index = 0;
        for (int i = 0; i < LISList.size(); i++)
        {
            if (graphLength < LISList.get(i))
            {
                graphLength = LISList.get(i);
                index = i;
            }
        }

        //graphResultWriter(Array, graphLength, graphTime);
        System.out.println("Graph done\n");

        /*dynamic programing
        this part look for the length of the LIS
        and looks for the sequence of LIS
        and count the execution time to look for the longest path
        then passes the LIS sequence, the length of LIS, and the time
        to write those in a file
         */

        /*
        this part converts the ArrayList into an Array
        since the method only receives array datatype
         */
        System.out.println("Dynamic programming\n");
        int array[] = new int[sequenceLength];

        for (int i = 0; i < sequenceLength; i++)
        {
            array[i] = Array.get(i);
        }

        /*
        the array and the array length are given to the method
        to look for the longest increasing sequence by dynamic programming
        the LIS is returned and then the actual sequence of the LIS
        is returned by calling findLIS method
         */
        LIS lis = new LIS();
        //the execution time of lis method here is timed
        StopwatchCPU timer2 = new StopwatchCPU();
        int dynamicLength = lis.lis(array, array.length);
        double dynamicTime = timer2.elapsedTime();

        List LIS = lis.findLIS(array);

        System.out.println("Dynamic programming done\n");

        /*
        then all the parameters to be written in a txt file
        are passed to each file writer method
         */

        graphResultWriter(LIS, graphLength, graphTime);
        dynamicProgramingResultWriter(LIS, dynamicLength, dynamicTime);


        System.out.println("graphLength: "+graphLength);
        System.out.println("start int: "+Array.get(index) + " at " + index);
        //graph.print(index);
        System.out.println("dynamicLength: "+dynamicLength);
        System.out.println("dynamicLIS: "+LIS);

        //double T = time.elapsedTime();
        //System.out.println(T);
    }
}
