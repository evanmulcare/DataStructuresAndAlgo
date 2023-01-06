package QueueAndStack;

import java.util.EmptyStackException;

/**
 * A class of stacks whose entries are stored in a singly linked list
 *
 */
 public class LinkedStack<T> implements StackInterface<T>
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

          /**
           * To create a new node instance with a specific data and pointer of 
           * the next node
           * @param data the data of a specific node
           * @param next the pointer of a specific next node
           */
           public Node(T data, Node next)
           {  this.data = data;
              this.next = next;
           }

          /**
           * To get the data of this node 
           * @return the data of this Node
           */
           public T getData()
           {   return data;  
           }

          /**
           * To get the pointer of the next node 
           * @return the pointer of the next Node
           */
           public Node getNextNode()
           {  return next;
           }

          /**
           * To set the data of this node 
           * @param data the data of this node 
           */
           public void setData(T data)
           {  this.data = data;
           }   
          
          /**
           * To set the pointer of next node 
           * @param nextNode the pointer of the next node 
           */
           public void setNextNode(Node nextNode)
           {  next = nextNode;
           }
     }

/*==============================================================================
                        INSTANCE VARIABLES
  ==============================================================================
*/
    //Reference the first node in the chain
    private Node top;

    //the size of the stack
    private int numNodes;

/*==============================================================================
                      CONSTRUCTORS
  ==============================================================================
*/
   /**
    * To create a default stack implemented with a singly linked List
    */
    public LinkedStack()
    {  //to-complete
        top = null;
        numNodes = 0;
    }
/* =============================================================================
                     INSTANCE METHODS
   =============================================================================
 */
 /* ------------------- Getters -----------------------------------------------*/
  /**
   * Count the number of entries in this stack
   * @return the number of entries in this stack
   */
   public int size()
   {  //to-complete
    return numNodes;
   } 
   
/* ------------------- Other methods -----------------------------------------*/

   public boolean isFull()
   {
    return false;
   }
  
   /**
   * Detects whether this stack is empty by checking whether the first node is 
   * a null pointer or not
   * @return true if the stack is empty
   */
   public boolean isEmpty()
   { //to-complete
       return top == null;
   }

  /**
   * Retrieves this stack's top entry
   * @return the object at the top of the stack 
   * @throws EmptyStackException if the stack is empty before the operation
   */
   public T peek()
   { if (top == null)
        throw new EmptyStackException();
     return top.data;
   } 
  
  /**
   * Removes and returns this stack's top entry
   * @return the object at the top of the stack
   */
   public T pop()
   {  //to-complete
         if(!isEmpty())
         {
             T temp = top.data;
             top = top.next;
             numNodes--;
             return temp;
         }
         throw new EmptyStackException();
   }
  
  /**
    * Adds an entry to the top of this stack
    * @param newEntry an object to be added to the stack
    */
    public void push(T newEntry)
    {  //to-complete
        Node n = new Node(newEntry, top);
        top = n;
        numNodes++;
    } 
  
  /**
   * Removes all entries from this stack
   */
   public void clear()
   {    //to-complete
       top = null;
   }

  /**
   * List out all entries in this stack
   */
   public void display()
   {  //to-complete
       if (top == null) {
            System.out.println("Stack Empty");
        }
        else
        {
             Node n = top;
             while (n != null)
               {
                System.out.println(n.data);
                n = n.next;
               }
        }
   } 
 }