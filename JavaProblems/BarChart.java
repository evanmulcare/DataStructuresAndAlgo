import java.util.Scanner;

public class BarChart {
  public static void main(String args[]) {
    // take input
    Scanner input = new Scanner(System.in);
    int[] array = new int[5];
    for (int i = 0; i < 5; i++) {
      System.out.println("Please input a number between 1 and 30: ");
      int number = input.nextInt();
      if (number < 31 && number > 0) {
        array[i] = number;
      } else {
        System.out.println("NO GOOD!");
      }
    }
    // print barchart
    for (int index = 0; index < array.length; index++) {
      for (int astericks = 0; astericks < array[index]; astericks++)
        System.out.print("*");
      System.out.println();
    }

  }
}
