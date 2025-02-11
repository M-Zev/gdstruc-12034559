class SinglyLinkedList<T> {

    private class ArrayThing {
        T data;
        ArrayThing next;

        ArrayThing(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private ArrayThing firstItem;
    private int size;

    public SinglyLinkedList() {
        this.firstItem = null;
        this.size = 0;
    }

    public void add(T data) {
        ArrayThing newNode = new ArrayThing(data);
        if (firstItem == null) {
            firstItem = newNode;
            size++;
            return;
        }

        ArrayThing current = firstItem;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        size++;
    }

    public void removeFirst() {
        if (firstItem == null) return;
        firstItem = firstItem.next;
        size--;
    }

    public int size() {
        return size;
    }

    public boolean contains(T data) {
        ArrayThing current = firstItem;
        while (current != null) {
            if (current.data.equals(data)) return true;
            current = current.next;
        }
        return false;
    }

    public int indexOf(T data) {
        ArrayThing current = firstItem;
        int index = 0;
        while (current != null) {
            if (current.data.equals(data)) return index;
            current = current.next;
            index++;
        }
        return -1;
    }
}

class DoublyLinkedList<T> {

    private class doubleArrayThing {
        T data;
        doubleArrayThing next, prev;

        doubleArrayThing(T data) {
            this.data = data;
            this.next = this.prev = null;
        }
    }

    private doubleArrayThing firstItem, lastItem;
    private int size;

    public DoublyLinkedList() {
        this.firstItem = this.lastItem = null;
        this.size = 0;
    }

    public void add(T data) {
        doubleArrayThing newDoubleArrayThing = new doubleArrayThing(data);
        if (firstItem == null) {
            firstItem = lastItem = newDoubleArrayThing;
            size++;
            return;
        }

        lastItem.next = newDoubleArrayThing;
        newDoubleArrayThing.prev = lastItem;
        lastItem = newDoubleArrayThing;
        size++;
    }

    public void removeFirst() {
        if (firstItem == null) return;
        firstItem = firstItem.next;
        if (firstItem != null) firstItem.prev = null;
        else lastItem = null;
        size--;
    }

    public int size() {
        return size;
    }
}
