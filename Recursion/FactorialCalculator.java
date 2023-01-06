package Recursion;

/**
 * This class calculates factorial via iterative approach and recursive approach
 *
 */
public class FactorialCalculator
{
    public static void main(String[] args)
    {   //calculate the factorial of 0 through 10
        for (int counter = 0; counter <= 10; counter++)
           System.out.printf("%d! = %d%n", counter, iterativeFac(counter));
        
        for (int counter = 0; counter <= 10; counter++)
           System.out.printf("%d! = %d%n", counter, recursiveFac(counter));
    }

   /**
    * Iterative calculate factorial
    *
    * @param number the number to be calculated for factorial
    * @return the factorial of number
    */
    private static long iterativeFac(long number)
    {  //to-complete
        long answer = 1;
        while(number > 1)
        {
            answer = number * answer;
            number = number -1;
        }
        return answer;
    }

   /**
    * Recursive calculate factorial
    *
    * @param number the number to be calculated for factorial
    * @return the factorial of number
    */
    private static long recursiveFac(long number)
    {   //to-complete
        if (number >= 1)
           {
               return number * recursiveFac(number - 1);
           }
        else
            {
                return 1;
            }
    }
}
