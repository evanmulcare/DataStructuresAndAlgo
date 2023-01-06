package LinkedLists;

/**
 * A class that implements a list of objects using a linked list. 
 * Duplicated entries are allowed.
 * 
 */
public class EnhancedLinkedList<T> implements ListInterface<T>
{
/* =============================================================================
                        HELPER CLASSES
   =============================================================================
 */
    /**
     * A class represents a node, which contains two parts - data and pointer 
     * to the next node
     */
     private class Node
     {    //the data of a node
          private T data;
          //pointer to the next node
          private Node next;
          
          private Node previous;
   
          /**
           * To create a new node instance with a specific data
           * @param data the data of a specific node
           */
           public Node(T data)
           {  //to-complete
            this.setData(data);
            next = null;
            previous = null;
           }
      
          /**
           * To create a new node instance with a specific data and pointer of 
           * the next node
           * @param data the data of a specific node
           * @param next the pointer of a specific next node
           */
           public Node(T data, Node next)
           {  //to-complete
            this.setData(data);
            this.setNextNode(next);
            previous = null;
           }

          /**
           * To get the data of this node 
           * @return the data of this Node
           */
           public T getData()
           {   //to-complete
            return data;
           }

          /**
           * To get the pointer of the next node 
           * @return the pointer of the next Node
           */
           public Node getNextNode()
           {  //to-complete
            return next;
           }

          /**
           * To set the data of this node 
           * @param data the data of this node 
           */
           public void setData(T data)
           {  //to-complete
            this.data = data;
           }   
          
          /**
           * To set the pointer of next node 
           * @param nextNode the pointer of the next node 
           */
           public void setNextNode(Node nextNode)
           {  //to-complete
            next = nextNode;
           }
     }
/* ============================================================================
                        INSTANCE VARIABLES
   ============================================================================
 */
     //the header node and the tail node
     private Node head, tail;

     //the number of entries in the list
     private int numEntries;

/* ============================================================================
                        CONSTRUCTORS
   ============================================================================
 */
     /**
      * A default constructor 
      */
      public EnhancedLinkedList()
      { //to-complete
        head = null;
        tail = null;
        numEntries = 1;
      }
/* =============================================================================
                       INSTANCE METHODS
   =============================================================================
 */
/* ---------------------- Getters --------------------------------------------*/
    /**
     * Gets the length of this list.
     * @return the integer number of entries currently in the list
     */
     public int getLength()
     { //to-complete
            Node n = head;
            int count = 0;
            while(n.next != null)
            {
                count++;
                n = n.next;
            }
            count++;    //since last elewment wont be ran in loop
            return count; 
     }
/* ---------------------- Other Methods --------------------------------------*/
    /**
     * Add a new entry to the end of this list.
     * Entries currently in the list are unaffected.
     * The list's size is increased by 1.
     *
     * @param newEntry the object to be added as a new entry
     */
     public void add(T newEntry)
     {  //to-complete
        Node node = new Node(newEntry);//create a new node to input into linkedList
                 //data passed in by user is assigned to new Node.
            node.next = null; 
            Node last = head;
            if(head == null) //if the head is null that means the linkedlist in empty, so the new node will be the first entry in the list
            
            {
                node.previous = null;
                head = node; //set the new node as head
                numEntries++;
                return;
            }
            else
            {
              //create a temp node and set it as head, because we need to start at first location to traverse list to fing last location
                while(last.next != null) //travel using temp node n until nodes next value is pointing to null
                {
                    //first refer to head node, check in it has a address to a second node
                    last = last.next;// set the temp not to the next address, this assigns n to be the second node
                }
                //once a null pointer is got the loop exits
                last.next = node; // set n (which is now null )to the new node that was created at start with the desired data for entry
                node.previous = last;
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
     * of the new entry
     * @param newEntry the object to be added as a new entry
     * @throws IndexOutOfBoundsException if either newPosition < 1 or 
     * mewPosition > getLength() - 1
     */
     public void add(int newPosition, T newEntry)
     {  if (newPosition >= 1 && newPosition <= numEntries + 1)
        { //to-complete
            Node node = new Node(newEntry);
            node.next = null;
            Node n = head; 
            if(newPosition == 0)
            {
                if(isEmpty())
                    {tail = node;}
                else
                    {head.previous = node;}
                node.next = head;
                head = node;
                numEntries++;
                
            }
            else if (newPosition == numEntries)
            {
                if(isEmpty())
                {
                    head = node;
                }
                else
                {
                    tail.next = null;
                    node.previous = tail;
                }
                tail = node;
                numEntries++;
            }

            else{

                for(int i = 0; i < newPosition && n.next != null; i++) //have to chage data one before desired position because the new node is shifting the current node in the desired position
                {
                    n = n.next; // change the head node until it is one off the desired position
                }
                node.next = n; //change new nodes null pointer to the next node in the list after it is inserted
                n.previous.next = node; // insert the new node into the list between n and n.next (desired position)
                node.previous = n.previous;
                n.previous = node;
                numEntries++;
            }
        }  
        else
           throw new IndexOutOfBoundsException("Illegal position given to add operation");
     }
    
    /**
     * Removes the entry at a given position from this list.
     * Entries originally at positions higher than the given position
     * are at the next lower position within the list.
     * 
     * @param givenPosition an integer that indicates the position of the 
     * entry to be removed
     * @return A pointer to the removed entry
     * @throws IndexOutOfBoundsException if either givenPosition < 1 or 
     * givenPosition > getLength()
     */
     public T remove(int givenPosition)    
     { if (givenPosition >= 1 && givenPosition <= numEntries)
       { //tocomplete
            Node n = head;
            if(givenPosition == 0)
            {
            if(head == null)
                {System.out.println("List is empty");}
                Node first = head;
                if(head.next == null)
                {
                    tail = null;
                }
                else
                {
                    head.next.previous = null;
                }
                head = head.next;
                numEntries--;
                }
            else if(givenPosition == numEntries-1)
            {
                if(tail == null)
                {throw new RuntimeException("List is empty");}
                Node last = tail;
                if(head.next == null)
                {
                    head = null;
                }
                else
                {
                    tail.previous.next = null;
                }
                tail = tail.previous;
                numEntries--;
                }
            else
            {
                for(int i = 0; i < givenPosition && n.next != null; i++) //have to chage data one before desired position because the new node is shifting the current node in the desired position
                {
                    n = n.next; // change the head node until it is one off the desired position
                }
                n.previous.next = n.next; // set n1 equal to the index node
                n.next.previous = n.previous; // set n to n1.next 9node after deleted node)
                numEntries--;
            
            }
            return (T)n.previous.next;
          }
          else
            throw new IndexOutOfBoundsException("Illegal position given to remove operation");
       }
     

    /**
     * Replaces the entry at a given position in this list.
     * 
     * @param givenPosition an integer that indicates the position of the entry 
     * to be replaced
     * @param newEntry the object that will replace the entry at the position  
     * givenPosition
     * @throws IndexOutOfBoundsException if either givenPosition < 1 or 
     * givenPosition > getLength()
     */
     public T replace(int givenPosition, T newEntry)
     { if (givenPosition >= 1 && givenPosition <= numEntries)
       { //to-complete
            Node n = head;
            Node temp = null;
            for(int i = 0; i < givenPosition; i++)
            {
                n = n.next;
            }
            temp = n;
            n.data = newEntry;
            return n.data;
       }
       else
         throw new IndexOutOfBoundsException("Illegal position given to replace operation"); 
     }
    
    /**
     * Retrieves the entry at a given position in this list.
     * 
     * @param givenPosition an integer that indicates the position of the 
     * desired entry
     * @return A pointer to the indicated entry
     * @throws IndexOutOfBoundsException if either givenPosition < 1 or 
     * givenPosition > getLength()   
     */
     public T getEntry(int givenPosition)
     { if (givenPosition >= 1 && givenPosition <= numEntries)
       {  //to-complete
            Node n = head;
            for(int i=0; i < givenPosition-1; i++)
            {
                n = n.next;
            }
            return n.data;
       }
       else
          throw new IndexOutOfBoundsException("Illegal position given to getEntry operation");
     }

    /**
     * Sees whether this list contains a given entry.
     * 
     * @param anEntry the object that is the desired entry
     * @return true if the list contains anEntry, otherwise false
     */
     public boolean contains(T anEntry)
     { //to-complete
            Node n = head;
            boolean found = false;
            while(n.next != null)
            {
                n = n.next;
                
                if(n.data == anEntry)
                {
                    found = true;
                    break;
                }
                else
                {
                    found = false;
                }
            }
            return found;
     }

    /**
     * Sees whether this list is empty.
     * @return true if the list is empty, otherwise false
     */
     public boolean isEmpty()
     { //to-complete
            Node n = head;
            boolean empty = true;
            if (head == null)
            {return empty;}
            
            while(n.next != null)
            { 
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
     * list is empty, the returned array is empty.
     */
     public T[] toArray()
     {   T[] result = (T[])new Object[numEntries];
         int index = 0;
         Node currentNode = head;
         while (index < numEntries && currentNode != null)
         {   result[index] = currentNode.getData();
             currentNode = currentNode.getNextNode();
             index++;
         }
         return result;
     }
    
    /**
     * To remove all nodes in the list
     */
     public void clear()
     {  //to-complete
            Node n = head;
            while(n.next != null)
            {
                n.next = null;
            }
     }
/* =============================================================================
                       HELPER METHODS
   =============================================================================
 */
   /**
    * It traverse the whole list until we locate the node at the desired 
    * position within the list
    * @param givenPosition an integer that indicates the position of the 
    * desired entry
    */
    private Node getNodeAt(int givenPosition)
    { if (head != null && givenPosition >= 1 && givenPosition <= numEntries)
      {  Node currentNode = head;
         for (int counter = 1; counter < givenPosition; counter++)
            if (currentNode != null)
               currentNode = currentNode.getNextNode();
         return currentNode;
      }   
      return null;
    }
}