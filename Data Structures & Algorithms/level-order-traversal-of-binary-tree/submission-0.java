/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // 1. 将当前节点的值加入 level
                level.add(node.val);
                // 2. 左孩子不为空，就加入队列
                if (node.left != null) {
                    queue.offer(node.left);
                }
                // 3. 右孩子不为空，就加入队列
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(level);
            // 当前层处理完成，将 level 加入 res
        }

        return res;
    }
}
