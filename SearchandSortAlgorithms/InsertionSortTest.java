package SearchandSortAlgorithms;

import java.util.Arrays;
import java.security.SecureRandom;

/**
 * Sorting an array with selection Sort
 *
 */
class InsertionSortTest {
  /**
   * Sort an array using selection Sort
   * @param data an array of integers to be sorted
   */
   private static void insertionSort(int[] data)
   {  //to-complete
       for(int j = 1; j < data.length;j++)
       {
           int key = data[j];
           int i = j - 1;
           while(i >= 0 && data[i] > key)
           {
                data[i+1] = data[i];
                i = i -1;
           }
           data[i + 1] = key;
           printPass(data, j, i+1);
       }
   }

  /**
   * To print a pass of the algorithm
   * @param data an array of integers to be sorted
   * @param pass the number of pass of the algorithm
   * @param index the index of the smallest data in the array
   */
   private static void printPass(int[] data, int pass, int index)
   {   System.out.printf("after pass %2d: ", pass);
       
       //output elements till swapped item
       for (int i = 0; i < index; i++)
         System.out.printf("%d ", data[i]);
       
       //indicate swap
       System.out.printf("%d* ", data[index]);
       
       //finish outputting array
       for (int i = index + 1; i < data.length; i++)
         System.out.printf("%d ", data[i]);
       
       //for alignment
       System.out.printf("%n               ");

       //indicate amount of array that's sorted
       for (int i = 0; i <= pass; i++)
          if (i <= index)
             System.out.print("-- ");
          else if (i == index + 1)
             System.out.print(" -- ");
          else
             System.out.print("-- ");
       System.out.println();
   }

   public static void main(String[] args) {
        SecureRandom generator = new SecureRandom();

        //create unsorted array of 10 random integers
        int[] data = generator.ints(10, 10, 91).toArray();

        System.out.printf("Unsorted Array: %s%n%n", Arrays.toString(data));
        //sort array
        insertionSort(data);
        System.out.printf("%nSorted Array: %s%n", Arrays.toString(data));
  }
}