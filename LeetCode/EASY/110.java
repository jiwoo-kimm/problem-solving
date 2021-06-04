// LeetCode
// 110. Balanced Binary Tree
// 2021.06.04

class Solution {
    
    private boolean result = true;
    
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return result;
    }
    
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        if (!result) return 0;
        
        int left = dfs(node.left);
        int right = dfs(node.right);
        
        if (Math.abs(left - right) > 1) result = false;
        
        return Math.max(left, right) + 1;
    }
}