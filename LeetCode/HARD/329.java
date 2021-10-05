// LeetCode
// 329. Longest Increasing Path in a Matrix
// 2021.10.05

class Solution {    
    
    private static final int[] dy = {1, -1, 0, 0};    
    private static final int[] dx = {0, 0, 1, -1};
    
    private int[][] matrix;
    private int[][] dp;
    private int m;
    private int n;
    
    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        this.m = matrix.length;
        this.n = matrix[0].length;
        this.dp = new int[m][n];
        
        int max = 0;
        for (int y=0 ; y<m ; y++) {
            for (int x=0 ; x<n ; x++) {
                max = Math.max(max, dfs(y, x));
            }
        }
        return max;
    }
    
    private int dfs(int y, int x) {
        if (dp[y][x] != 0) {
            return dp[y][x];
        }
        
        dp[y][x] = 1;
        int ny, nx;
        for (int i=0 ; i<4 ; i++) {
            ny = y + dy[i];
            nx = x + dx[i];
            
            if (isInBound(ny, nx) && matrix[ny][nx] > matrix[y][x]) {
                dp[y][x] = Math.max(dp[y][x], 1 + dfs(ny, nx));
            }
        }
        
        return dp[y][x];
    }
    
    private boolean isInBound(int y, int x) {
        return y >= 0 && y < m && x >= 0 && x < n;
    }
}