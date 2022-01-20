/*
@author Gak Roppongi
this is a dynamic programming class to look for the LIS
and the length of LIS
public int lis(int arr[], int n) was taken from the lab 10
public List findLIS(int[] arr) was taken from the website below:
https://www.techiedelight.com/longest-increasing-subsequence-using-dynamic-programming/
 */
import java.util.*;

public class LIS {
    /*
    @param int arr[], int n
    @return int lis
    this function solves the problem using a dynamic programing
    by looking for the sub-problems
    arr[] contains the numbers that we read in the main function
    n is the number of numbers in the array
    and returns the length of the LIS

    this method will first receive the original randomly generated integer array and its size
    it initiates another integer array to store the length of LIS to that integer
    and initiates the max length of LIS as 0 for the default value

    in the first for loop, it goes through the lis array to set the default length for LIS as 1
    in the second for loop, it goes through the input array and the lis array
    if the integer in the randomly generated sequence before a certain number is smaller than that
    and the stored LIS length is equal to that comes before in the array, it increments the LIS length
    in the third loop, the loop goes through the lis array to look for the max lis length
    and updates the max lis length, and returns the max lis length
     */
    public int lis(int arr[], int n) {
        int lis[] = new int[n];
        int i, j, max = 0;

        for (i = 0; i < n; i++) {
            lis[i] = 1;
        }

        for (i = 1; i < n; i++) {
            for (j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        for (i = 0; i < n; i++) {
            if (max < lis[i]) {
                max = lis[i];
            }
        }

        return max;
    }

    /*
    @param int[] arr
    @return List
    @throws Exception when the input array does not contain any numbers
    this function recursively looks for and stores the LIS sequence

    the base case for the recursion is where the input array
    does not contain any numbers if so, return null

    first, it initiates a List and go through each element in list
    to store a new arraylist in each element in the list
    and then add the first number in the input array to the 1st element in list

    in the second for loop, it compares the number in the input array
    and the length of the array store in the list LIS initiated in the line 79
    if the number in the array before a certain number is smaller than that
    and the length of the list in the LIS list stored before that in LIS list
    is longer, it updates the longest sequence

    in the third for loop, it looks at the size of each arraylist
    stored in the list, and updates to the longest one each time

    then returns the longest arraylist in the LIS
     */
     public List findLIS(int[] arr)
    {
        if (arr == null || arr.length == 0) {
            return null;
        }

        List<List<Integer>> LIS = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            LIS.add(new ArrayList<>());
        }

        LIS.get(0).add(arr[0]);

        for (int i = 1; i < arr.length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (arr[j] < arr[i] && LIS.get(j).size() > LIS.get(i).size()) {
                    LIS.set(i, new ArrayList<>(LIS.get(j)));
                }
            }
            LIS.get(i).add(arr[i]);
        }

        int j = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if (LIS.get(j).size() < LIS.get(i).size()) {
                j = i;
            }
        }

        return LIS.get(j);
    }
}
