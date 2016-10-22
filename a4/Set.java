import java.util.Iterator;
/**
*   Interface for set  abstraction.
*   @author Kieran Herley
*/
public interface Set<EltType>
       extends java.lang.Iterable<EltType>
{         
   /**
   *   Return true if this set contains no elements.
   *   @return boolean emptiness indication
   */
   public boolean isEmpty();
   
   /**
    *   Return the number of elements in this set 
    *   (i.e. its cardinality). 
    *   @return size of set
   */   
   public int size();
   
   /**
   *   Add the specified element to this set if it is 
   *   not already present. If this set already contains
   *   the specified element, the call leaves this set unchanged
   *   @param newElement - element to be added to this set.
   */
   public void add(EltType newElement);
   
   /**
   *   Add all of the elements in the set addSet to this 
   *   set if they're not already present. The addAll operation 
   *   effectively modifies this set so that its value is the 
   *   union of the two sets.
   *   @param addSet-- the elements to be added
   */
   public void addAll(Set<EltType> addSet);
   
   /**
   *   Return true if this set contains the specified element
   *   i.e. if checkElement is a member of this set.
   *   @param checkElement-the candidate member
   *   @return boolean membership indication
   */
   public boolean contains(EltType checkElement);
   
   /**
   *   Return true if this set contains all of the elements 
   *   of the specified set i.e. returns true if it is a subset 
   *   of this set.
   *   @param checkSet-- the candidate subset
   *   @return boolean subset indication
   */ 
   public boolean containsAll(Set<EltType> checkSet);
   
   /**
   *   Remove the specified element from this set if it is 
   *   present. 
   *   @param remElement-- the element to be removed
   */
   public void remove(EltType remElement);
   
   /**
   *   Remove from this set all of its elements that are 
   *   contained in the specified set. This operation 
   *   effectively modifies this set so that its value is 
   *   the asymmetric set difference of the two sets.
   *   @param remSet-- the elements to be removed
   */
   public void removeAll(Set<EltType> remSet);
   
   /**
   *   Retain only the elements in this set that are 
   *   contained in the specified set. This operation 
   *   effectively modifies this set so that its value 
   *   is the intersection of the two sets.
   *   @param retSet-- the elemnets to be retained
   */
   public void retainAll(Set<EltType> retSet);
   
   /**
   *   Return a list of the elements in this set. 
   *   The elements are returned in no particular order .
   *   @return the elements of this set
   *
   */
   public Iterator<EltType> elements();
   
   /**
   *   Return a list of the elements in this set. 
   *   The elements are returned in no particular order .
   *   @return the elements of this set
   *
   */
   public Iterator<EltType> iterator();
   

}
