package deque;

import java.util.Comparator;

public class MaxArrayComparator<listType extends Number> implements Comparator<listType> {
    @Override
    public int compare(listType o1,listType o2){
        if (this.minus(o1,o2) <0){
            return -1;
        } else if (this.minus(o1,o2) >0) {
            return 1;
        }else {
            return 0;
        }
    }
    public <listType extends Number>Double minus(listType t1,listType t2){
        Double all=t1.doubleValue()-t2.doubleValue();
        return all;
    }

}
