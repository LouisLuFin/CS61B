package deque;

import java.util.Comparator;

public class MaxArrayComparator<T> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        if (o1 instanceof Comparable && o2 instanceof Comparable) {
            return ((Comparable<T>) o1).compareTo(o2);
        }
        return 0;
    }
}

