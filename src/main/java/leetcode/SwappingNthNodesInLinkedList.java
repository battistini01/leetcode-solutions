package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * You are given the head of a linked list, and an integer k.
 *
 * Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node
 * from the end (the list is 1-indexed).
 *
 * Example:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [1,4,3,2,5]
 * Example 2:
 *
 * Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * Output: [7,9,6,6,8,7,3,0,9,5]
 * Example 3:
 *
 * Input: head = [1], k = 1
 * Output: [1]
 * Example 4:
 *
 * Input: head = [1,2], k = 1
 * Output: [2,1]
 * Example 5:
 *
 * Input: head = [1,2,3], k = 2
 * Output: [1,2,3]
 */
public class SwappingNthNodesInLinkedList {

    private static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Solution 1: converting in array and then swapping
    public ListNode swapNodesArray(ListNode head, int k) {
        if (head == null) return head;
        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        int size = nums.size();
        int val_p = nums.get(k-1);
        int val_q = nums.get(size - k);

        nums.set(k-1, val_q);
        nums.set(size-k, val_p);

        int i = 0;
        head = new ListNode();
        ListNode p = head;
        while (i < nums.size()) {
            p.next = new ListNode(nums.get(i));
            p = p.next;
            i++;
        }

        return head.next;
    }

    // Solution 2: O(n) time O(1) space - 2 pointers solution
    public static ListNode swapNodes(ListNode head, int k) {
        if (head == null) return head;
        int size = size(head);
        ListNode n1 = getNthNode(head, k);
        ListNode n2 = getNthNode(head, size - k + 1);
        swap(n1, n2);
        return head;
    }

    private static void swap(ListNode n1, ListNode n2) {
        int temp = n2.val;
        n2.val = n1.val;
        n1.val = temp;
    }

    private static ListNode getNthNode(ListNode head, int c) {
        while (c > 1) {
            head = head.next;
            c--;
        }
        return head;
    }

    private static int size(ListNode head) {
        if (head == null)
            return 0;
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("Before swapping: ");
        ListNode n = list;
        while (n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
        System.out.println();

        list = swapNodes(list, 2);

        System.out.println("After swapping: ");
        while (list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
        System.out.println();
    }
}
