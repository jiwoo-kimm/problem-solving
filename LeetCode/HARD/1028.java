// LeetCode
// 1028. Recover a Tree From Preorder Traversal
// 2021.06.02

class Solution {
    
    private static final char DASH = '-';
    
    public TreeNode recoverFromPreorder(String str) {
        int i=0, depth, num;
        Stack<TreeNode> stack = new Stack<>();
        while (i < str.length()) {
            depth = 0;
            while (i < str.length() && str.charAt(i) == DASH) {
                depth++;
                i++;
            }
            
            num = 0;
            while (i < str.length() && str.charAt(i) != DASH) {
                num = num * 10 + (str.charAt(i) - '0');
                i++;
            }
            
            while (stack.size() > depth) stack.pop();
            
            TreeNode node = new TreeNode(num);
            if (!stack.isEmpty()) {
                if (stack.peek().left == null) stack.peek().left = node;
                else stack.peek().right = node;
            }
            stack.push(node);
        }
        
        while (stack.size() > 1) stack.pop();
        
        return stack.pop();
    }
}