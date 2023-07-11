package Q00235_LowestCommonAncestorOfABinarySearchTree;

import Q00235_LowestCommonAncestorOfABinarySearchTree.solutions.Solution;
import Q00235_LowestCommonAncestorOfABinarySearchTree.solutions.TreeNode;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(final String[] args) {
        final Map<Integer, TreeNode> example1TreeNodes = createTreeExample1();
        final Map<Integer, TreeNode> example2TreeNodes = createTreeExample2();

        runTestCase(
                example1TreeNodes.get(6),
                example1TreeNodes.get(2),
                example1TreeNodes.get(8),
                example1TreeNodes.get(6)
        );
        runTestCase(
                example1TreeNodes.get(6),
                example1TreeNodes.get(2),
                example1TreeNodes.get(4),
                example1TreeNodes.get(2)
        );
        runTestCase(
                example2TreeNodes.get(2),
                example1TreeNodes.get(2),
                example2TreeNodes.get(1),
                example2TreeNodes.get(2)
        );
    }

    private static Map<Integer, TreeNode> createTreeExample1() {
        final Map<Integer, TreeNode> treeNodes = new HashMap<>();

        treeNodes.put(3, new TreeNode(3));
        treeNodes.put(5, new TreeNode(5));

        treeNodes.put(0, new TreeNode(0));
        treeNodes.put(4, new TreeNode(4, treeNodes.get(3), treeNodes.get(5)));
        treeNodes.put(7, new TreeNode(7));
        treeNodes.put(9, new TreeNode(9));

        treeNodes.put(2, new TreeNode(2, treeNodes.get(0), treeNodes.get(4)));
        treeNodes.put(8, new TreeNode(8, treeNodes.get(7), treeNodes.get(9)));

        treeNodes.put(6, new TreeNode(6, treeNodes.get(2), treeNodes.get(8)));

        return treeNodes;
    }

    private static Map<Integer, TreeNode> createTreeExample2() {
        final Map<Integer, TreeNode> treeNodes = new HashMap<>();

        treeNodes.put(1, new TreeNode(1));

        treeNodes.put(2, new TreeNode(2, treeNodes.get(1), null));

        return treeNodes;
    }

    private static void runTestCase(
            final TreeNode root,
            final TreeNode p,
            final TreeNode q,
            final TreeNode expectedOutput
    ) {
        final List<Solution> solutionOptions = List.of(
                new Solution()
        );
        solutionOptions.forEach(solution -> {
            final double startTime = Instant.now().getNano();
            final TreeNode actualOutput = solution.lowestCommonAncestor(root, p, q);
            final double endTime = Instant.now().getNano();

            System.out.println("------------------------------");
            System.out.println("Solution Type: " + solution.solutionDescription());
            System.out.format(
                    "Expected output = %s\n",
                    expectedOutput
            );

            if (actualOutput == expectedOutput) {
                System.out.format("Correct answer!\n");
            } else {
                System.out.format("Wrong answer. Your answer %s\n", actualOutput);
            }
            System.out.format("Time Taken: %s ms\n", (endTime - startTime)/1000000);
        });
    }
}