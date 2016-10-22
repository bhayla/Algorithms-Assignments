import java.util.Iterator;
/**
*   Array-based implementation for Iterator abstraction
*   @author Kieran Herley
*/
public class ArrayBasedIterator<EltType> 
             implements Iterator<EltType>
{
   /**
   *
   */
   public ArrayBasedIterator()
   {  elements = (EltType[]) (new Object[INIT_CAP]);
      capacity = INIT_CAP;
      nextElt = 0;
      numElts = 0;
   }
 
   /**
   *   Return true if this iterator has one or more
   *   elements in front of the nextElt.
   *   @return boolean non-emptiness indication
   */
   public boolean hasNext()
   { return (nextElt < numElts);
   }
   
   /**
   *   Remove and return the next element (in front of
   *   nextElt) from this iterator. Illegal if the list is 
   *   empty.
   *   @return a list elemnt
   */
   public EltType next()
   {  EltType retElt = elements[nextElt];
      nextElt++;
      return retElt;
   }
   
   /**
   *  Remove from underlying collection the element
   *  most recently returned by the iterator. Optional
   *  operation.
   */
   public void remove()
   {  System.out.println("ArrayBasedIterator: remove not supported");
      System.exit(1);
   }
   
   /**
   *  Add the specified element to the iterator.
   *  @param newElt--the element to be added
   */
   public void add(EltType newElt)
   {  expandIfNecessary();
      elements[numElts] = newElt;
      numElts++;
   }
   
   /*
   * If the array is full, double its capacity.
   */
   private void expandIfNecessary()
   {  if (numElts == capacity)   
         // copy array into one of larger size
      {
         EltType temp[] = 
            (EltType[])(new Object[2*capacity]);
         for (int i = 0; i < capacity; i++)
           temp[i] = elements[i];
         elements = temp;
         capacity = 2*capacity;
      }
   }
   
   private static final int  INIT_CAP = 100; // default initial capacity of the iterator
   private int capacity;               // current capacity of the iterator.
   private EltType elements[];         // the elements in the iterator
   private int numElts;               // the number of elements
   private int nextElt;               // the next element of the iterator
  
}
