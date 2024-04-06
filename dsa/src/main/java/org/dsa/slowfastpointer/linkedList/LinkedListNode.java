package org.dsa.slowfastpointer.linkedList;

public class LinkedListNode {
    private int data;
    public LinkedListNode next;

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}
