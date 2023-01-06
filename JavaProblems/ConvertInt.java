import java.util.Scanner;

public class ConvertInt {
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);

    System.out.print("Please input a five digit integer: ");
    int value = input.nextInt();
    String digits = "";

    while (value > 10) {
      digits = digits + value % 10 + "   ";
      value = value / 10;
      if (value < 10) {
        digits = digits + value + " ";
      }
    }
    StringBuilder sb = new StringBuilder(digits);
    System.out.println(sb.reverse());
  }
}