// LeetCode
// 97. Interleaving String
// 2021.06.03

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();
        
        boolean[][] isValid = new boolean[c1.length+1][c2.length+1];
        
        isValid[0][0] = true;
        for (int i=1 ; i<=c1.length ; i++) isValid[i][0] = isValid[i-1][0] && c1[i-1] == c3[i-1];
        for (int i=1 ; i<=c2.length ; i++) isValid[0][i] = isValid[0][i-1] && c2[i-1] == c3[i-1];

        for (int i=1 ; i<=c1.length ; i++)
            for (int j=1 ; j<=c2.length ; j++)
                isValid[i][j] = (isValid[i - 1][j] && c1[i - 1] == c3[i + j - 1]) || (isValid[i][j - 1] && c2[j - 1] == c3[i + j - 1]);
        
        return isValid[c1.length][c2.length];
    }
}