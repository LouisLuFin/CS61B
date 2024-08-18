package deque;

import java.util.Comparator;

public class MaxArrayDeque<T extends Number> extends ArrayDeque<T> {
    int size = size();
    private final Comparator<T> maxArrayComparator;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        maxArrayComparator = c;
    }

    public T max() {
        size = size();
        if (size == 0) {
            return null;
        }
        T maxItem = get(0);
        for (int i = 0; i < size; i += 1) {
            if (maxArrayComparator.compare(maxItem, get(i)) < 0) {
                maxItem = get(i);
            }
        }
        return maxItem;
    }

    public T max(Comparator<T> c) {
        size = size();
        if (size == 0) {
            return null;
        }
        T maxItem = get(0);
        for (int i = 0; i < size; i += 1) {
            if (c.compare(maxItem, get(i)) > 0) {
                maxItem = get(i);
            }
        }
        return maxItem;
    }

    public Comparator<T> getMaxArrayComparator() {
        return new MaxArrayComparator<>();
    }
}




