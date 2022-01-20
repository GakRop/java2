import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class LIS {
    //this class solves the problem using a dynamic programing
    //by looking for the subproblems
    //arr[] contains the numbers that we read in the main function
    //n is the number of numbers in the array
    public int lis (int arr[], int n)
    {
        //lis is the array containing the length of increasing sequence
        //from each number in the arr
        int  lis[] = new int[n];
        int i, j, max = 0;


        //this set the default value of the LIS as 1
        for (i = 0; i < n; i++)
        {
            lis[i] = 1;
        }

        //this looks for each number in arr[] which stores the sequence of numbers that we read
        //and updates the LIS to a specific number in arr[]
        for (i = 1; i < n; i++)
        {
            for (j = 0; j < i; j++)
            {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
                {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        //this looks for the max length of LIS in the lis[]
        //traverse through the lis[] and updates the max value
        for (i = 0; i < n; i++)
        {
            if (max < lis[i])
            {
                max = lis[i];
            }
        }

        //and return max value of LIS
        return max;
    }

    //the main class reads in the input file
    public static void main(String[] args) throws Exception {
        File file = new File("lab10in.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        //and slices the sentence by space
        String st;
        while ((st = br.readLine()) != null)
        {
            String[] str = st.split(" ");
            //LinkedList ll = new LinkedList();
            int[] arr = new int[str.length];

            //throw away the information if the string array has only one length
            //which means the array contains only the information about
            //how many numbers are in the array
            if (str.length > 1)
            {
                int i = 0;
                while (i < str.length)
                {
                    int num = Integer.parseInt(str[i]);
                    //ll.add(num);
                    arr[i] = num;
                    i++;
                }
                LIS lis = new LIS();
                int max = lis.lis(arr, arr.length);
                System.out.println("For sequence: "+ Arrays.toString(arr) +", the length of LIS is "+max);
            }
        }
    }
}
