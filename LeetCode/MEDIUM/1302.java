// LeetCode
// 1302. Deepest Leaves Sum
// 2021.05.31

class Solution {
    
    private int maxDepth;
    private int sum;
    
    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return sum;
    }
    
    private void dfs(TreeNode current, int depth) {
        if (current == null) return;
        
        if (depth > maxDepth) {
            sum = current.val;
            maxDepth = depth;
        } else if (depth == maxDepth) {
            sum += current.val;
        }
        
        dfs(current.left, depth+1);
        dfs(current.right, depth+1);
    }
}