// LeetCode
// 51. N-Queens
// 2021.05.24

class Solution {
    
    private static final int NULL = -1;
    
    public List<List<String>> solveNQueens(int n) {
        int[] current = new int[n];
        Arrays.fill(current, NULL);
        List<int[]> cases = new ArrayList<>();
        dfs(current, 0, n, cases);
        return parseResult(cases, n);
    }
    
    private void dfs(int[] current, int row, int n, List<int[]> cases) {
        if (row == n) {
            cases.add(Arrays.copyOf(current, n));
            return;
        }
        
        for (int i=0 ; i<n ; i++) {
            if (isPromising(current, row, i)) {
                current[row] = i;
                dfs(current, row+1, n, cases);
                current[row] = NULL;
            }
        }
    }
    
    private boolean isPromising(int[] current, int row, int col) {
        if (row == 0) return true;
        
        for (int i=0 ; i<row ; i++) {
            if (current[i] == col) return false;
            if (row-i == Math.abs(current[i]-col)) return false;
        }
        
        return true;
    }
    
    private List<List<String>> parseResult(List<int[]> target, int n) {
        List<List<String>> result = new ArrayList<>();
        for (int i=0 ; i<target.size() ; i++) {
            List<String> current = new ArrayList<>();
            System.out.println(Arrays.toString(target.get(i)));
            for (int row : target.get(i)) current.add(parseChunk(row, n));
            result.add(current);
        }
        return result;
    }
    
    private String parseChunk(int row, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i<n ; i++) {
            if (i == row) sb.append("Q");
            else sb.append(".");
        }
        return sb.toString();
    }
}