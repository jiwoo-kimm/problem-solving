// 2021 카카오 블라인드 채용 : 카드 짝 맞추기
// 2021.05.12

import java.util.*;

class Solution {
    
    private static final int SIZE = 4;
    private static final int EMPTY = 0;
    private static final int INVALID = -1;
    private static final int[] dr = {0, 0, 1, -1};
    private static final int[] dc = {1, -1, 0, 0};

    private Set<Integer> cardIds = new HashSet<>();
    private Map<Integer, List<Card>> cards = new HashMap<>();
    private List<Card[]> orders = new ArrayList<>();
    private int minCount = Integer.MAX_VALUE;

    public int solution(int[][] board, int r, int c) {
        countCards(board);
        findMinCount(board, r, c);
        return minCount;
    }

    private void countCards(int[][] board) {
        for (int r = 0; r < SIZE; r++)
            for (int c = 0; c < SIZE; c++)
                if (board[r][c] != EMPTY) {
                    cardIds.add(board[r][c]);
                    Card card = new Card(board[r][c], r, c, 0);
                    if (!cards.containsKey(card.id)) cards.put(board[r][c], new ArrayList<>());
                    cards.get(board[r][c]).add(card);
                }
    }

    private void findMinCount(int[][] board, int r, int c) {
        Card[] current = new Card[cardIds.size() * 2];
        boolean[] visited = new boolean[cardIds.size() * 2 + 1];
        findAllPossibleOrders(current, visited, 0);

        for (Card[] order : orders)
            minCount = Math.min(minCount, calcTotalCount(order, new Card(board[r][c], r, c, 0), board));
    }

    private void findAllPossibleOrders(Card[] current, boolean[] visited, int depth) {
        if (depth == cardIds.size() * 2) {
            orders.add(current.clone());
            return;
        }

        for (int card : cardIds) {
            if (!visited[card]) {
                current[depth] = cards.get(card).get(0);
                current[depth + 1] = cards.get(card).get(1);
                visited[card] = true;
                findAllPossibleOrders(current, visited, depth + 2);

                current[depth] = cards.get(card).get(1);
                current[depth + 1] = cards.get(card).get(0);
                findAllPossibleOrders(current, visited, depth + 2);

                visited[card] = false;
                current[depth] = null;
                current[depth + 1] = null;
            }
        }
    }

    private int calcTotalCount(Card[] order, Card start, int[][] origin) {
        int totalCount = 0;
        Card current = start;
        int[][] board = copyBoard(origin);
        for (Card next : order) {
            totalCount += calcCount(current, next, board);
            current = next;
        }
        return totalCount;
    }

    private int[][] copyBoard(int[][] origin) {
        int[][] result = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
            result[i] = Arrays.copyOf(origin[i], SIZE);
        return result;
    }

    private int calcCount(Card start, Card target, int[][] board) {
        boolean[][] visited = new boolean[SIZE][SIZE];
        Queue<Card> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            Card current = queue.poll();
            visited[current.r][current.c] = true;

            if (current.equals(target)) {
                board[target.r][target.c] = EMPTY;
                return current.count + 1;
            }

            checkFourDirections(current, queue, board, visited);
            checkBounds(current, queue, board, visited);
        }
        return INVALID;
    }

    private void checkFourDirections(Card current, Queue<Card> queue, int[][] board, boolean[][] visited) {
        int nr, nc;
        for (int i = 0; i < 4; i++) {
            nr = current.r + dr[i];
            nc = current.c + dc[i];
            if (isInBound(nr, nc) && !visited[nr][nc])
                queue.offer(new Card(board[nr][nc], nr, nc, current.count + 1));
        }
    }

    private void checkBounds(Card current, Queue<Card> queue, int[][] board, boolean[][] visited) {
        checkNorthBound(current, queue, board, visited);
        checkSouthBound(current, queue, board, visited);
        checkWestBound(current, queue, board, visited);
        checkEastBound(current, queue, board, visited);
    }

    private void checkNorthBound(Card current, Queue<Card> queue, int[][] board, boolean[][] visited) {
        int nr = current.r - 1, nc = current.c;
        while (isInBound(nr, nc)) {
            if (board[nr][nc] != EMPTY) break;
            nr--;
        }
        nr = Math.max(nr, 0);
        if (!visited[nr][nc]) queue.offer(new Card(board[nr][nc], nr, nc, current.count + 1));
    }

    private void checkSouthBound(Card current, Queue<Card> queue, int[][] board, boolean[][] visited) {
        int nr = current.r + 1, nc = current.c;
        while (isInBound(nr, nc)) {
            if (board[nr][nc] != EMPTY) break;
            nr++;
        }
        nr = Math.min(nr, SIZE - 1);
        if (!visited[nr][nc]) queue.offer(new Card(board[nr][nc], nr, nc, current.count + 1));
    }

    private void checkWestBound(Card current, Queue<Card> queue, int[][] board, boolean[][] visited) {
        int nr = current.r, nc = current.c - 1;
        while (isInBound(nr, nc)) {
            if (board[nr][nc] != EMPTY) break;
            nc--;
        }
        nc = Math.max(nc, 0);
        if (!visited[nr][nc]) queue.offer(new Card(board[nr][nc], nr, nc, current.count + 1));
    }

    private void checkEastBound(Card current, Queue<Card> queue, int[][] board, boolean[][] visited) {
        int nr = current.r, nc = current.c + 1;
        while (isInBound(nr, nc)) {
            if (board[nr][nc] != EMPTY) break;
            nc++;
        }
        nc = Math.min(nc, SIZE - 1);
        if (!visited[nr][nc]) queue.offer(new Card(board[nr][nc], nr, nc, current.count + 1));
    }

    private boolean isInBound(int nr, int nc) {
        return nr >= 0 && nr < SIZE && nc >= 0 && nc < SIZE;
    }
}

class Card {
    int id;
    int r;
    int c;
    int count;

    public Card(int id, int r, int c, int count) {
        this.id = id;
        this.r = r;
        this.c = c;
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return id == card.id && r == card.r && c == card.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, r, c);
    }
}