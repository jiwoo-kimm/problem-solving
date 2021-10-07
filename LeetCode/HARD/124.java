// LeetCode
// 124. Binary Tree Maximum Path Sum
// 2021.10.07

class Solution {
    
    private int answer = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        oneSideSum(root);
        return answer;
    }
    
    private int oneSideSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftSum = Math.max(0, oneSideSum(root.left));
        int rightSum = Math.max(0, oneSideSum(root.right));
        answer = Math.max(answer, root.val + leftSum + rightSum);
        return root.val + Math.max(leftSum, rightSum);
    }
}