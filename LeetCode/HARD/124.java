// LeetCode
// 124. Binary Tree Maximum Path Sum
// 2021.05.27

class Solution {
    
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        oneSideDfs(root);
        return max;
    }
    
    private int oneSideDfs(TreeNode root) {
        if (root == null) return 0;
        
        int left = Math.max(0, oneSideDfs(root.left));
        int right = Math.max(0, oneSideDfs(root.right));
        max = Math.max(max, root.val+left+right);
        
        return root.val + Math.max(left, right);
    }
}