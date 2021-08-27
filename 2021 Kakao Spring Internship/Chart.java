// 2021 카카오 채용연계형 인턴십 : 표 편집
// 2021.08.27

import java.util.*;

class Solution {
    
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String REMOVE = "C";
    private static final String UNDO = "Z";
    
    private int currentRow;
    private int currentSize;
    private Stack<Integer> removed = new Stack<>();
    
    public String solution(int n, int k, String[] inputs) {
        currentRow = k;
        currentSize = n;
        
        for (String input : inputs) {
            String command = input.substring(0, 1);
            
            switch (command) {
                case UP:
                    up(Integer.parseInt(input.substring(2)));
                    break;
                case DOWN:
                    down(Integer.parseInt(input.substring(2)));
                    break;
                case REMOVE:
                    remove();
                    break;
                case UNDO:
                    undo();
                    break;
            }
        }
        
        return buildAnswer();
    }
    
    private void up(int count) {
        currentRow -= count;
    }
    
    private void down(int count) {
        currentRow += count;
    }
    
    private void remove() {
        removed.push(currentRow);
        currentSize--;
        
        if (currentRow == currentSize) {
            currentRow--;
        }
    }
    
    private void undo() {
        int row = removed.pop();
        currentSize++;
        
        if (row <= currentRow) {
            currentRow++;
        }
    }
    
    private String buildAnswer() {
        StringBuilder sb = new StringBuilder();
        
        for (int i=0 ; i<currentSize ; i++) {
            sb.append("O");
        }
        
        while (!removed.isEmpty()) {
            sb.insert(removed.pop(), "X");
        }
        
        return sb.toString();
    }
}