package QueueAndStack;
/**
 * A class of queue whose entries are stored in a singly linked list
 *
 */
public class LinkedQueue<T> implements QueueInterface<T>
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
   //References node at the front of queue
   private Node firstNode;

   //References node at the rear of queue
   private Node lastNode;

   //the number of data nodes in the queue
   private int numNodes;

/*==============================================================================
                     CONSTRUCTORS
 ==============================================================================
*/
/**
 * A default constructor for this queue
 */
 public LinkedQueue()
 {   //to-complete
     firstNode = null;
     lastNode = null;
     numNodes = 0;
 }

/* =============================================================================
                    INSTANCE METHODS
  =============================================================================
*/
/* ------------------- Getters -----------------------------------------------*/
 /**
  * Count the number of entries in this queue
  * @return the number of entries in this queue
  */
  public int size()
  {  //to-complete
      return numNodes;
  } 
/* ------------------- Other methods -----------------------------------------*/
 
 /**
  * Detects whether this queue is empty
  * @return True if the queue is empty, or false otherwise
  */
  public boolean isEmpty()
  { //to-complete
      boolean empty = false;
      if(firstNode == null && lastNode == null)
      {
           empty = true;
      }
      return empty;
  }
 
 /**
  * Retrieve the entry at the font of this queue
  * @return The object at the front of the queue
  * @throws EmptyQueueException if the queue is empty before the operation
  */
  public T getFront()
  { try 
    { if (isEmpty())
        throw new EmptyQueueException("The queue is empty, cannot get front");
      else
       //to-complete
       {
           return firstNode.getData();
       }
    }
    catch (EmptyQueueException eqe)
    {  
        eqe.printStackTrace();
    }
    return null;
  } 
 
 /**
  * Remove and returns the entry at the front of this queue
  * @return The object at the front of the queue
  */
  public T dequeue()
  {  //to-complete
      Node n = null;
       if(firstNode != null)
       {
           if(firstNode.getNextNode() != null)
           {
               n = new Node(firstNode.getData(), firstNode.getNextNode());
               firstNode = firstNode.getNextNode();
               numNodes--;
           }
           else
           {
               n = new Node(firstNode.getData(), firstNode.getNextNode());
               firstNode = null;
               lastNode = null;
               numNodes--;
           }
       }
       return n.getData();
  }
 
 /**
  * Adds a new entry to the back of this queue
  * @param newEntry An object to be added
  */
  public void enqueue(T newEntry)
  { //to-complete 
      Node n = new Node(newEntry, null);
      if(firstNode == null)
      {
       firstNode = n;
       lastNode = n;
       numNodes++;
      }
      else
      {
       
       lastNode.setNextNode(n);
       lastNode = n;
       numNodes++;
       
      }
      
  } 
 
 /**
  * Removes all entries from this queue
  */
  public void clear()
  {  //to-complete
      firstNode = null;
      lastNode = null;
      numNodes = 0;
  }

 /**
  * List out all entries in this queue
  */
  public void display()
  {  //to-complete
      if(isEmpty())
      {
          System.out.println("Queue is empty...");
      }
      else
      {
           Node n = firstNode;
           while(n != null)
           {
            System.out.print(n.data);
            n = n.next;
           }
           System.out.println();
      }
  } 
}

