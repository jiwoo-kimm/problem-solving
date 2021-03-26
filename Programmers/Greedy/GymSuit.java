// 프로그래머스 그리디
// 체육복
// 2021.03.26

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    
    private Set<Integer> losts = new HashSet<>();
    private Set<Integer> reserves = new HashSet<>();

    public int solution(int n, int[] lost, int[] reserve) {
        losts.addAll(Arrays.stream(lost).boxed().collect(Collectors.toList()));
        reserves.addAll(Arrays.stream(reserve).boxed().collect(Collectors.toList()));
        int reserveButLost = countReserveButLost();
        int borrowSuccess = countBorrowSuccess();
        return n - (lost.length - reserveButLost) + borrowSuccess;
    }


    private int countReserveButLost() {
        Set<Integer> reserveButLosts = new HashSet<>();
        for (int reserveStudent : reserves)
            for (int lostStudent : losts)
                if (reserveStudent == lostStudent)
                    reserveButLosts.add(reserveStudent);
        reserves.removeAll(reserveButLosts);
        losts.removeAll(reserveButLosts);
        return reserveButLosts.size();
    }

    private int countBorrowSuccess() {
        int count = 0;
        for (int lostStudent : losts)
            if (reserves.remove(lostStudent - 1) || reserves.remove(lostStudent + 1))
                count++;
        return count;
    }
}