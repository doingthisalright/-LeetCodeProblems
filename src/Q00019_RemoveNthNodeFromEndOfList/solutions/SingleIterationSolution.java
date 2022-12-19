package Q00019_RemoveNthNodeFromEndOfList.solutions;

import Q00019_RemoveNthNodeFromEndOfList.ListNode;

public class SingleIterationSolution implements Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (n != 0) {
            fastPointer = fastPointer.next;
            n--;
        }

        if (fastPointer == null) {
            return head.next;
        }

        while (fastPointer.next != null) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }

        slowPointer.next = slowPointer.next.next;

        return head;
    }

    public String solutionDescription() {
        return "Single Iteration Solution";
    }
}
