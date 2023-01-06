package QueueAndStack;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * A class of queue whose entries are stored in a dynamic array
 *
 */
public class ArrayDynamicQueue<T> implements QueueInterface<T> {
  /*
   * =============================================================================
   * =
   * INSTANCE VARIABLES
   * =============================================================================
   * =
   */
  // An array of queue entries
  private ArrayList<T> queue;

  // Index of front entry and rear entry
  private int front, rear;

  /*
   * =============================================================================
   * =
   * CONSTRUCTORS
   * =============================================================================
   * =
   */
  /**
   * A default constructor for this queue
   */
  public ArrayDynamicQueue() { // to-complete
    queue = new ArrayList<T>();
    front = 0;
    rear = 0;
  }

  /**
   * Create a queue with a specific initail capacity
   * 
   * @param initCapacity the initial capacity of this queue
   */
  public ArrayDynamicQueue(int initCapacity) { // to-complete
    queue = new ArrayList<T>(initCapacity);
    front = 0;
    rear = 0;
  }

  /*
   * =============================================================================
   * INSTANCE METHODS
   * =============================================================================
   */
  /*
   * ---------------------- Getters --------------------------------------------
   */
  /**
   * Get a full queue
   * 
   * @return a full queue
   */
  public ArrayList<T> getQueue() { // to-complete
    return queue;
  }

  /**
   * Get the index of front entry
   * 
   * @return the index of front entry
   */
  public int getFrontPos() { // to-complete
    return front;
  }

  /**
   * Get the index of rear entry
   * 
   * @return int getRearPos()
   */
  public int getRearPos() { // to-complete
    return rear;
  }

  /* -------------------- Setters --------------------------------------------- */
  /**
   * To set this queue to a new queue
   * 
   * @param queue a new queue
   */
  public void setQueue(ArrayList<T> queue) { // to-complete
    this.queue = queue;
  }
  /*
   * ------------------- Other methods -----------------------------------------
   */

  /**
   * Detects whether this queue is empty
   * 
   * @return True if the queue is empty, or false otherwise
   */
  public boolean isEmpty() { // to-complete
    return queue.isEmpty();
  }

  /**
   * Count the number of entries in this queue
   * 
   * @return the number of entries in this queue
   */
  public int size() { // to-complete
    int size = 0;
    for (int i = 0; i < queue.size(); i++) {
      size++;
    }
    return size;
  }

  /**
   * Retrieve the entry at the font of this queue
   * 
   * @return The object at the front of the queue
   * @throws NoSuchElementException if the queue is empty before the operation
   */
  public T getFront() {
    if (isEmpty())
      throw new NoSuchElementException("Queue is empty, no front element");
    else
    // to-complete
    {
      return queue.get(front);
    }
  }

  /**
   * Remove and returns the entry at the front of this queue
   * 
   * @return The object at the front of the queue
   * @throws NoSuchElementException if the queue is empty before the operation
   */
  public T dequeue() {
    if (isEmpty())
      throw new NoSuchElementException("Queue is empty, cannot remove");
    else
    // to-complete
    {
      int p = queue.indexOf(getFront());
      queue.remove(p);
      return getFront();
    }
  }

  /**
   * Adds a new entry to the back of this queue
   * 
   * @param newEntry An object to be added
   */
  public void enqueue(T newEntry) { // to-complete
    queue.add(newEntry);
    rear++;
  }

  /**
   * Removes all entries from this queue
   * 
   * @throws NoSuchElementException if the queue is empty before the operation
   */
  public void clear() {
    if (isEmpty())
      throw new NoSuchElementException("Cannot clear an empty queue");
    else
    // to-complete
    {
      queue.clear();
    }
  }

  /**
   * List out all entries in this queue
   */
  public void display() { // to-complete
    for (int i = 0; i < queue.size(); i++) {
      System.out.print(queue.get(i));
    }
    System.out.println();
  }
}