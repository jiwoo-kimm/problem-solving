// 2020 카카오 인턴 : 수식 최대화
// 2021.05.03

import java.util.*;

class Solution {
    
    private static final String MUL = "*";
    private static final String ADD = "+";
    private static final String SUB = "-";
    private static final List<String> operands = new ArrayList<>();

    private long max;

    public long solution(String expression) {
        initOperands();
        Queue<String> queue = parseExpression(expression);
        calcMax(queue);
        return max;
    }

    private void initOperands() {
        operands.add(MUL);
        operands.add(ADD);
        operands.add(SUB);
    }

    private Queue<String> parseExpression(String expression) {
        Queue<String> queue = new LinkedList<>();
        StringBuilder num = new StringBuilder();
        for (char current : expression.toCharArray()) {
            if (current >= '0' && current <= '9')
                num.append(current);
            else {
                queue.offer(num.toString());
                queue.offer(String.valueOf(current));
                num = new StringBuilder();
            }
        }
        queue.offer(num.toString());
        return queue;
    }

    private void calcMax(Queue<String> queue) {
        String[] current = new String[3];
        boolean[] visited = new boolean[3];
        permutation(current, visited, 0, 3, queue);
    }

    private void permutation(String[] current, boolean[] visited, int depth, int target, Queue<String> queue) {
        if (depth == target) {
            Queue<String> tmp = new LinkedList<>(queue);
            long result = calcResult(tmp, current);
            max = Math.max(max, result);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (!visited[i]) {
                visited[i] = true;
                current[depth] = operands.get(i);
                permutation(current, visited, depth + 1, target, queue);
                current[depth] = null;
                visited[i] = false;
            }
        }
    }

    private long calcResult(Queue<String> queue, String[] calcOrder) {
        Queue<String> result = new LinkedList<>();
        Queue<String> tmp = new LinkedList<>(queue);
        for (String targetOperand : calcOrder) {
            String before = "", operand = "", current = "";
            while (!tmp.isEmpty()) {
                current = tmp.poll();

                if (operands.contains(current)) {
                    if (current.equals(targetOperand))
                        operand = current;
                    else {
                        result.offer(before);
                        result.offer(current);
                        before = "";
                    }
                } else if (before.isBlank())
                    before = current;
                else {
                    before = calc(before, operand, current);
                    operand = "";
                }
            }
            result.offer(before);
            tmp.addAll(result);
            result = new LinkedList<>();
        }
        return Math.abs(Long.parseLong(tmp.poll()));
    }

    private String calc(String before, String operand, String current) {
        long left = Long.parseLong(before);
        long right = Long.parseLong(current);
        switch (operand) {
            case MUL:
                return String.valueOf(left * right);
            case ADD:
                return String.valueOf(left + right);
            case SUB:
                return String.valueOf(left - right);
        }
        return null;
    }
}