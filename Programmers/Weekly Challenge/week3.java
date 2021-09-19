// 프로그래머스 2021 위클리 챌린지
// 3주차 퍼즐 조각 채우기
// 2021.09.20

import java.util.*;

class Solution {
    
    private static final int EMPTY = 0;
    private static final int BLOCK = 1;
    
    private static final int[] dy = {1, -1, 0, 0};
    private static final int[] dx = {0, 0, 1, -1};
    
    private int m;
    private int n;
    
    private List<Piece> blanks;
    private List<Piece> pieces;
          
    public int solution(int[][] board, int[][] table) {
        m = board.length;
        n = board[0].length;
       
        blanks = parse(board, EMPTY);
        pieces = parse(table, BLOCK);
                
        return dfs(0, 0, 0, new boolean[pieces.size()]);
    }
    
    private List<Piece> parse(int[][] arr, int target) {
        List<Piece> result = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        for (int i=0 ; i<m ; i++) {
            for (int j=0 ; j<n ; j++) {
                if (arr[i][j] == target && !visited[i][j]) {
                    Set<Position> positions = findPart(i, j, arr, visited, target);
                    result.add(new Piece(positions));
                }
            }
        }
        return result;
    }
    
    private Set<Position> findPart(int i, int j, int[][] arr, boolean[][] visited, int target) {
        Set<Position> positions = new HashSet<>();
        
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(i, j));
        
        while (!queue.isEmpty()) {
            Position p = queue.poll();
            visited[p.y][p.x] = true;
            positions.add(p);
            
            for (int k=0 ; k<4 ; k++) {
                int ny = p.y + dy[k];
                int nx = p.x + dx[k];
                
                if (ny < 0 || ny >= m || nx < 0 || nx >= n) {
                    continue;
                }
                
                if (!visited[ny][nx] && arr[ny][nx] == target) {
                    queue.offer(new Position(ny, nx));                
                }
            }
        }
        
        return positions;
    }
    
    private int dfs(int target, int count, int max, boolean[] used) {        
        if (target == blanks.size()) {
            return Math.max(max, count);
        }
        
        for (int i=0 ; i<pieces.size() ; i++) {
            if (used[i]) {
                continue;
            }

            Piece piece = pieces.get(i);
            Piece targetBlank = blanks.get(target);
            
            if (piece.matches(targetBlank)) {
                used[i] = true;
                return Math.max(max, dfs(target+1, count+pieces.get(i).size(), max, used));
            }
        }

        return Math.max(max, dfs(target+1, count, max, used));
    }
}

class Piece {
    
    Set<Position> positions;
    
    public Piece(Set<Position> positions) {
        int y = Integer.MAX_VALUE;
        int x = Integer.MAX_VALUE;
        for (Position p : positions) {
            y = Math.min(y, p.y);
            x = Math.min(x, p.x);
        }
        
        this.positions = new HashSet<>();
        for (Position p : positions) {
            Position moved = new Position(p.y-y, p.x-x);
            this.positions.add(moved);
        }
    }
    
    public boolean matches(Piece target) {
        if (this.size() != target.size()) {
            return false;
        }
        
        if (this.equals(target)) {
            return true;
        }
        
        Piece rotated = new Piece(this.positions);
        for (int i=1 ; i<=3 ; i++) {
            rotated = rotated.rotate();
            if (rotated.equals(target)) {
                return true;
            }
        }
        
        return false;
    }
    
    private Piece rotate() {
        Set<Position> rotated = new HashSet<>();
        for (Position p : this.positions) {
            int ny = p.x;
            int nx = -p.y;
            rotated.add(new Position(ny, nx));
        }
        return new Piece(rotated);
    }
    
    public int size() {
        return positions.size();
    }
    
    public boolean equals(Object o) {
        if (!(o instanceof Piece)) {
            return false;
        }
        
        Piece p = (Piece) o;
        return this.positions.equals(p.positions);
    }
    
    public int hashCode() {
        return Objects.hash(positions);
    }
}

class Position {
    
    int y;
    int x;
    
    public Position(int y, int x) {
        this.y = y;
        this.x = x;
    }
    
    public boolean equals(Object o) {
        if (!(o instanceof Position)) {
            return false;
        }
        
        Position p = (Position) o;
        return this.y == p.y && this.x == p.x;
    }
    
    public int hashCode() {
        return Objects.hash(y, x);
    }
}