package Q2AddTwoNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2AddTwoNumbers {
    public static void main(String[] args) {
        final ListNode l1Node3 = new ListNode(3);
        final ListNode l1Node2 = new ListNode(4, l1Node3);
        final ListNode l1Node1 = new ListNode(2, l1Node2);

        final ListNode l2Node3 = new ListNode(4);
        final ListNode l2Node2 = new ListNode(6, l2Node3);
        final ListNode l2Node1 = new ListNode(5, l2Node2);

        ListNode output = new Solution().addTwoNumbers(l1Node1, l2Node1);
        final List<Integer> expectedOutput = Arrays.asList(7, 0, 8);

        final List<Integer> result = new ArrayList<>();
        while (output != null) {
            result.add(output.val);
            output = output.next;
        }


        if (result.equals(expectedOutput)) {
            System.out.printf("Pass! Output: %s%n", result);
        } else {
            throw new RuntimeException(String.format("Wrong output: %s. Expected %s%n", result, expectedOutput));
        }
    }
}
