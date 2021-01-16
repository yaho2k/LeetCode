public class E543_DiameterofBinaryTree {

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
     * Example: Given a binary tree 1 / \ 2 3 / \ 4 5 Return 3, which is the length
     * of the path [4,2,1,3] or [5,2,1,3].
     * 
     * Note: The length of path between two nodes is represented by the number of
     * edges between them.
     */
    /* [1,2,3,4,5,null,null,6,null, 8,null,null,10,null,12] */
    /*
     * Input
     * [4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,
     * null,null,-1,-4,null,null,null,-2] Output 7 Expected 8
     */

    class Solution {

        public int diameterOfBinaryTree(TreeNode root) {

            if (root == null) {
                return 0;
            }
            int heightMax = height(root.left) + height(root.right);
            
            int leftMax = diameterOfBinaryTree(root.left);
            int rightMax = diameterOfBinaryTree(root.right);
            int inMax = Math.max(leftMax, rightMax);

            return Math.max(heightMax, inMax);

        }

        int height(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }

    
}
