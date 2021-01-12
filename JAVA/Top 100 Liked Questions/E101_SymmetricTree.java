public class E101_SymmetricTree {

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

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }

            return isMirror(root, root);

        }

        private boolean isMirror(TreeNode root, TreeNode root2) {
            if (root == null && root2 == null) {
                return true;
            }
            if (root == null || root2 == null) {
                return false;
            }
            if (root.val == root2.val && isMirror(root.left, root2.right) && isMirror(root.right, root2.left)) {
                return true;
            }
            return false;
        }

    }
}
