public class E226_InvertBinaryTree {

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
/*     Input:

    4
  /   \
 2     7
/ \   / \
1   3 6   9
Output:

    4
  /   \
 7     2
/ \   / \
9   6 3   1 */


    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if(root == null){
                 return null;
             }
 
             TreeNode head = root;
 
             TreeNode right = invertTree(head.left);
             TreeNode left = invertTree(head.right);
 
             root.right = right;
             root.left = left;
             return root;
     }
    }
}
