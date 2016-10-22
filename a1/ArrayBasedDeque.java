public class ArrayBasedDeque<EltType> implements Deque<EltType>{
    
    private EltType theElt[];
    private static final int CAPACITY = 10;
    private static int currentCapacity;
    private static int f=0;
    private static int r=0;
    
    public ArrayBasedDeque(){
        theElt = (EltType[]) (new Object[CAPACITY]);
        currentCapacity = CAPACITY;
    }
    
    private void errorMessage(String message){
        System.out.println(message);
        System.exit(1);
    }
    
    @Override
    public int size(){
        return ((currentCapacity - f + r) % currentCapacity);
    }
    
    @Override
    public boolean isEmpty(){
        return (f == r);
    }
    
    @Override
    public EltType first(){
        if( isEmpty() ){
            errorMessage("Error: Array is empty");
        }
        return theElt[f];
    }
    
    @Override
    public EltType last(){
        if( isEmpty() ){
            errorMessage("Error: Array is empty");
        }
        return theElt[(r-1+currentCapacity) % currentCapacity];
    }
    
    @Override
    public void insertFirst(EltType obj){
        increaseFullArray();
        if( isEmpty() ){
             theElt[f] = obj;
             r = (r+1) % currentCapacity;
        }else{
             f = (f-1+currentCapacity)%currentCapacity;
             theElt[f] = obj;
        }
    }
    
    @Override
    public void insertLast(EltType obj){
        increaseFullArray();
        theElt[r] = obj;
        r = (r+1) % currentCapacity;
    }
    
    @Override
    public EltType removeLast(){
      EltType temp;
      r = (r-1+currentCapacity) % currentCapacity;
      temp = theElt[r];
      theElt[r] = null;
      return temp;
    }
    
    @Override
    public EltType removeFirst(){
      EltType temp;
      temp = theElt[f];
      theElt[f] = null;
      f = (f+1) % currentCapacity;
      return temp;
    }
    
    private void increaseFullArray(){
        if (size() == currentCapacity-1)
        { 
            EltType temp[] = (EltType[])(new Object[2*currentCapacity]);
            int newIndex = 0;
            for(int i = f; i != r; i= (i+1)%currentCapacity ){
                temp[newIndex] = theElt[i];
                newIndex++;
            }
            f=0;
            r=newIndex;
            theElt = temp;
            currentCapacity = currentCapacity*2;
        }
    }
    
    @Override public String toString(){ 
        String output = "["; 
        for(int index = f ; index != r;index = (index + 1) % currentCapacity){ 
            output += "{"+theElt[index] + "}"; 
        } 
        output += "]"; 
        return output; 
    }

    
}