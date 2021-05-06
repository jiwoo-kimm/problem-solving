// 2020 카카오 인턴 : 경주로 건설
// 2021.05.07

import java.util.*;

class Solution {

    private static final int VALID = 0;
    private static final int INVALID = 1;
    private static final int LINE = 100;
    private static final int CORNER = 500;
    private static final int MAX = 25;

    private static final int START = -1;
    private static final int[] dy = {0, 0, 1, -1};
    private static final int[] dx = {-1, 1, 0, 0};

    private int n;
    private int minCost = Integer.MAX_VALUE;
    private int[][] dp = new int[MAX][MAX];

    public int solution(int[][] board) {
        n = board.length;
        bfs(board);
        return minCost;
    }

    private void bfs(int[][] board) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(0, 0, 0, START));
        while (!queue.isEmpty()) {
            Position current = queue.poll();

            if (current.y == n - 1 && current.x == n - 1) {
                minCost = Math.min(minCost, current.cost);
                continue;
            }

            int ny, nx, nc;
            for (int direction = 0; direction < 4; direction++) {

                ny = current.y + dy[direction];
                nx = current.x + dx[direction];
                if (outOfBound(ny, nx) || board[ny][nx] == INVALID) continue;

                nc = calcCost(current, direction);
                Position next = new Position(ny, nx, nc, direction);
                
                if (dp[ny][nx] == 0 || dp[ny][nx] >= nc)
                    queue.offer(next);

                if (dp[ny][nx] == 0) dp[ny][nx] = nc;
                else dp[ny][nx] = Math.min(dp[ny][nx], nc);
            }
        }
    }

    private boolean outOfBound(int ny, int nx) {
        return ny < 0 || ny >= n || nx < 0 || nx >= n;
    }

    private int calcCost(Position current, int nextDirection) {
        int cost = current.cost + LINE;
        if (current.direction != START && current.direction != nextDirection) cost += CORNER;
        return cost;
    }
}

class Position {
    int y;
    int x;
    int cost;
    int direction;

    public Position(int y, int x, int cost, int direction) {
        this.y = y;
        this.x = x;
        this.cost = cost;
        this.direction = direction;
    }
}