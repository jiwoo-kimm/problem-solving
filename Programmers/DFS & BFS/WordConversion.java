// 프로그래머스 '단어 변환'
// DFS & BFS
// 2020.01.05

import java.util.Arrays;

public class WordConversion {

    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    }

    private static int answer = Integer.MAX_VALUE;

    public static int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Arrays.fill(visited, false);
        dfs(target, words, visited, begin, 0);
        if (answer == Integer.MAX_VALUE)
            answer = 0;
        return answer;
    }

    private static void dfs(String target, String[] words, boolean[] visited, String current, int count) {
        if (current.equals(target)) {
            if (answer > count)
                answer = count;
            return;
        }

        for (int i = 0; i < words.length; i++)
            if (isConvertible(words[i], current) && !visited[i]) {
                boolean[] newVisited = Arrays.copyOf(visited, visited.length);
                newVisited[i] = true;
                dfs(target, words, newVisited, words[i], count + 1);
            }
    }

    private static boolean isConvertible(String current, String word) {
        int diff = 0;
        for (int i = 0; i < current.length(); i++)
            if (current.charAt(i) != word.charAt(i))
                diff++;
        return diff == 1;
    }
}