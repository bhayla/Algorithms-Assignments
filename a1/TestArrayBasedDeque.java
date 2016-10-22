public class TestArrayBasedDeque{

    public static void main(String[] args){
        /*
        ArrayBasedDeque<Integer> array = new ArrayBasedDeque<>();

        array.insertFirst(3);
        array.insertFirst(5);
        System.out.println(array.removeFirst());
        array.insertLast(7);
        System.out.println( array.removeFirst() );
        System.out.println( array.removeLast() );
        array.first();
        */
        
        
        Deque<Integer> deque = new ArrayBasedDeque<Integer>();
        
        System.out.println("size = " + deque.size());
        deque.insertFirst(3);
        System.out.println(deque);
        System.out.println("size = " + deque.size());
        deque.insertLast(4);
        deque.insertFirst(2);
        deque.insertLast(5);
        deque.insertFirst(1);
        System.out.println(deque);
        System.out.println("first = "+deque.first());
        System.out.println("last = "+deque.last());
        System.out.println("size = "+deque.size());
       
        for(int i = 0;i<=100;i++){
            deque.insertFirst(i);
            deque.insertLast(i);
        }
        System.out.println(deque);
        System.out.println("size = "+deque.size());
        System.out.println("first = "+deque.first());
        System.out.println("last = "+deque.last());
       
        for(int i=0;i<207;i++){
            deque.removeFirst();
        } 

        System.out.println("size = " + deque.size());
        System.out.println(deque);
        System.out.println(deque.removeLast());

        for(int i=0;i<20;i++){
            deque.insertLast(i);
        }

        System.out.println(deque);
        System.out.println("remove 3 elements");
        int thirdLast = deque.removeLast();
        int secondLast = deque.removeLast();
        int lastInt = deque.removeLast();
        System.out.println(deque);
        System.out.println("last item removed was "+lastInt);
        System.out.println("second last was "+secondLast);
        System.out.println("third last was "+thirdLast);

        System.out.println(deque);
        System.out.println("removed 2 elements from front");
        int first = deque.removeFirst();
        int second = deque.removeFirst();
        System.out.println("first removed is "+first);
        System.out.println("second removed is "+second);
        System.out.println(deque);
         
    }

}