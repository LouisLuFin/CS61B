package deque;

import java.util.Iterator;

public class LinkedListDeque<listType> implements Iterable<listType>, Deque<listType> {
    private final myDequeNode frontSentinel;
    private final myDequeNode backSentinel;
    private int size;

    public LinkedListDeque() {
        frontSentinel = new myDequeNode((listType) "beginning", null, null);
        backSentinel = new myDequeNode((listType) "ending", null, frontSentinel);
        frontSentinel.next = backSentinel;
        size = 0;
    }

    public void printNode(myDequeNode node) {
        System.out.println(node.item);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addFirst(listType item) {
        this.insert(item, 0);
    }

    @Override
    public void addLast(listType item) {
        this.insert(item, size);
    }

    @Override
    public listType removeFirst() {
        return this.remove(0);
    }

    @Override
    public listType removeLast() {
        return this.remove(-2);
    }

    public void insert(listType item, int idx) {
        myDequeNode currNode = getNode(idx);
        myDequeNode prev_ptr = currNode.prev;
        myDequeNode newNode = new myDequeNode(item, currNode, prev_ptr);
        currNode.prev = newNode;
        prev_ptr.next = newNode;
        size += 1;
    }

    public listType remove(int idx) {
        if (size == 0) {
            return null;
        } else {
            myDequeNode removedNode = getNode(idx);
            listType removedItem = removedNode.item;
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
    public listType get(int idx) {
        if (idx > size - 1) {
            return null;
        } else {
            return getNode(idx).item;
        }
    }

    public myDequeNode getRecursive(int idx) {
        if (idx == 0) {
            return this.frontSentinel.next;
        } else {
            return getRecursive(idx - 1).next;
        }
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
            LinkedListDeque<listType> o1 = (LinkedListDeque<listType>) o;
            if (o1.size() != size) {
                return false;
            }
        }
        LinkedListDeque<listType> o1 = (LinkedListDeque<listType>) o;
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
    public Iterator<listType> iterator() {
        return new LinkedListDequeIterator();
    }

    private class myDequeNode {
        public myDequeNode prev;
        public listType item;
        public myDequeNode next;

        public myDequeNode(listType i, myDequeNode n, myDequeNode p) {
            item = i;
            next = n;
            prev = p;
        }

    }

    private class LinkedListDequeIterator implements Iterator<listType> {
        private final myDequeNode currPtr;

        public LinkedListDequeIterator() {
            currPtr = frontSentinel.next;
        }

        public boolean hasNext() {
            return (!(currPtr.next == backSentinel));
        }

        public listType next() {
            if (hasNext()) {
                return currPtr.next.item;
            }
            return null;
        }
    }


}