package org.dsa.slowfastpointer;

import org.dsa.slowfastpointer.linkedList.LinkedList;
import org.dsa.slowfastpointer.linkedList.LinkedListNode;

public class LinkedListPalindrome {
    public static boolean palindrome(LinkedListNode head) {
        LinkedList linkedList = new LinkedList();

        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        LinkedListNode reverse = linkedList.reverse(slow);

        boolean result = compareLinkedLists(head,reverse);
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        int[] nodes = new int[]{4,7,9,5,4};
        linkedList.createLinkedList(nodes);
        palindrome(linkedList.getHead());
    }

    public static boolean compareLinkedLists(LinkedListNode head, LinkedListNode reverse) {
        while (head != null && reverse != null) {
            if (head.getData() != reverse.getData()) {
                return false;
            }

            head = head.next;
            reverse = reverse.next;
        }

        return true;
    }
}
