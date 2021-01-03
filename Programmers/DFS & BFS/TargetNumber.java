// 프로그래머스 '타겟 넘버'
// DFS & BFS
// 2020.01.03

public class TargetNumber {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
    }

    private static int count;

    private static int solution(int[] numbers, int target) {

        dfs(numbers, 0, 0, target);
        return count;
    }

    private static void dfs(int[] numbers, int index, int result, int target) {

        if (index == numbers.length) {
            if (result == target) count++;
            return;
        }

        dfs(numbers, index + 1, result + numbers[index], target);
        dfs(numbers, index + 1, result - numbers[index], target);
    }
}