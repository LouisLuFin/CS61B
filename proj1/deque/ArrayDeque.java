package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Iterable<T>, Deque<T> {
    private final int sizeMultiplier = 2;
    private final int minUnitSize = 8;
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int unitSize = 8;

    public ArrayDeque() {
        items = (T[]) new Object[unitSize];
        for (int i = 0; i < items.length; i += 1) {
            items[i] = null;
        }
        size = 0;
        nextFirst = 2;
        nextLast = 3;
    }

    private void expandSize(int capacity) {
        if (size != unitSize) {
            throw new IllegalArgumentException("items not full yet, should not call expandSize()");
        }
        T[] a = (T[]) new Object[capacity];
        for (int i = 0; i < a.length; i += 1) {
            a[i] = null;
        }
        int first = nextFirst + 1;
        if (first >= items.length) {
            first = 0;
        }
        int curridx = first;
        int destPos = 0;
        for (int i = 0; i < size; i += 1) {
            a[destPos] = items[curridx];
            curridx += 1;
            if (curridx >= items.length) {
                curridx = 0;
            }
            destPos += 1;
        }
        items = a;
        nextFirst = -1;
        nextLast = destPos;
        nextFirst = idxTurnAroundCheck(nextFirst);
        nextLast = idxTurnAroundCheck(nextLast);
        unitSize = unitSize * sizeMultiplier;
    }

    private void extractSize() {
        int capacity;
        if (items.length / sizeMultiplier >= minUnitSize && size <= items.length / sizeMultiplier) {
            capacity = items.length / sizeMultiplier;
        } else {
            throw new IllegalArgumentException("capacity too small or large, no extractSize()");
        }

        T[] a = (T[]) new Object[capacity];
        for (int i = 0; i < a.length; i += 1) {
            a[i] = null;
        }
        int first = nextFirst + 1;
        if (first >= items.length) {
            first = 0;
        }
        int curridx = first;
        int destPos = 2;
        for (int i = 0; i < size; i += 1) {
            a[destPos] = items[curridx];
            curridx += 1;
            if (curridx >= items.length) {
                curridx = 0;
            }
            destPos += 1;
        }
        items = a;
        nextFirst = 1;
        nextLast = destPos;
        nextFirst = idxTurnAroundCheck(nextFirst);
        nextLast = idxTurnAroundCheck(nextLast);
        unitSize = unitSize / sizeMultiplier;
    }

    @Override
    public T removeFirst() {
        if (size <= 0) {
            return null;
        }
        if (size - 1 < unitSize / sizeMultiplier - 3 && unitSize > minUnitSize) {
            extractSize();
        }
        nextFirst += 1;
        if (nextFirst >= unitSize) {
            nextFirst = 0;
        }
        T retVal = items[nextFirst];
        items[nextFirst] = null;
        size -= 1;
        return retVal;
    }

    @Override
    public T removeLast() {
        if (size <= 0) {
            return null;
        }
        if (size - 1 < unitSize / sizeMultiplier - 3 && unitSize > minUnitSize) {
            extractSize();
        }
        nextLast -= 1;
        if (nextLast < 0) {
            nextLast = items.length - 1;
        }
        T retVal = items[nextLast];
        items[nextLast] = null;
        size -= 1;
        return retVal;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        index = nextFirst + 1 + index;
        if (index >= unitSize) {
            index = index - unitSize;
        }
        return items[index];
    }


    @Override
    public void addLast(T added) {
        if (size == unitSize) {
            this.expandSize(sizeMultiplier * unitSize);
        }
        items[nextLast] = added;
        size += 1;
        nextLast += 1;
        if (nextLast >= items.length) {
            nextLast = 0;
        }
    }

    @Override
    public void addFirst(T added) {
        if (size == unitSize) {
            this.expandSize(sizeMultiplier * unitSize);
        }
        items[nextFirst] = added;
        size += 1;
        nextFirst -= 1;
        if (nextFirst < 0) {
            nextFirst = unitSize - 1;
        }
    }


    @Override
    public void printDeque() {
        int first = nextFirst + 1;
        if (first >= items.length) {
            first = 0;
        }

        int curridx = first;
        for (int i = 0; i < size; i += 1) {
            System.out.print(items[curridx] + " ");
            curridx += 1;
            if (curridx >= items.length) {
                curridx = 0;
            }
        }
        System.out.println("\n==============");
    }


    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    public boolean equals(Object o) {
        Deque<T> o1;
        if (o == null) {
            return false;
        }
        if (!(o instanceof Deque)) {
            return false;
        } else if (o instanceof ArrayDeque) {
            o1 = (ArrayDeque) o;
        } else if (o instanceof LinkedListDeque) {
            o1 = (LinkedListDeque) o;
        } else {
            return false;
        }
        if (o1.size() != size) {
            return false;
        }

        for (int i = 0; i < size; i += 1) {
            if (!(this.get(i).equals(o1.get(i)))) {
                return false;
            }
        }
        return true;
    }


    private int idxTurnAroundCheck(int idx) {
        if (idx < 0) {
            return items.length + idx;
        }
        if (idx > items.length - 1) {
            return idx - items.length;
        }
        return idx;
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int currPtr;
        private int lastMark;

        ArrayDequeIterator() {
            currPtr = nextFirst + 1;
            if (currPtr >= items.length) {
                currPtr = 0;
            }
        }

        public boolean hasNext() {
            return (!(currPtr == nextLast));
        }

        public T next() {
            T returnItem = items[currPtr];
            currPtr += 1;
            if (currPtr >= items.length) {
                currPtr = 0;
            }
            return returnItem;
        }

    }

}
