// 프로그래머스 연습문제
// 가장 큰 정사각형 찾기
// 2021.03.19

class Solution {       
    public int solution(int[][] board) {
        int[][] newBoard = extendBoard(board);
        int maxSize = 0;
        for (int i = 1; i < newBoard.length; i++)
            for (int j = 1; j < newBoard[0].length; j++)
                if (newBoard[i][j] != 0) {
                    newBoard[i][j] = Math.min(Math.min(newBoard[i - 1][j], newBoard[i - 1][j - 1]), newBoard[i][j - 1]) + 1;
                    maxSize = Math.max(maxSize, newBoard[i][j]);
                }
        return (int) Math.pow(maxSize, 2);
    }

    private int[][] extendBoard(int[][] board) {
        int[][] newBoard = new int[board.length + 1][board[0].length + 1];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                newBoard[i + 1][j + 1] = board[i][j];
        return newBoard;
    }
}