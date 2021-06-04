// LeetCode
// 752. Open the Lock
// 2021.06.05

class Solution {
    
    private static final int COUNT = 10000;
    private static final int UP = 1;
    private static final int DOWN = 9;

    private static final int IMPOSSIBLE = -1;
    private static final String START = "0000";
    
    public int openLock(String[] deadends, String target) {
        boolean[] visited = new boolean[COUNT];
        for (String deadend : deadends) visited[Integer.parseInt(deadend)] = true;
        
        int answer = IMPOSSIBLE;
        Queue<Lock> queue = new LinkedList<>();
        queue.offer(new Lock(0, 0));
        while (!queue.isEmpty()) {
            Lock current = queue.poll();
            if (visited[current.num]) continue;
            
            if (current.num == Integer.parseInt(target)) return current.moveCount;
            
            visited[current.num] = true;           
            for (int i=0 ; i<4 ; i++) {
                int next, unit = (int) Math.pow(10, i);
                
                if (current.num % (unit*10) / unit == 9) next = current.num - DOWN * unit;
                else next = current.num + UP * unit;
                if (!visited[next]) queue.offer(new Lock(next, current.moveCount+1));
                
                if (current.num % (unit*10) / unit == 0) next = current.num + DOWN * unit;
                else next = current.num - UP * unit;
                if (!visited[next]) queue.offer(new Lock(next, current.moveCount+1));
            }
        }        
        return answer;
    }
}

class Lock {
    int num;
    int moveCount;
    
    public Lock(int num, int moveCount) {
        this.num = num;
        this.moveCount = moveCount;
    }
}