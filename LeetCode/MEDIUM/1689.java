// LeetCode
// 1689. Partitioning Into Minimum Number Of Deci-Binary Numbers
// 2021.05.26

class Solution {
    public int minPartitions(String n) {
        char maxDigit = '0';
        for (char digit : n.toCharArray())
            if (digit > maxDigit) maxDigit = digit;
        return maxDigit - '0';
    }
}