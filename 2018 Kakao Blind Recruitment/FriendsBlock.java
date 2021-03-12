// 2018 카카오 블라인드
// 프렌즈4블록
// 2021.03.12

class Solution {
    
    private static final char NULL = '-';
    private static final int[] dy = {0, 0, 1, 1};
    private static final int[] dx = {0, 1, 0, 1};

    private int y;
    private int x;
    private char[][] board;
    private boolean[][] isPop;

    public int solution(int m, int n, String[] b) {
        initParams(m, n, b);
        return countPopBlocks();
    }
    
    private void initParams(int m, int n, String[] b){
        y = m;
        x = n;
        parseBoard(b);
        isPop = new boolean[y][x];
    }

    private void parseBoard(String[] b) {
        board = new char[y][x];
        for (int i = 0; i < y; i++)
            for (int j = 0; j < x; j++)
                board[i][j] = b[y - i - 1].charAt(j);
    }

    private int countPopBlocks() {
        int count = 0;
        while (isPopAvailable()) {
            count += popAvailableBlocks();
            isPop = new boolean[y][x];
        }
        return count;
    }

    private boolean isPopAvailable() {
        boolean flag = false;
        for (int i = 0; i < y - 1; i++)
            for (int j = 0; j < x - 1; j++)
                if (isSquareSameBlock(i, j)) {
                    checkBlocksToPop(i, j);
                    flag = true;
                }
        return flag;
    }

    private boolean isSquareSameBlock(int i, int j) {
        char now, before = NULL;
        for (int k = 0; k < 4; k++) {
            now = board[i + dy[k]][j + dx[k]];
            if (before != NULL && now != before) return false;
            before = now;
        }
        return before != NULL;
    }

    private void checkBlocksToPop(int i, int j) {
        for (int k = 0; k < 4; k++)
            isPop[i + dy[k]][j + dx[k]] = true;
    }

    private int popAvailableBlocks() {
        int count = 0;
        for (int i = 0; i < y; i++)
            for (int j = 0; j < x; j++)
                if (isPop[i][j]) {
                    board[i][j] = NULL;
                    count++;
                }
        realignBoard();
        return count;
    }

    private void realignBoard() {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (board[i][j] == NULL) {
                    int notNullIndex = findNextNotNullIndex(i, j);
                    if (notNullIndex != i) moveBlocksToBottom(i, notNullIndex, j);
                }
            }
        }
    }

    private void moveBlocksToBottom(int i, int notNullIndex, int j) {
        board[i][j] = board[notNullIndex][j];
        board[notNullIndex][j] = NULL;
    }

    private int findNextNotNullIndex(int i, int j) {
        int notNullIndex = i;
        while (notNullIndex >= 0 && notNullIndex + 1 < y && board[notNullIndex][j] == NULL)
            notNullIndex++;
        return notNullIndex;
    }
}