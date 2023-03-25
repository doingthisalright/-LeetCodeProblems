package Q00102_BinaryTreeLevelOrderTraversal;

import Q00102_BinaryTreeLevelOrderTraversal.solutions.BreadthFirstSearch;
import Q00102_BinaryTreeLevelOrderTraversal.solutions.Solution;
import Q00102_BinaryTreeLevelOrderTraversal.solutions.TreeNode;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(final String[] args) {
        final Map.Entry<TreeNode, List<List<Integer>>> example1 = createTreeExample1();
        final Map.Entry<TreeNode, List<List<Integer>>> example2 = createTreeExample2();

        runTestCase(example1.getKey(), example1.getValue());
        runTestCase(example2.getKey(), example2.getValue());
        runTestCase(null, Collections.emptyList());
    }

    private static Map.Entry<TreeNode, List<List<Integer>>> createTreeExample1() {
        final TreeNode node_15 = new TreeNode(15);
        final TreeNode node_7 = new TreeNode(7);
        final TreeNode node_9 = new TreeNode(9);
        final TreeNode node_20 = new TreeNode(20, node_15, node_7);
        final TreeNode node_3 = new TreeNode(3, node_9, node_20);

        return Map.entry(node_3, List.of(
                List.of(3),
                List.of(9, 20),
                List.of(15, 7)
        ));
    }

    private static Map.Entry<TreeNode, List<List<Integer>>> createTreeExample2() {
        final TreeNode node_1 = new TreeNode(1);
        return Map.entry(node_1, List.of(List.of(1)));
    }

    private static void runTestCase(final TreeNode input, final List<List<Integer>> expectedOutput) {
        final List<Solution> solutionOptions = List.of(
                new BreadthFirstSearch()
        );
        solutionOptions.forEach(solution -> {
            final List<List<Integer>> actualOutput = solution.levelOrder(input);

            final Function<List<List<Integer>>, String> nestedListSerializer =
                    inputList -> inputList.stream()
                            .map(list -> list.stream().map(Object::toString)
                                    .collect(Collectors.joining(",")))
                            .collect(Collectors.joining(","));

            final String serializedExpectedOutput = nestedListSerializer.apply(expectedOutput);
            final String serializedActualOutput = nestedListSerializer.apply(actualOutput);

            System.out.println("------------------------------");
            System.out.println("Solution Type: " + solution.solutionDescription());
            System.out.format("Expected output = [%s]\n", serializedExpectedOutput);
            if (serializedExpectedOutput.equals(serializedActualOutput)) {
                System.out.format("Correct answer!\n");
            } else {
                System.out.format("Wrong answer. Your answer [%s]\n", serializedActualOutput);
            }
        });
    }
}