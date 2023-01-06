package QueueAndStack;


/**
 * This class represents a generic interface for a queue data structure
 *
 */
public interface QueueInterface<T> {
    /**
     * Adds a new entry to the back of this queue
     * 
     * @param newEntry An object to be added
     */
    public void enqueue(T newEntry);
  
    /**
     * Remove and returns the entry at the front of this queue
     * 
     * @return The object at the front of the queue
     */
    public T dequeue();
  
    /**
     * Retrieve the entry at the font of this queue
     * 
     * @return The object at the front of the queue
     */
    public T getFront();
  
    /**
     * Detects whether this queue is empty
     * 
     * @return True if the queue is empty, or false otherwise
     */
    public boolean isEmpty();
  
    /**
     * Removes all entries from this queue
     */
    public void clear();
  
    /**
     * Display all entries in this queue
     */
    public void display();
  }