// 프로그래머스 월간 코드 챌린지 시즌1
// 두 개 뽑아서 더하기
// 2021.03.29

import java.util.*;

class Solution {
   
    private int n;
    private int[] arr;
    private Set<Integer> result = new HashSet<>();

    public int[] solution(int[] numbers) {
        n = numbers.length;
        arr = numbers;
        combination();
        return result.stream().sorted().mapToInt(Integer::valueOf).toArray();
    }

    private void combination() {
        dfs(new int[2], new boolean[n], 0, 0);
    }

    private void dfs(int[] tmp, boolean[] visited, int start, int depth) {
        if (depth == 2) {
            result.add(Arrays.stream(tmp).sum());
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp[depth] = arr[i];
                dfs(tmp, visited, i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}