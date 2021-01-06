// 2019 카카오 겨울 인턴십
// 크레인 인형뽑기
// 2021.01.06

import java.util.ArrayList;
import java.util.Stack;

public class DollGame {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}}, new int[]{1, 5, 3, 5, 1, 2, 1, 4}));
    }

    private static int popCount;
    private static Stack<Integer> picked = new Stack<>();
    private static ArrayList<Stack<Integer>> dollBoard = new ArrayList<>();

    public static int solution(int[][] board, int[] moves) {
        initDollBoard(board);
        playMoves(moves);
        return popCount * 2;
    }

    private static void initDollBoard(int[][] board) {
        for (int i = 0; i < board.length; i++)
            dollBoard.add(new Stack<>());

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board.length; j++) {
                int currentDoll = board[board.length - 1 - j][i];
                if (currentDoll != 0)
                    dollBoard.get(i).push(currentDoll);
            }
    }

    private static void playMoves(int[] moves) {
        for (int move : moves)
            if (!dollBoard.get(move - 1).isEmpty())
                playMove(move);
    }

    private static void playMove(int move) {
        int currentDoll = dollBoard.get(move - 1).pop();
        if (picked.isEmpty()) picked.push(currentDoll);
        else popOrPush(currentDoll);
    }

    private static void popOrPush(int currentDoll) {
        int beforeDoll = picked.peek();
        if (currentDoll == beforeDoll) pop();
        else picked.push(currentDoll);
    }

    private static void pop() {
        picked.pop();
        popCount++;
    }
}
