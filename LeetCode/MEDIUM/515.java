// LeetCode
// 515. Find Largest Value in Each Tree Row
// 2021.05.19

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) return answer;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int count = queue.size();
            int max = Integer.MIN_VALUE;
            while (count-- > 0) {
                TreeNode current = queue.poll();
                max = Math.max(max, current.val);
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            answer.add(max);
        }
        
        return answer;
    }
}