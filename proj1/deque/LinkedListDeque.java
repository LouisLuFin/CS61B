package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Iterable<T>, Deque<T> {
    private final myDequeNode frontSentinel;
    private final myDequeNode backSentinel;
    private int size;

    public LinkedListDeque() {
        frontSentinel = new myDequeNode((T) "beginning", null, null);
        backSentinel = new myDequeNode((T) "ending", null, frontSentinel);
        frontSentinel.next = backSentinel;
        size = 0;
    }

    private void printNode(myDequeNode node) {
        System.out.println(node.item);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addFirst(T item) {
        this.insert(item, 0);
    }

    @Override
    public void addLast(T item) {
        this.insert(item, size);
    }

    @Override
    public T removeFirst() {
        return this.remove(0);
    }

    @Override
    public T removeLast() {
        return this.remove(-2);
    }

    private void insert(T item, int idx) {
        myDequeNode currNode = getNode(idx);
        myDequeNode prev_ptr = currNode.prev;
        myDequeNode newNode = new myDequeNode(item, currNode, prev_ptr);
        currNode.prev = newNode;
        prev_ptr.next = newNode;
        size += 1;
    }

    private T remove(int idx) {
        if (size == 0) {
            return null;
        } else {
            myDequeNode removedNode = getNode(idx);
            T removedItem = removedNode.item;
            myDequeNode prev_ptr = removedNode.prev;
            myDequeNode next_ptr = removedNode.next;
            prev_ptr.next = next_ptr;
            next_ptr.prev = prev_ptr;
            size -= 1;
            return removedItem;
        }
    }

    private myDequeNode getNode(int idx) {
        if (size != 0) {
            if (idx < 0) {
                idx = translateNegativeIndex(idx);
            }
            if (Math.abs(idx) > size) {
                throw new ArrayIndexOutOfBoundsException("Index out of bound, idx parameter should not exceed array size " + size);
            }

        }
        myDequeNode currNode;
        if (idx > size / 2) {
            currNode = backSentinel;
            for (int i = size; i > idx; i -= 1) {
                currNode = currNode.prev;
            }
        } else {
            currNode = frontSentinel.next;
            for (int i = 0; i < idx; i += 1) {
                currNode = currNode.next;
            }
        }
        return currNode;
    }

    @Override
    public T get(int idx) {
        if (idx > size - 1) {
            return null;
        } else {
            return getNode(idx).item;
        }
    }

    private myDequeNode getRecursiveNode(int idx) {
        if (idx == 0) {
            return this.frontSentinel.next;
        } else {
            return getRecursiveNode(idx - 1).next;
        }
    }

    public T getRecursive(int idx){
        return getRecursiveNode(idx).item;
    }


    private int translateNegativeIndex(int idx) {
        if (idx > 0) {
            throw new IllegalArgumentException("Positive Index Number should not enter translateNegativeIndex() method");
        }
        return size + 1 + idx;
    }

    @Override
    public void printDeque() {
        if (size() == 0) {
            System.out.println("Empty LinkedListDeque");
        } else {
            myDequeNode currentNode = frontSentinel.next;
            while (currentNode != backSentinel) {
                System.out.print(currentNode.item + " ");
                currentNode = currentNode.next;
            }
        }
        System.out.println("\n=============");
    }

    public boolean equals(Object o) {
        if (!(o instanceof LinkedListDeque)) {
            return false;
        } else {
            LinkedListDeque<T> o1 = (LinkedListDeque<T>) o;
            if (o1.size() != size) {
                return false;
            }
        }
        LinkedListDeque<T> o1 = (LinkedListDeque<T>) o;
        myDequeNode currNodeSelf = frontSentinel.next;
        for (int i = 0; i < size; i += 1) {
            if (!(currNodeSelf.item.equals(o1.get(i)))) {
                return false;
            }
            currNodeSelf = currNodeSelf.next;
        }
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    private class myDequeNode {
        public myDequeNode prev;
        public T item;
        public myDequeNode next;

        public myDequeNode(T i, myDequeNode n, myDequeNode p) {
            item = i;
            next = n;
            prev = p;
        }

    }

    private class LinkedListDequeIterator implements Iterator<T> {
        private final myDequeNode currPtr;

        public LinkedListDequeIterator() {
            currPtr = frontSentinel.next;
        }

        public boolean hasNext() {
            return (!(currPtr.next == backSentinel));
        }

        public T next() {
            if (hasNext()) {
                return currPtr.next.item;
            }
            return null;
        }
    }


}