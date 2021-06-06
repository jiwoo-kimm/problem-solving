// LeetCode
// 1383. Maximum Performance of a Team
// 2021.06.07

class Solution {
    
    private static final long MOD = (long) 1e9 + 7;
    
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        Worker[] workers = new Worker[n];
        for (int i=0 ; i<n ; i++) workers[i] = new Worker(speed[i], efficiency[i]);
        Arrays.sort(workers, (o1, o2) -> o2.efficiency - o1.efficiency);
                
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long speedSum = 0;
        long maxPerformance = 0;
        
        int i = 0;
        while (i < n) {
            pq.offer(workers[i].speed);
            speedSum += workers[i].speed;
            if (pq.size() > k) speedSum -= pq.poll();
            
            maxPerformance = Math.max(maxPerformance, speedSum * workers[i++].efficiency);
        }
        return (int) (maxPerformance % MOD);
    }
                          
}

class Worker {
    int speed;
    int efficiency;
    
    public Worker(int speed, int efficiency) {
        this.speed = speed;
        this.efficiency = efficiency;
    }
}