package deque;

import org.junit.Test;

public class ArrayDequeTest {
    @Test
    public void testArrayDeque(){
        ArrayDeque<Integer> ad=new ArrayDeque<>();
        ad.addFirst(3);
        ad.addFirst(358);
        ad.addFirst(8);
        ad.addLast(96);
        ad.addLast(36);
        ad.addLast(98);
        ad.addLast(79);
        ad.addFirst(12);
        ad.addFirst(15);
        ad.printDeque();
        System.out.println(ad.size());
        System.out.println(ad.get(0));
        System.out.println(ad.get(1));
        System.out.println(ad.get(36));
        for (int i=0;i<10000;i+=1){
            ad.addFirst(i);
        }
        for (int i=10000;i>0;i-=1){
            ad.addLast(i);
            i-=1;
        }
        for (int i=0;i<5000;i+=1){
            ad.removeFirst();
        }
        for (int i=0;i<5000;i+=1){
            ad.removeLast();
        }
    }
}
