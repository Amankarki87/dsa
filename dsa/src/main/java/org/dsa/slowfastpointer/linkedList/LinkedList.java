package org.dsa.slowfastpointer.linkedList;

public class LinkedList {
    private LinkedListNode head;

    public LinkedListNode getHead() {
        return head;
    }

    public LinkedList() {
        this.head = null;
    }

    public void insertNodeAtHead(LinkedListNode node) {
        if (this.head == null) {
            this.head = node;
//            System.out.println(this.head.getData());
        } else {
            node.setNext(this.head);
            this.head = node;
//            System.out.println(this.head.getData());
        }
    }

    public void createLinkedList(int[] nodes) {
        for (int i = 0; i < nodes.length; i++) {
            LinkedListNode node = new LinkedListNode(nodes[i]);
            insertNodeAtHead(node);
        }
    }

    public LinkedListNode reverse(LinkedListNode newHead) {
        LinkedListNode curr = newHead;
        LinkedListNode prev = null;
        LinkedListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
