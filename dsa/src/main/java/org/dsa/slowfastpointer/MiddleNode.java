package org.dsa.slowfastpointer;

import org.dsa.slowfastpointer.linkedList.LinkedList;
import org.dsa.slowfastpointer.linkedList.LinkedListNode;

public class MiddleNode {
    public static LinkedListNode middleNode(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("Middle node is" + slow.getData());
        return slow;
    }

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        int[] nodes = new int[]{6,5,4,3,2,1};
        linkedList.createLinkedList(nodes);
        middleNode(linkedList.getHead());
    }
}
