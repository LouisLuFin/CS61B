package deque;

import java.util.Comparator;

public class MaxArrayComparator<T> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        if (this.minus(o1, o2) < 0) {
            return -1;
        } else if (this.minus(o1, o2) > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public <T> Double minus(T t1, T t2) {
        if (t1 instanceof Number && t2 instanceof Number ) {
            Double ALTt1 = (Double) t1;
            Double ALTt2 = (Double) t2;
            Double all = ALTt1.doubleValue() - ALTt2.doubleValue();
            return all;
        } else {
            return 0.0;
        }
    }
}

