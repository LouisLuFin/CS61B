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
        ad.addLast(98);
        ad.addLast(79);
        ad.addFirst(12);
        ad.addFirst(15);
        ad.addFirst(1545);
        ad.addLast(9458);
        ad.max();
        System.out.println(ad.max());
        ad.printDeque();

        MaxArrayComparator<String> a = new MaxArrayComparator<>();



    }

}
