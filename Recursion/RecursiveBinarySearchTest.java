package Recursion;

import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This class performs a binary search on an array of 20 random integers in the 
 * range 1 to 100 to discover whether or not it contains an integer input from
 * the keyboard. The binary search is implemented in recursion.
 *
 * @author Jing Hua Ye
 * @date Nov/6/2021
 * @version 1.0
 */
 class RecursiveBinarySearchTest {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random generator = new Random();

        //create an array of 20 random integers between 1 to 100 
        int[] data = new int[MAX_SIZE];
        for (int i = 0; i < data.length; i++)
           data[i] = 1 + generator.nextInt(100);

        //Use the sort method in Arrays class to make sure data in a sorted order
        Arrays.sort(data);
                
        //display array as below: for example [-1, 10, 40, 30]
        //Hint: use the Arrays class
        System.out.printf("%s%n%n", Arrays.toString(data)); 
        
        //repeatedly input an integer from user: -1 terminates the program
        //after reading an input of search key, we perform a linear search on 
        //data with this search key. Finaaly print out the result of the linear
        //search
        int searchInt;
        do
        {   System.out.print("Please enter a search key (-1 or quit): ");
            searchInt = input.nextInt();

            //perform a linear search
            int position = binarySearch(data, 0, data.length - 1, searchInt);

            //print out the search result
            if (position < 0)
              System.out.printf("%d was not found%n%n", searchInt);
            else
              System.out.printf("%d was found in position %d%n%n", searchInt, position);
        }
        while (searchInt >= 0);
     }
/* =============================================================================
                           HELPER METHODS 
   =============================================================================
 */
/**
 * To perform a binary search on an array of data using recursion approach
 *
 * @param data a static array of integers
 * @param low the lower bound of the array
 * @param high the higher bound of the array
 * @param searchKey the search key of performing the search
 * @return -1 if the searchKey is not found in the data, otherwise the position 
 * of the searchKey in the data
 */
 private static int binarySearch(int[] data, int low, int high, int searchKey)
 {   //to-complete
     if(low > high)
     {return -1;}
     
     else
     {
        int mid = (low + high + 1) / 2; 
        
        if(searchKey == data[mid])
            {
                System.out.println(remainingElements(data, low, high));
                return mid;
            }
        else if(searchKey > data[mid])
            {
                System.out.println(remainingElements(data, low, high));
                    for (int i = 0; i < mid; i++)
                        System.out.print(" ");
                System.out.println(" *");

                return binarySearch(data, mid + 1, high, searchKey);
            }
        else
            {
                System.out.println(remainingElements(data, low, high));
                    for (int i = 0; i < mid; i++)
                        System.out.print(" ");
                System.out.println(" *");

                return binarySearch(data, low, mid - 1, searchKey);
            }
    
     }
 }

 /**
  * A method for printing out certain values in array
  * 
  * @param data an array of sorted integers
  * @param low the low end of the array
  * @param high the high end of the array
  * @return a string represents the set of certain values in array
  */
  private static String remainingElements(int[] data, int low, int high)
  {  StringBuffer temp = new StringBuffer();
     
     //append space for alignment
     for (int i = 0; i < low; i++)
        temp.append(" ");
     
     //append elements left in array
     for (int i = low; i <= high; i++)
        temp.append(data[i] + " ");
        
        
     return String.format("%s%n",temp); 
  }

/* ============================================================================
                            CLASS VARIABLES
   ============================================================================
 */
     //the maximum size of the static array
     private static final int MAX_SIZE = 20; 
}