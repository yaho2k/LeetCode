public class E617_MergeTwoBinaryTrees {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    /*
     * Example 1:
     * 
     * Input: Tree 1 Tree 2 1 2 / \ / \ 3 2 1 3 / \ \ 5 4 7 Output: Merged tree: 3 /
     * \ 4 5 / \ \ 5 4 7
     */

    class Solution {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

            if (t1 == null) {
                return t2;
            }
            if (t2 == null) {
                return t1;
            }
            t1.val += t2.val;
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
            return t1;
        }
    }

}
