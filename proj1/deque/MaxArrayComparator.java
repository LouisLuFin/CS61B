package deque;

import java.util.Comparator;

public class MaxArrayComparator<T> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(this.minus(o1, o2), 0);
    }

    public <T> int minus(T t1, T t2) {
        if (t1 instanceof Comparable && t2 instanceof Comparable) {
            return ((Comparable<T>) t1).compareTo(t2);
        }else {
            return 0;
        }
    }
}

