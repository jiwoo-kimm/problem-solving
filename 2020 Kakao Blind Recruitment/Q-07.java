// 2020 카카오 블라인드 채용
// 블록 이동하기
// 2021.01.30

import java.util.LinkedList;
import java.util.Queue;

public class Block {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}}));
    }

    private static final int HORIZONTAL = 0;
    private static final int VERTICAL = 1;

    private static int[][] map;
    private static int size;
    private static boolean[][][] visited;
    private static Queue<Robot> queue = new LinkedList<>();
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static int solution(int[][] board) {
        map = board;
        size = board.length;
        visited = new boolean[2][size][size];
        return bfs();
    }

    private static int bfs() {
        int count = 0;
        queue.offer(new Robot(new Point(0, 0), new Point(0, 1), true));
        queue.offer(null);
        visited[HORIZONTAL][0][0] = true;
        visited[HORIZONTAL][0][1] = true;

        while (!queue.isEmpty()) {
            Robot current = queue.poll();

            if (current == null) {
                count++;
                if (!queue.isEmpty()) queue.offer(null);
                continue;
            }

            if ((current.p1.x == size - 1 && current.p1.y == size - 1) || (current.p2.x == size - 1 && current.p2.y == size - 1))
                break;

            checkAdjacent(current);
        }
        return count;
    }

    private static void checkAdjacent(Robot current) {
        if (current.isHorizontal) {
            checkFourDirections(current, HORIZONTAL);
            checkRotations(current, HORIZONTAL);
        } else {
            checkFourDirections(current, VERTICAL);
            checkRotations(current, VERTICAL);
        }
    }

    private static void checkFourDirections(Robot current, int direction) {
        for (int i = 0; i < 4; i++) {
            Robot next;
            if (direction == HORIZONTAL)
                next = new Robot(new Point(current.p1.x + dx[i], current.p1.y + dy[i]), new Point(current.p2.x + dx[i], current.p2.y + dy[i]), true);
            else
                next = new Robot(new Point(current.p1.x + dx[i], current.p1.y + dy[i]), new Point(current.p2.x + dx[i], current.p2.y + dy[i]), false);

            if (isAvailable(next.p1) && isAvailable(next.p2)) {
                if (!visited[direction][next.p1.x][next.p1.y] || !visited[direction][next.p2.x][next.p2.y]) {
                    visited[direction][next.p1.x][next.p1.y] = true;
                    visited[direction][next.p2.x][next.p2.y] = true;
                    queue.offer(next);
                }
            }
        }
    }

    private static void checkRotations(Robot current, int direction) {
        Point np1, np2;
        for (int i = -1; i <= 1; i += 2) {
            if (direction == HORIZONTAL) {
                np1 = new Point(current.p1.x + i, current.p1.y);
                np2 = new Point(current.p2.x + i, current.p2.y);
            } else {
                np1 = new Point(current.p1.x, current.p1.y + i);
                np2 = new Point(current.p2.x, current.p2.y + i);
            }
            checkOneRotation(np1, np2, current, direction);
        }
    }

    private static void checkOneRotation(Point np1, Point np2, Robot current, int direction) {
        if (isAvailable(np1) && isAvailable(np2)) {
            if (isRotatable(np1, current.p1) && !visited[Math.abs(direction - 1)][np1.x][np1.y] || !visited[Math.abs(direction - 1)][current.p1.x][current.p1.y]) {
                visited[Math.abs(direction - 1)][np1.x][np1.y] = true;
                visited[Math.abs(direction - 1)][current.p1.x][current.p1.y] = true;
                if (direction == HORIZONTAL)
                    queue.offer(new Robot(np1, current.p1, false));
                else
                    queue.offer(new Robot(np1, current.p1, true));
            }
            if (isRotatable(np2, current.p2) && !visited[Math.abs(direction - 1)][np2.x][np2.y] || !visited[Math.abs(direction - 1)][current.p2.x][current.p2.y]) {
                visited[Math.abs(direction - 1)][np2.x][np2.y] = true;
                visited[Math.abs(direction - 1)][current.p2.x][current.p2.y] = true;
                if (direction == HORIZONTAL)
                    queue.offer(new Robot(np2, current.p2, false));
                else
                    queue.offer(new Robot(np2, current.p2, true));
            }
        }
    }

    private static boolean isAvailable(Point point) {
        return point.x >= 0 && point.x < size && point.y >= 0 && point.y < size && map[point.x][point.y] == 0;
    }

    private static boolean isRotatable(Point p1, Point p2) {
        return isAvailable(p1) && isAvailable(p2);
    }
}

class Robot {
    Point p1;
    Point p2;
    boolean isHorizontal;

    public Robot(Point p1, Point p2, boolean isHorizontal) {
        this.p1 = p1;
        this.p2 = p2;
        this.isHorizontal = isHorizontal;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}