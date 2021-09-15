// 프로그래머스 2021 위클리 챌린지
// 7주차 입실 퇴실
// 2021.09.15

import java.util.*;

class Solution {
    public int[] solution(int[] enter, int[] leave) {
        int n = enter.length;
        int[] answer = new int[n];
        
        int i = -1;
        int j = 0;
        Set<Integer> room = new HashSet<>();
        while (j < n) {
            if (room.contains(leave[j])) {
                room.remove(leave[j]);
                answer[leave[j] - 1] += room.size();
                for (int person : room) {
                    answer[person - 1]++;
                }
                j++;
            } else {
                while (++i < n) {
                    room.add(enter[i]);
                    if (enter[i] == leave[j]) {
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}