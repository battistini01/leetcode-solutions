package leetcode;

/**
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 */
public class RemoveNthNodeFromEndOfList {

    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        ListNode node = head;
        int n_next = remove_rec(node, n);
        if (n_next == n) {
            return head.next;
        }
        return head;
    }

    static int remove_rec(ListNode node, int n) {
        if (node.next == null)
            return 1;
        int n_next = remove_rec(node.next, n);
        // found node to remove: jump to next (or null if not present)
        if (n_next == n) {
            node.next = node.next.next;
        }
        return n_next + 1;
    }

    static void printList(ListNode list) {
        System.out.print("Output: [");
        while (list != null) {
            System.out.print(list.val);
            list = list.next;
            if (list != null) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        list = removeNthFromEnd(list, 2);
        printList(list);
        System.out.println("Expected: [1, 2, 3, 5]");
    }
}
