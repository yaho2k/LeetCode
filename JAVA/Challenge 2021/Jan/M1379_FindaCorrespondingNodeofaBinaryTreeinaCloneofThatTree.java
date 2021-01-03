import java.util.LinkedList;
import java.util.Queue;

public class M1379_FindaCorrespondingNodeofaBinaryTreeinaCloneofThatTree {

    /*
     * Example 1: Input: tree = [7,4,3,null,null,6,19], target = 3 Output: 3
     * Explanation: In all examples the original and cloned trees are shown. The
     * target node is a green node from the original tree. The answer is the yellow
     * node from the cloned tree.
     * 
     * Example 2: Input: tree = [7], target = 7 Output: 7
     * 
     * Example 3: Input: tree = [8,null,6,null,5,null,4,null,3,null,2,null,1],
     * target = 4 Output: 4
     * 
     * Example 4: Input: tree = [1,2,3,4,5,6,7,8,9,10], target = 5 Output: 5
     * 
     * Example 5: Input: tree = [1,2,null,3], target = 2 Output: 2
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

        public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

            return BFS(cloned, target);
            // return DFS(cloned, target);
        }

        TreeNode BFS(TreeNode node, TreeNode target) {

            if (node == null) {
                return null;
            }

            if (node.val == target.val) {
                return node;
            }

            Queue<TreeNode> que = new LinkedList<>();
            que.add(node);

            while (!que.isEmpty()) {

                int size = que.size();
                for (int i = 0; i < size; i++) {
                    TreeNode n = que.poll();

                    if (n.val == target.val) {
                        return n;
                    }

                    if (n.left != null) {
                        que.add(n.left);
                    }

                    if (n.right != null) {
                        que.add(n.right);
                    }
                }
            }
            return null;

        }

        TreeNode DFS(TreeNode node, TreeNode target) {

            if (node == null) {
                return null;
            }

            if (node.val == target.val) {
                return node;
            }

            TreeNode left = DFS(node.left, target);
            if (left != null) {
                return left;
            }
            TreeNode right = DFS(node.right, target);
            if (right != null) {
                return right;
            }

            return null;
        }
    }
}
