package deque;

public class ArrayDeque<listType> {
    private listType[] items;
    private int size;

    public ArrayDeque(){
        items=(listType[]) new Object[8];
        size=0;
    }

    private void resize(int capacity){
        listType[] a=(listType[]) new Object[capacity];
        System.arraycopy(items,0,a,0,size);
        items=a;
    }


}
