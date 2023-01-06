package LinkedLists;

/**
 * A class that implements a list of objects using a linked list.
 * Duplicated entries are allowed.
 * 
 */
public class LinkedList<T> implements ListInterface<T> {
  /*
   * =============================================================================
   * HELPER CLASSES
   * =============================================================================
   */
  /**
   * A class represents a node, which contains two parts - data and pointer
   * to the next node
   */
  private class Node { // the data of a node
    private T data;
    // pointer to the next node
    private Node next;

    /**
     * To create a new node instance with a specific data
     * 
     * @param data the data of a specific node
     */
    public Node(T data) { // to-complete
      this.setData(data);
      next = null;

    }

    /**
     * To create a new node instance with a specific data and pointer of
     * the next node
     * 
     * @param data the data of a specific node
     * @param next the pointer of a specific next node
     */
    public Node(T data, Node next) { // to-complete
      this.setData(data);
      this.setNextNode(next);
    }

    /**
     * To get the data of this node
     * 
     * @return the data of this Node
     */
    public T getData() { // to-complete
      return data;
    }

    /**
     * To get the pointer of the next node
     * 
     * @return the pointer of the next Node
     */
    public Node getNextNode() { // to-complete
      return next;
    }

    /**
     * To set the data of this node
     * 
     * @param data the data of this node
     */
    public void setData(T data) { // to-complete
      this.data = data;
    }

    /**
     * To set the pointer of next node
     * 
     * @param nextNode the pointer of the next node
     */
    public void setNextNode(Node nextNode) { // to-complete
      next = nextNode;
    }
  }

  /*
   * ============================================================================
   * INSTANCE VARIABLES
   * ============================================================================
   */
  // the header node
  private Node head;

  // the number of entries in the list
  private int numEntries;

  /*
   * ============================================================================
   * CONSTRUCTORS
   * ============================================================================
   */
  /**
   * A default constructor
   */
  public LinkedList() { // to-complete
    head = null;
    numEntries = 1;
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
   * Gets the length of this list.
   * 
   * @return the integer number of entries currently in the list
   */
  public int getLength() { // to-complete
    if (head == null) {
      return 1;
    }
    int count = 0;
    Node n = head;
    while (n != null) {
      count++;
      n = n.next;
    }
    return count;
  }

  /*
   * ---------------------- Other Methods --------------------------------------
   */
  /**
   * Add a new entry to the end of this list.
   * Entries currently in the list are unaffected.
   * The list's size is increased by 1.
   *
   * @param newEntry the object to be added as a new entry
   */
  public void add(T newEntry) { // to-complete
    Node node = new Node(newEntry, null); // create a new node to input into linkedList

    if (head == null) // if the head is null that means the linkedlist in empty, so the new node will
                      // be the first entry in the list
    {
      head = node; // set the new node as head
    } else {
      Node n = head; // create a temp node and set it as head, because we need to start at first
                     // location to traverse list to fing last location
      while (n.next != null) // travel using temp node n until nodes next value is pointing to null
      {
        // first refer to head node, check in it has a address to a second node
        n = n.next;// set the temp not to the next address, this assigns n to be the second node
      }
      // once a null pointer is got the loop exits
      n.next = node; // set n (which is now null )to the new node that was created at start with the
                     // desired data for entry
      numEntries++;
    }

  }

  /**
   * Adds a new entry at a specified position within this list.
   * Entries originally at and above the specified position are
   * at the next higher position within the list.
   * The list's size is increased by 1.
   * 
   * @param newPosition an integer that specifies the desired position
   *                    of the new entry
   * @param newEntry    the object to be added as a new entry
   * @throws IndexOutOfBoundsException if either newPosition < 1 or
   *                                   mewPosition > getLength() - 1
   */
  public void add(int newPosition, T newEntry) {
    if (newPosition >= 1 && newPosition <= numEntries + 1) { // to-complete
      Node node = new Node(newEntry);

      if (newPosition == 1) {
        node.next = head; // nodes next element will be set to previous head node
        head = node; // head changes to new node
        numEntries++;
      } else {
        // temp value for traversing
        Node n = head;
        for (int i = 0; i < newPosition - 1; i++) // have to chage data one before desired position because the new node
                                                  // is shifting the current node in the desired position
        {
          n = n.next; // change the head node until it is one off the desired position
        }
        node.next = n.next; // change new nodes null pointer to the next node in the list after it is
                            // inserted
        n.next = node; // insert the new node into the list between n and n.next (desired position)
        numEntries++;
      }
    } else
      throw new IndexOutOfBoundsException("Illegal position given to add operation");
  }

  /**
   * Removes the entry at a given position from this list.
   * Entries originally at positions higher than the given position
   * are at the next lower position within the list.
   * 
   * @param givenPosition an integer that indicates the position of the
   *                      entry to be removed
   * @return A pointer to the removed entry
   * @throws IndexOutOfBoundsException if either givenPosition < 1 or
   *                                   givenPosition > getLength()
   */
  public T remove(int givenPosition) {
    if (givenPosition >= 1 && givenPosition <= numEntries) {
      // to-complete
      if (givenPosition == 0) {
        head = head.next;
        numEntries--;
        return (T) head.data;
      } else {
        Node n = head;
        Node n1 = null;
        for (int i = 0; i < givenPosition - 1; i++) // have to chage data one before desired position because the new
                                                    // node is shifting the current node in the desired position
        {
          n = n.next; // change the head node until it is one off the desired position
        }
        n1 = n.next; // set n1 equal to the index node
        n = n1.next; // set n to n1.next (node after deleted node)
        numEntries--;
        return (T) n1; // return deleted node
        // make eligable for garbage collection
      }
    } else {
      throw new IndexOutOfBoundsException("Illegal position given to remove operation");
    }
  }

  /**
   * Replaces the entry at a given position in this list.
   * 
   * @param givenPosition an integer that indicates the position of the entry
   *                      to be replaced
   * @param newEntry      the object that will replace the entry at the position
   *                      givenPosition
   * @throws IndexOutOfBoundsException if either givenPosition < 1 or
   *                                   givenPosition > getLength()
   */
  public T replace(int givenPosition, T newEntry) {
    if (givenPosition >= 1 && givenPosition <= numEntries) { // to-complete
      Node n = head;
      Node temp = null;
      for (int i = 0; i < givenPosition; i++) {
        n = n.next;
      }
      temp = n;

      System.out.println("Data before replacement is " + temp.data);
      n.data = newEntry;
      System.out.println("Data after replacement is " + n.data);
    } else
      throw new IndexOutOfBoundsException("Illegal position given to replace operation");

    return null;
  }

  /**
   * Retrieves the entry at a given position in this list.
   * 
   * @param givenPosition an integer that indicates the position of the
   *                      desired entry
   * @return A pointer to the indicated entry
   * @throws IndexOutOfBoundsException if either givenPosition < 1 or
   *                                   givenPosition > getLength()
   */
  public T getEntry(int givenPosition) {
    if (givenPosition >= 1 && givenPosition <= numEntries) { // to-complete
      Node n = head;
      for (int i = 0; i < givenPosition - 1; i++) {
        n = n.next;
      }
      return n.data;
    } else {
      throw new IndexOutOfBoundsException("Illegal position given to getEntry operation");
    }

  }

  /**
   * Sees whether this list contains a given entry.
   * 
   * @param anEntry the object that is the desired entry
   * @return true if the list contains anEntry, otherwise false
   */
  public boolean contains(T anEntry) {// to-complete
    Node n = head;
    boolean found = false;
    while (!found && n != null) {

      if (anEntry == n.data) {
        found = true;
        break;
      } else {
        n = n.next;
      }
    }
    return found;
  }

  /**
   * Sees whether this list is empty.
   * 
   * @return true if the list is empty, otherwise false
   */
  public boolean isEmpty() { // to-complete
    Node n = head;
    boolean empty = true;
    if (head == null) {
      return empty;
    }

    while (n.next != null) {
      empty = false;
      break;
    }

    return empty;
  }

  /**
   * Retrieves all entries that are in this list in the order in which they
   * occur in the list.
   * 
   * @return a newly allocation array of all the entries in the list. If the
   *         list is empty, the returned array is empty.
   */
  public T[] toArray() {
    T[] result = (T[]) new Object[numEntries];
    int index = 0;
    Node currentNode = head;
    while (index < numEntries && currentNode != null) {
      result[index] = currentNode.getData();
      currentNode = currentNode.getNextNode();
      index++;
    }
    return result;
  }

  /**
   * To remove all nodes in the list
   */
  public void clear() { // to-complete
    Node n = head;
    while (n.next != null) {
      n.next = null;
    }

  }

  /*
   * =============================================================================
   * HELPER METHODS
   * =============================================================================
   */
  /**
   * It traverse the whole list until we locate the node at the desired
   * position within the list
   * 
   * @param givenPosition an integer that indicates the position of the
   *                      desired entry
   */
  private Node getNodeAt(int givenPosition) {
    if (head != null && givenPosition >= 1 && givenPosition <= numEntries) {
      Node currentNode = head;
      for (int counter = 1; counter < givenPosition; counter++)
        if (currentNode != null)
          currentNode = currentNode.getNextNode();
      return currentNode;
    }
    return null;
  }
}
