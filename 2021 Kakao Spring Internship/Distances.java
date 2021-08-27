// 2021 카카오 채용연계형 인턴십 : 거리두기 확인하기
// 2021.08.27

import java.util.*;

class Solution {
    
    private static final int VALID = 1;
    private static final int INVALID = 0;
    private static final int SIZE = 5;
    private static final char CANDIDATE = 'P';
    private static final char VACANCY = 'O';
    private static final char PARTITION = 'X';
    
    private static final int[] ASIDE_Y = {0, 0, -1, 1};
    private static final int[] ASIDE_X = {-1, 1, 0, 0};
    private static final int[] DIAGONAL_Y = {-1, -1, 1, 1};
    private static final int[] DIAGONAL_X = {-1, 1, -1, 1};
    private static final int[] CARDINAL_Y = {-2, 2, 0, 0};
    private static final int[] CARDINAL_X = {0, 0, -2, 2};
    
    public int[] solution(String[][] places) {
        List<Integer> answer = new ArrayList<>();
        
        for (String[] room : places) {
            if (isValid(room)) {
                answer.add(VALID);
            } else {
                answer.add(INVALID);
            }
        }
        
        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }
    
    private boolean isValid(String[] room) {
        for (int row=0 ; row<SIZE ; row++) {
            for (int col=0 ; col<SIZE ; col++) {
                if (room[row].charAt(col) != CANDIDATE) {
                    continue;
                }
                
                if (isCandidatePresentAside(room, row, col)) {
                    return false;
                }

                if (isNonBlockedDiagonal(room, row, col)) {
                    return false;
                }

                if (isNonBlockCardinal(room, row, col)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isCandidatePresentAside(String[] room, int row, int col) {
        for (int i=0 ; i<ASIDE_Y.length ; i++) {
            int ny = row + ASIDE_Y[i];
            int nx = col + ASIDE_X[i];
            
            if (isOutOfBound(ny, nx)) {
                continue;
            }
            
            if (room[ny].charAt(nx) == CANDIDATE) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isNonBlockedDiagonal(String[] room, int row, int col) {
        for (int i=0 ; i<DIAGONAL_Y.length ; i++) {
            int ny = row + DIAGONAL_Y[i];
            int nx = col + DIAGONAL_X[i];

            if (isOutOfBound(ny, nx) || isNotCandidate(room, ny, nx)) {
                continue;
            }

            if (room[ny].charAt(col) != PARTITION || room[row].charAt(nx) != PARTITION) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isNonBlockCardinal(String[] room, int row, int col) {
        for (int i=0 ; i<CARDINAL_Y.length ; i++) {
            int ny = row + CARDINAL_Y[i];
            int nx = col + CARDINAL_X[i];
            
            if (isOutOfBound(ny, nx) || isNotCandidate(room, ny, nx)) {
                continue;
            }
            
            int midY = (row + ny) / 2;
            int midX = (col + nx) / 2;
            if (room[midY].charAt(midX) != PARTITION) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isOutOfBound(int row, int col) {
        return row < 0 || row >= SIZE || col < 0 || col >= SIZE;
    }
    
    private boolean isNotCandidate(String[] room, int row, int col) {
        return room[row].charAt(col) != CANDIDATE;
    }
}