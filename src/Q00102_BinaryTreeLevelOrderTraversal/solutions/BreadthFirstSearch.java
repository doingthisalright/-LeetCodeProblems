package Q00102_BinaryTreeLevelOrderTraversal.solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch implements Solution {
    public List<List<Integer>> levelOrder(final TreeNode root) {
        final List<List<Integer>> output = new ArrayList<>();

        if (root == null) {
            return output;
        }

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            final int queueLength = queue.size();
            final List<Integer> currentLevel = new ArrayList<>();
            for (int loop = 0; loop < queueLength; loop++) {
                final TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                currentLevel.add(node.val);
            }
            output.add(currentLevel);
        }

        return output;
    }

    public String solutionDescription() {
        return "Breadth First Search";
    }
}
