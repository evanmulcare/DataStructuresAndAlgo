package QueueAndStack;


import java.util.NoSuchElementException;

public class QueueTest2 {
  public static void main(String[] args) {
    QueueInterface<Integer> queue = new ArrayDynamicQueue<Integer>();

    // use enqueue method
    queue.enqueue(-1);
    queue.display();
    queue.enqueue(0);
    queue.display();
    queue.enqueue(1);
    queue.display();
    queue.enqueue(5);
    queue.display();

    while (!(queue.isEmpty()))
      try { // remove head element
        int removedItem = queue.dequeue();
        System.out.printf("%n%d dequeued%n", removedItem);
        queue.display();
      } catch (NoSuchElementException nsee) {
        nsee.printStackTrace();
      }
  }
}