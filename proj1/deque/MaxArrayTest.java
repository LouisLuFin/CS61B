package deque;

import org.junit.Test;


public class MaxArrayTest {
    @Test
    public void testMaxArray() {
        MaxArrayComparator<Integer> c = new MaxArrayComparator<>();
        MaxArrayDeque<Integer> ad = new MaxArrayDeque<>(c);
        ad.addFirst(3);
        ad.addFirst(358);
        ad.addFirst(8);
        ad.addLast(96);
        ad.addLast(36);
        ad.addLast(45156);
        ad.addLast(79);
        ad.addFirst(12);
        ad.addFirst(15);
        ad.addFirst(1545);
        ad.addLast(9458);
        ad.addFirst(1545);
        System.out.println(ad.max());
        ad.printDeque();
    }


    @Test
    public void testMaxArray1() {
        MaxArrayComparator<Integer> c = new MaxArrayComparator<>();
        MaxArrayDeque<Integer> acc=new MaxArrayDeque<>(c);
        System.out.println(acc.max());
        String aaa="wbqudqf";
        String bbb="ewuifgbwebfWEBFBEWFWENRFWKnfewbfnwebf";
        String ccc="ewdj";
        System.out.println(aaa.compareTo(bbb));
        System.out.println(aaa.compareTo(ccc));
    }



}
