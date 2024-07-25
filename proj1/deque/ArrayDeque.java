package deque;

public class ArrayDeque<listType> {
    private listType[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    private int UnitSize=8;
    private final int sizeMultiplier =10;

    private final int minUnitSize=8;

    public ArrayDeque(){
        items=(listType[]) new Object[UnitSize];
        for (int i=0;i< items.length;i+=1){
            items[i]=null;
        }
        size=0;
        nextFirst=2;
        nextLast=3;
    }

    private void expandSize(int capacity){
        if (size!=UnitSize){
            throw new IllegalArgumentException("items not full yet, should not call expandSize()");
        }
        listType[] a=(listType[]) new Object[capacity];
        for (int i=0;i< a.length;i+=1){
            a[i]=null;
        }
        int first=nextFirst+1;
        if (first>= items.length){
            first=0;
        }
        int curridx=first;
        int destPos=(sizeMultiplier /2-1)*UnitSize;
        for (int i=0;i<size;i+=1){
            a[destPos]=items[curridx];
            curridx += 1;
            if (curridx >= items.length) {
                curridx = 0;
            }
            destPos+=1;
        }
        items=a;
        nextFirst=(sizeMultiplier /2-1)*UnitSize-1;
        nextLast= destPos;
        UnitSize=UnitSize* sizeMultiplier;
    }

    private void extractSize() {
        int capacity;
        if (items.length / sizeMultiplier *6 >= minUnitSize && size< items.length/ sizeMultiplier *6) {
            capacity = items.length / sizeMultiplier *6;
        } else {
            throw new IllegalArgumentException("capacity below minimum Unit Size or larger than 60% of original length, should not call extractSize()");
        }

        listType[] a = (listType[]) new Object[capacity];
        for (int i = 0; i < a.length; i += 1) {
            a[i] = null;
        }
        int first = nextFirst + 1;
        if (first >= items.length) {
            first = 0;
        }
        int curridx = first;
        int destPos = UnitSize/sizeMultiplier;
        for (int i = 0; i < size; i += 1) {
            a[destPos] = items[curridx];
            curridx += 1;
            if (curridx >= items.length) {
                curridx = 0;
            }
            destPos += 1;
        }
        items = a;
        nextFirst = UnitSize/sizeMultiplier-1;
        nextLast = destPos;
        UnitSize = UnitSize / sizeMultiplier*6;
    }

    public listType removeFirst(){
        if (size<=0){
            return null;
        }
        if (size-1<UnitSize/sizeMultiplier*4 && UnitSize>8){
            extractSize();
        }
        nextFirst+=1;
        if (nextFirst>=UnitSize){
            nextFirst=0;
        }
        listType ret_val=items[nextFirst];
        items[nextFirst]=null;
        size-=1;
        return ret_val;
    }

    public listType removeLast(){
        if (size<=0){
            return null;
        }
        if (size-1<UnitSize/sizeMultiplier*4 && UnitSize>8){
            extractSize();
        }
        nextLast-=1;
        if (nextLast<0){
            nextLast=items.length-1;
        }
        listType ret_val=items[nextLast];
        items[nextLast]=null;
        size-=1;
        return ret_val;
    }


    public int size(){
        return size;
    }

    public listType get(int index){
        index=nextFirst+1+index;
        if (index>=UnitSize){
            index=index-UnitSize;
        }
        return items[index];
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public void addLast(listType added){
        if (size==UnitSize){
            this.expandSize(sizeMultiplier *UnitSize);
        }
        items[nextLast]=added;
        size+=1;
        nextLast+=1;
        if (nextLast>=items.length){
            nextLast=0;
        }
    }

    public void addFirst(listType added){
        if (size==UnitSize){
            this.expandSize(sizeMultiplier *UnitSize);
        }
        items[nextFirst]=added;
        size+=1;
        nextFirst-=1;
        if (nextFirst<0){
            nextFirst=UnitSize-1;
        }
    }


    public void printDeque(){
        int first=nextFirst+1;
        if (first>= items.length){
            first=0;
        }

        int curridx=first;
        for (int i=0;i<size;i+=1){
            System.out.print(items[curridx]+" ");
            curridx+=1;
            if (curridx>=items.length){
                curridx=0;
            }
        }
        System.out.println("\n==============");
    }

}
