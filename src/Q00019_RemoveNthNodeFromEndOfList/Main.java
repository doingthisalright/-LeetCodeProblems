package Q00019_RemoveNthNodeFromEndOfList;

import Q00019_RemoveNthNodeFromEndOfList.solutions.RecursionSolution;
import Q00019_RemoveNthNodeFromEndOfList.solutions.SimpleSolution;
import Q00019_RemoveNthNodeFromEndOfList.solutions.SingleIterationSolution;
import Q00019_RemoveNthNodeFromEndOfList.solutions.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(final String[] args) {
        runTestCase(
                new int[]{ 1, 2, 3, 4, 5 },
                2,
                new int[]{ 1, 2, 3, 5 }
        );
        runTestCase(
                new int[]{ 1, 2 },
                1,
                new int[]{ 1 }
        );
    }

    private static void runTestCase(int[] inputArray, int n, int[] expectedOutput) {
        final List<Solution> solutionOptions = Arrays.asList(
                new SimpleSolution(),
                new SingleIterationSolution(),
                new RecursionSolution()
        );
        solutionOptions.forEach(solution -> {
            final ListNode actualOutput = solution.removeNthFromEnd(createLinkedList(inputArray), n);

            final int[] actualOutputAsArray = extractIntFromLinkedList(actualOutput);

            System.out.println("------------------------------");
            System.out.println("Solution Type: " + solution.solutionDescription());
            System.out.format("Input list = %s, n = %s. Expected output = %s\n", Arrays.toString(inputArray), n, Arrays.toString(expectedOutput));
            if (Arrays.equals(actualOutputAsArray, expectedOutput)) {
                System.out.format("Correct answer!\n");
            } else {
                System.out.format("Wrong answer. Your answer %s\n", Arrays.toString(actualOutputAsArray));
            }
        });
    }

    private static ListNode createLinkedList(final int[] input) {
        ListNode previousNode = null;
        for (int loop = input.length - 1; loop >= 0; loop--) {
            final ListNode currentNode = new ListNode(input[loop]);
            currentNode.next = previousNode;
            previousNode = currentNode;
        }
        return previousNode;
    }

    private static int[] extractIntFromLinkedList(ListNode input) {
        final List<Integer> data = new ArrayList<>();
        while (input != null) {
            data.add(input.val);
            input = input.next;
        }
        return data.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}