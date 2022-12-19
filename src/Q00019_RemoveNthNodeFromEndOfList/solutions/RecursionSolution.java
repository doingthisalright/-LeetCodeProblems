package Q00019_RemoveNthNodeFromEndOfList.solutions;

import Q00019_RemoveNthNodeFromEndOfList.ListNode;

public class RecursionSolution implements Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int currentNodePosition = removeNthFromEndUtil(head, n);
        if (currentNodePosition == n) {
            return head.next;
        }

        return head;
    }

    private int removeNthFromEndUtil(ListNode head, int n) {
        if (head.next == null) {
            return 1;
        }

        int currentNodePosition = removeNthFromEndUtil(head.next, n) + 1;

        if (currentNodePosition == n + 1) {
            head.next = head.next.next;
        }

        return currentNodePosition;
    }

    public String solutionDescription() {
        return "Bonus - Recursion based Solution";
    }
}
