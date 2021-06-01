// LeetCode
// 695. Max Area of Island
// 2021.06.01

// BFS
class Solution {
    
    private static final int VALID = 1;
    private static final int INVALID = 0;

    private static final int[] dy = {1, -1, 0, 0};
    private static final int[] dx = {0, 0, 1, -1};
    
    public int maxAreaOfIsland(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int max = 0;
        
        boolean[][] visited = new boolean[m][n];
        
        for (int i=0 ; i<m ; i++) {
            for (int j=0 ; j<n ; j++) {
                if (visited[i][j] || grid[i][j] == INVALID) continue;
                
                int area = 0;
                Queue<Island> queue = new LinkedList<>();
                queue.offer(new Island(i, j));
                visited[i][j] = true;
                while(!queue.isEmpty()) {
                    Island current = queue.poll();
                    area++;
                    
                    int ny, nx;
                    for (int k=0 ; k<4 ; k++) {
                        ny = current.y + dy[k];
                        nx = current.x + dx[k];
                        
                        if ((ny >= 0 && ny < m && nx >= 0 && nx < n)
                            && grid[ny][nx] == VALID && !visited[ny][nx]) {
                            visited[ny][nx] = true;
                            queue.offer(new Island(ny, nx));
                        }
                    }
                }
                max = Math.max(max, area);
            }
        }
        
        return max;
    }
}

class Island {
    int y;
    int x;
    
    public Island(int y, int x) {
        this.y=y;
        this.x=x;
    }
}



// DFS

class Solution {
    
    private static final int VALID = 1;
    private static final int INVALID = 0;
    
    public int maxAreaOfIsland(int[][] grid) {
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int max = 0;
        for (int i=0 ; i<grid.length ; i++)
            for (int j=0 ; j<grid[0].length ; j++)
                if (!visited[i][j] && grid[i][j] == VALID)
                    max = Math.max(max, dfs(i, j, grid, visited));
        return max;
    }
    
    private int dfs(int i, int j, int[][] grid, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j>= grid[0].length) return 0;
        if (grid[i][j] == INVALID || visited[i][j]) return 0;
        
        visited[i][j] = true;
        return dfs(i+1, j, grid, visited) + dfs(i-1, j, grid, visited)
                + dfs(i, j+1, grid, visited) + dfs(i, j-1, grid, visited) + 1;
    }
}