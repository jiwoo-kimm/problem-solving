// 프로그래머스 '타겟 넘버'
// DFS & BFS
// 2021.01.03, 2021.05.29

class Solution {
    
    public int solution(int[] numbers, int target) {
        return dfs(numbers, 0, 0, target);
    }
    
    private int dfs(int[] numbers, int index, int value, int target) {
        if (index == numbers.length) {
            if (value == target) return 1;
            else return 0;
        }
        
        return dfs(numbers, index+1, value+numbers[index], target) 
            + dfs(numbers, index+1, value-numbers[index], target);
    }
}