// 프로그래머스 '카카오프렌즈 컬러링북'
// 2021.02.22
import java.util.*;

class Solution {
    
    private static final int NULL = 0;
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    private int[][] pic;
    private int width, height;
    private boolean[][] visited;
    private int numberOfArea;
    private int maxSizeOfOneArea;

    public int[] solution(int m, int n, int[][] picture) {
        this.pic = picture;
        this.height = m;
        this.width = n;
        this.visited = new boolean[height][width];
        for (boolean[] each : visited) Arrays.fill(each, false);
        bfs();
        return new int[]{this.numberOfArea, this.maxSizeOfOneArea};
    }

    private void bfs() {
        Stack<Point> stack = new Stack<>();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int count = 0;
                if (!visited[y][x] && pic[y][x] != NULL) {
                    visited[y][x] = true;
                    stack.push(new Point(y, x));
                    count++;
                    numberOfArea++;
                }

                while (!stack.isEmpty()) {
                    Point current = stack.pop();
                    for (int i = 0; i < dy.length; i++) {
                        Point next = new Point(current.y + dy[i], current.x + dx[i]);
                        if (next.isPointInBound(width, height) && !visited[next.y][next.x] && pic[next.y][next.x] == pic[current.y][current.x]) {
                            visited[next.y][next.x] = true;
                            stack.push(next);
                            count++;
                        }
                    }
                }
                maxSizeOfOneArea = Math.max(count, maxSizeOfOneArea);
            }
        }
    }
}

class Point {

    int y;
    int x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public boolean isPointInBound(int width, int height) {
        return isXInBound(width) && isYInBound(height);
    }

    private boolean isXInBound(int width) {
        return this.x >= 0 && this.x < width;
    }

    private boolean isYInBound(int height) {
        return this.y >= 0 && this.y < height;
    }
}