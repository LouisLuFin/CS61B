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
            Number ALTt1 = (Number) t1;
            Number ALTt2 = (Number) t2;
            Double all = ALTt1.doubleValue() - ALTt2.doubleValue();
            return all;
        } else if (t1 instanceof String && t2 instanceof String ){
            String ALTt1 = (String) t1;
            String ALTt2 = (String) t2;
            int ret=ALTt1.length()-ALTt2.length();
            return (double)ret;
        }else{
            return 0.0;
        }
    }
}

