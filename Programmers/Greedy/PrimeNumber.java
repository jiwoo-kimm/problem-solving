// 프로그래머스 '소수 찾기'
// 2021.02.24

import java.util.*;

class Solution {
    
    private static final int ASCII_BASE = 48;

    private List<Integer> digits = new ArrayList<>();
    private Set<Integer> primeNumbers = new HashSet<>();

    public int solution(String numbers) {
        extractDigits(numbers);
        makePrimeNumbers();
        return primeNumbers.size();
    }

    private void extractDigits(String numbers) {
        for (char number : numbers.toCharArray()) digits.add(number - ASCII_BASE);
    }

    private void makePrimeNumbers() {
        boolean[] visited = new boolean[digits.size()];
        int[] result = new int[digits.size()];
        dfs(visited, result, 0);
    }

    private void dfs(boolean[] visited, int[] result, int depth) {
        int number = makeNumber(result);
        if (isPrimeNumber(number)) primeNumbers.add(number);

        for (int i = 0; i < digits.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = digits.get(i);
                dfs(visited, result, depth + 1);
                visited[i] = false;
                result[depth] = 0;
            }
        }
    }

    private int makeNumber(int[] result) {
        int number = 0, unit = 1;
        for (int digit : result) {
            number += digit * unit;
            unit *= 10;
        }
        return number;
    }

    private boolean isPrimeNumber(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++)
            if (number % i == 0) return false;
        return true;
    }
}