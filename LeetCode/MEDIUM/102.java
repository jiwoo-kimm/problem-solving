// LeetCode
// 102. Binary Tree Level Order Traversal
// 2021.05.20

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) return answer;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> tmp = new LinkedList<>();
            List<Integer> level = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode current = queue.poll();
                level.add(current.val);
                if (current.left != null) tmp.offer(current.left);
                if (current.right != null) tmp.offer(current.right);
            }
            answer.add(level);
            queue.addAll(tmp);
        }
        return answer;
    }
}