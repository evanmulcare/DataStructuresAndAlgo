package SearchandSortAlgorithms;

import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This class performs a binary search on an array of 20 random integers in the 
 * range 1 to 100 to discover whether or not it contains an integer input from
 * the keyboard.
 *
 */
 class BinarySearchTest {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random generator = new Random();

        //Task: create an array of 20 random integers between 1 to 100 
        //to-complete
            Random rd = new Random();
            int[] randomArray = new int[20];
            int min =1, max=100;
            
            for(int i =0; i< randomArray.length;i++)
            {
                randomArray[i] = rd.nextInt(max - min + 1) + min;
            }

        //Task: which method should be used in Arrays class to make sure data in a sorted 
        //order
        //to-complete
            Arrays.sort(randomArray);
                
        //Task: display array as below: for example [-1, 10, 40, 30]
        //Hint: use the Arrays class, which method should we use to output data in a such 
        //format?
        //to-complete
            System.out.println(Arrays.toString(randomArray));
        
        //Task: repeatedly input an integer from user: -1 terminates the program
        //after reading an input of search key, we perform a binary search on 
        //data with this search key. Finaaly print out the result of the binary search as the
        //sample outputs provided in the task specification
        //to-complete
        int option;
        do {
            System.out.println("Please enter an integer value (-1 to quit): ");
            option = input.nextInt();
            if(option == -1)
            {
                System.exit(0);
            }
            else
            {
                System.out.println(option + " was found in position " + binarySearch(randomArray, option));
                
            }
        }
        while (option >= 0);
     }
/* =============================================================================
                           HELPER METHODS 
   =============================================================================
 */
/**
 * To perform a binary search on an array of data
 *
 * @param data a static array of integers
 * @param searchKey the search key of performing the search
 * @return -1 if the searchKey is not found in the data, otherwise the position 
 * of the searchKey in the data
 */
 private static int binarySearch(int[] data, int searchKey)
 {   //to-complete
     int min = 1, max = MAX_SIZE;
         while(min <= max)
         {
            int mid = (min + max)/2;

            if (data[mid] < searchKey)
            {
                min = mid +1;
                int[] printArr = new int[MAX_SIZE];
                for(int i = printArr.length - 1; i >= min; i--)
                {
                    printArr[i] = data[i];
                }
                
                print(printArr);
            }
            else if(data[mid] == searchKey)
            {
                System.out.printf("%d* \n", searchKey);
                return mid;
            }
            
            else
            {
                max = mid-1;
                int[] printArr = new int[MAX_SIZE];
                for(int i = 0; i <= max; i++)
                    {
                        printArr[i] = data[i];
                    }
                
                print(printArr);
            }
         }
     return -1;
 }
  
//you may need to consider to define some other helper methods to format the final outputs
private static void print(int[] printArr)
{
 
    for(int i = 0; i < printArr.length; i++)
        {
            if(printArr[i] == 0)
            {
                System.out.print(" ");
            }
            else
            {
                System.out.printf("%d ", printArr[i]);
            }
        }
    System.out.println();
} 
/* ============================================================================
                            CLASS VARIABLES
   ============================================================================
 */
     //the maximum size of the static array
     private static final int MAX_SIZE = 20; 
}