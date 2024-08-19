package deque;

import org.junit.Test;

public class ArrayDequeTest {
    @Test
    public void testArrayDeque(){
        ArrayDeque<Integer> ad=new ArrayDeque<>();
        ArrayDeque<Integer> adAlt=new ArrayDeque<>();
        ad.addFirst(3);
        ad.addFirst(358);
        ad.addFirst(8);
        ad.addLast(96);
        ad.addLast(36);
        ad.addLast(98);
        ad.addLast(79);
        ad.addFirst(12);
        ad.addFirst(15);
        adAlt.addFirst(3);
        adAlt.addFirst(358);
        adAlt.addFirst(8);
        adAlt.addLast(96);
        adAlt.addLast(36);
        adAlt.addLast(98);
        adAlt.addLast(79);
        adAlt.addFirst(12);
        adAlt.addFirst(15);
        adAlt.printDeque();

        for (int i=0;i<10000;i+=1){
            ad.addFirst(i);
            adAlt.addFirst(i);
        }
        for (int i=10000;i>0;i-=1){
            ad.addLast(i);
            adAlt.addLast(i);
        }
        for (int i=0;i<5000;i+=1){
            ad.removeFirst();
            adAlt.removeFirst();
        }
        System.out.println(ad.equals(adAlt));
    }

    @Test
    public void testArrayDeque2(){
        ArrayDeque<Integer> ad=new ArrayDeque<>();
        ad.addLast(0);
        ad.addFirst(1);
        ad.addFirst(2);
        ad.removeLast();
        ad.addFirst(4);
        ad.addFirst(5);
        ad.addFirst(6);
        ad.addFirst(7);
        ad.get(0);
        ad.addFirst(9);
        ad.removeLast();
        ad.get(4);
        ad.addLast(12);
        ad.addLast(13);
        ad.printDeque();
        ad.addFirst(14);
    }
}


