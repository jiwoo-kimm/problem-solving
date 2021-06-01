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