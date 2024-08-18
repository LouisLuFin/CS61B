package deque;

import java.util.Comparator;

public class MaxArrayDeque<listType extends Number> extends ArrayDeque<listType>  {
    private Comparator<listType> maxArrayComparator;
    int size=size();
    public MaxArrayDeque(Comparator<listType> c){
        super();
        maxArrayComparator=c;
    }

    public listType max(){
        size=size();
        if (size==0){
            return null;
        }
        listType maxItem=get(0);
        for (int i=0;i<size;i+=1){
            if (maxArrayComparator.compare(maxItem,get(i))<0){
                maxItem=get(i);
            }
        }
        return maxItem;
    }
    public listType max(Comparator<listType> c){
        size=size();
        if (size==0){
            return null;
        }
        listType maxItem=get(0);
        for (int i=0;i<size;i+=1){
            if (c.compare(maxItem,get(i))>0){
                maxItem=get(i);
            }
        }
        return maxItem;
    }

    public Comparator<listType> getMaxArrayComparator(){
        return new MaxArrayComparator<>();
    }
}




