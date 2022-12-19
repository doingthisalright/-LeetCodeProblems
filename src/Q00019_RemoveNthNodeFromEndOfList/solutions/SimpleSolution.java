package Q00019_RemoveNthNodeFromEndOfList.solutions;

import Q00019_RemoveNthNodeFromEndOfList.ListNode;

public class SimpleSolution implements Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        int size = 0;
        while (current != null) {
            current = current.next;
            size++;
        }

        int nodeToDelete = size - n;

        if (nodeToDelete == 0) {
            return head.next;
        }

        current = head;
        while (nodeToDelete != 1) {
            current = current.next;
            nodeToDelete--;
        }

        current.next = current.next.next;

        return head;
    }

    public String solutionDescription() {
        return "Simple Solution - Double Iteration";
    }
}
