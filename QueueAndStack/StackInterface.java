package QueueAndStack;

/**
 * This is an interface for the ADT stack
 * 
 */
interface StackInterface<T> {
    /**
     * Adds an entry to the top of this stack
     * @param newEntry an object to be added to the stack
     */
     public void push(T newEntry);
 
   /**
    * Removes and returns this stack's top entry
    * @return the object at the top of the stack
    */
    public T pop();
 
   /**
    * Retrieves this stack's top entry
    * @return the object at the top of the stack 
    */
    public T peek();
 
   /**
    * Detects whether this stack is empty
    * @return true if the stack is empty
    */
    public boolean isEmpty();
 
   /**
    * Detects whether this stack is full
    * @return true if the stack is full
    */
    public boolean isFull();
 
   /**
    * Removes all entries from this stack
    */
    public void clear();
 
   /**
    * List out all entries in this stack
    */
    public void display();
 
   /**
    * Count the number of entries in this stack
    * @return the number of entries in this stack
    */
    public int size();        
 }