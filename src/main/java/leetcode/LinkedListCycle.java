package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by
 * continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 * @author Alberto Battistini
 *  * @version 0.1
 *  * @since 0.1
 **/
public class LinkedListCycle {

    private static Set<ListNode> set = new HashSet<>();

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int n) {
            this.val = n;
        }
    }

    static boolean hasCycleUsingSet(ListNode head) { // space O(n)
        if (head == null)
            return false;
        ListNode p = head;
        set.add(p);
        while (p.next != null) {
            p = p.next;
            if (!set.add(p))
                return true;
        }
        return false;
    }

    static boolean hasCycle(ListNode head) { // space O(1) - 2 pointers
        if (head == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    public static void main(String args[]) {
        ListNode list = new ListNode(3);
        ListNode node1 = new ListNode(2);    // 3 -> 2 -> 0 -> -4
        ListNode node2 = new ListNode(0);    //      ^         /
        ListNode node3 = new ListNode(-4);   //       \_______/
        list.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next =  node1;

        System.out.println(hasCycle(list));
        System.out.println(hasCycleUsingSet(list));
    }
}
