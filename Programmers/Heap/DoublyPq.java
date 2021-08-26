// 프로그래머스 '이중우선순위큐'
// Heap
// 2021.08.26

import java.util.*;

class Solution {
    
    private static final String INSERT = "I";
    private static final String DELETE = "D";
    private static final String MAXIMUM = "1";
    private static final String MINIMUM = "-1";
    
    private PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> min = new PriorityQueue<>();
    
    public int[] solution(String[] operations) {
        for (String operation : operations) {
            run(operation);
        }
        
        if (max.isEmpty()) {
            return new int[]{0, 0};
        }
        return new int[]{max.poll(), min.poll()};
    }
    
    private void run(String operation) {
        String[] chunks = operation.split(" ");
        String command = chunks[0];
        String parameter = chunks[1];
        
        switch(command) {
            case INSERT:
                insert(Integer.parseInt(parameter));
                break;
            case DELETE:
                delete(parameter);
                break;
        }
    }
    
    private void insert(int value) {
        max.offer(value);
        min.offer(value);
    }
    
    private void delete(String parameter) {
        switch (parameter) {
            case MAXIMUM:
                deleteMaximum();
                break;
            case MINIMUM:
                deleteMinimum();
                break;
        }
    }
    
    private void deleteMaximum() {
        if (max.isEmpty()) {
            return;
        }
        int value = max.poll();
        min.remove(value);
    }
    
    private void deleteMinimum() {
        if (min.isEmpty()) {
            return;
        }
        int value = min.poll();
        max.remove(value);
    }
}