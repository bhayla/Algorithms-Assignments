
/**
*   Implementation of nodes for linked lists.
*   @author Kieran Herley
*/

class LLNode<EltType>
{   
   /**
   *   Create new node.
   */
   public LLNode()
   {  prev = null;
      next = null;
      elem = null;
   }
   
   /**
   *  Create new node, initialized with specified values.
   *  @param newNext--ref
   *  @param 
   */
   public LLNode(LLNode<EltType> newNext, EltType e)
   {  prev = null;
      next = newNext;
      elem = e;
   }

   
   /**
   *   Create new node, initialized with specified values.
   */
   public LLNode(LLNode<EltType> newPrev, LLNode<EltType> newNext, EltType e)
   {  prev = newPrev;
      next = newNext;
      elem = e;
   }


   /**
   *   Return element attached to node.   
   */
   public EltType element()
   {  return elem;
   }
   
   /**
   *   Return element attached to node.   
   */
   public EltType getElement()
   {  return elem;
   }

   /**
   *   Return position following this one.
   */
   public LLNode getNext() 
   {  return next;
   }

   /**
   *   Return position preceding this one.
   */
   public LLNode getPrev() 
   {   return prev;
   }

   /**
   *   Set sucessor reference to specified value.
   */   
   public void setNext(LLNode newNext)
   {   next = newNext;
   }

   /**
   *   Set predecessor reference to specified value.
   */   
   public void setPrev(LLNode newPrev)
   {   prev = newPrev;
   }

   /**
   *   Set node elem to specified value.
   */   
   public void setElement(EltType newelem)
   {   elem = newelem;
   }
   
   /* element stored in this node */   
   private EltType elem;  
   
   /* reference to the next node in the list */
   private LLNode<EltType>  next;
   
   /* reference to the next node in the list */
   private LLNode<EltType> prev; 
}
