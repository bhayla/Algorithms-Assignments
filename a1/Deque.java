public interface Deque<EltType>{
    
    public EltType first();
    public EltType last();
    public void insertFirst(EltType obj);
    public void insertLast(EltType obj);
    public EltType removeLast();
    public EltType removeFirst();
    public int size();
    public boolean isEmpty();

}