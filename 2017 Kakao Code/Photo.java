// 2017 카카오코드 본선 : 단체사진 찍기
// 2021.05.13

import java.util.*;

class Solution { 
    
    private static final int PEOPLE_COUNT = 8;
    private static final char[] PEOPLE = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};

    private List<Condition> conditions = new ArrayList<>();
    private int answer;

    public int solution(int n, String[] data) {
        for (String condition : data) conditions.add(parseCondition(condition));
        countPossiblePermutations();
        return answer;
    }

    private Condition parseCondition(String condition) {
        char suggest = condition.charAt(0);
        char target = condition.charAt(2);
        char op = condition.charAt(3);
        int gap = condition.charAt(4) - '0';
        return new Condition(suggest, target, op, gap);
    }

    private void countPossiblePermutations() {
        boolean[] visited = new boolean[PEOPLE_COUNT];
        char[] current = new char[PEOPLE_COUNT];
        permutation(current, visited, 0);
    }

    private void permutation(char[] current, boolean[] visited, int depth) {
        if (depth == PEOPLE_COUNT) {
            for (Condition condition : conditions)
                if (!isValid(current, condition)) return;
            answer++;
            return;
        }

        for (int i = 0; i < PEOPLE_COUNT; i++) {
            if (!visited[i]) {
                current[depth] = PEOPLE[i];
                visited[i] = true;
                permutation(current, visited, depth + 1);
                visited[i] = false;
                current[depth] = 0;
            }
        }
    }

    private boolean isValid(char[] order, Condition condition) {
        List<Character> target = new ArrayList<>();
        for (char each : order) target.add(each);

        int gap = Math.abs(target.indexOf(condition.suggester) - target.indexOf(condition.target)) - 1;
        return switch (condition.op) {
            case '=' -> gap == condition.gap;
            case '<' -> gap < condition.gap;
            case '>' -> gap > condition.gap;
            default -> false;
        };
    }
}

class Condition {
    char suggester;
    char target;
    char op;
    int gap;

    public Condition(char suggester, char target, char op, int gap) {
        this.suggester = suggester;
        this.target = target;
        this.op = op;
        this.gap = gap;
    }
}