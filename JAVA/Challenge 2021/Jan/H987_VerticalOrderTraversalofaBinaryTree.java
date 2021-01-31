import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class H987_VerticalOrderTraversalofaBinaryTree {
    /*
     * Example 1: Input: root = [3,9,20,null,null,15,7] Output:
     * [[9],[3,15],[20],[7]] Explanation: Without loss of generality, we can assume
     * the root node is at position (0, 0): The node with value 9 occurs at position
     * (-1, -1). The nodes with values 3 and 15 occur at positions (0, 0) and (0,
     * -2). The node with value 20 occurs at position (1, -1). The node with value 7
     * occurs at position (2, -2).
     * 
     * Example 2: Input: root = [1,2,3,4,5,6,7] Output: [[4],[2],[1,5,6],[3],[7]]
     * Explanation: The node with value 5 and the node with value 6 have the same
     * position according to the given scheme. However, in the report [1,5,6], the
     * node with value 5 comes first since 5 is smaller than 6.
     */

    /*
     * [3,9,20,null,null,15,7]
     * [1,2,3,4,5,6,7]
     * [1]
     * [0,null,1,2,3,null,null,4,5]
     * [0,5,1,9,null,2,null,null,null,null,3,4,8,6,null,null,null,7]
     * [1,2,3,4,5,6,7]
     */

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

        class Node {
            TreeNode node;
            int x;
            int y;

            Node(TreeNode node, int x, int y) {
                this.node = node;
                this.x = x;
                this.y = y;
            }
        }

        HashMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> hashmap = new HashMap<>();
        int minX = 0;
        int maxX = 0;

        public List<List<Integer>> verticalTraversal(TreeNode root) {
            bfs(root);
            List<List<Integer>> result = new ArrayList<>();

            for (int i = minX; i <= maxX; i++) {
                List<Integer> list = new ArrayList<>();
                TreeMap<Integer, PriorityQueue<Integer>> set = hashmap.get(i);
                for (Integer e : set.keySet()) {
                    PriorityQueue<Integer> que = set.get(e);
                    if (que.size() > 0) {
                        while (!que.isEmpty()) {
                            list.add(que.poll());
                        }
                    }
                }
                result.add(list);
            }
            return result;
        }

        private void bfs(TreeNode root) {

            if (root == null) {
                return;
            }

            Queue<Node> que = new LinkedList<>();
            que.add(new Node(root, 0, 0));

            while (!que.isEmpty()) {

                int size = que.size();
                for (int i = 0; i < size; i++) {
                    Node node = que.poll();
                    TreeMap<Integer, PriorityQueue<Integer>> nodehashSet = hashmap.get(node.x);

                    if(nodehashSet == null){
                        nodehashSet = new TreeMap<>();
                    }
                    PriorityQueue<Integer> pri = nodehashSet.get(-node.y);
                    if (pri == null) {
                        pri = new PriorityQueue<>();
                    }
                    pri.add(node.node.val);
                    nodehashSet.put(-node.y, pri);
                    hashmap.put(node.x, nodehashSet);

                    if (node.x > maxX) {
                        maxX = node.x;
                    }
                    if (node.x < minX) {
                        minX = node.x;
                    }
                    if (node.node.left != null) {
                        que.add(new Node(node.node.left, node.x - 1, node.y - 1));
                    }
                    if (node.node.right != null) {
                        que.add(new Node(node.node.right, node.x + 1, node.y - 1));
                    }

                }
            }
        }
    }
}
