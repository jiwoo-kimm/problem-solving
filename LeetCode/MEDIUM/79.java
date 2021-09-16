// LeetCode
// 79. Word Search
// 2021.09.16

class Solution {
    
    private static final int[] dy = {1, -1, 0, 0};    
    private static final int[] dx = {0, 0, 1, -1};
    
    private String word;
    private char[][] board;
    private int m;
    private int n;
    
    public boolean exist(char[][] board, String word) {     
        this.word = word;
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        
        for (int i=0 ; i<m ; i++) {
            for (int j=0 ; j<n ; j++) {
                if (board[i][j] == word.charAt(0) && isValid(i, j, 0, new boolean[m][n])) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean isValid(int y, int x, int index, boolean[][] visited) {        
        if (index == word.length()) {
            return true;
        }
        
        if (isOutOfBound(y, x) || visited[y][x] || board[y][x] != word.charAt(index)) {
            return false;
        }
                    
        visited[y][x] = true;
        for (int i=0 ; i<4 ; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (isValid(ny, nx, index+1, visited)) {
                return true;
            }
        }
        visited[y][x] = false;
        
        return false;
    }

    private boolean isOutOfBound(int y, int x) {
        return y < 0 || y >= m || x < 0 || x >= n;
    }
}