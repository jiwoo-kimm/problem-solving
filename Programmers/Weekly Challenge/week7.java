// 프로그래머스 2021 위클리 챌린지
// 7주차 입실 퇴실
// 2021.09.15

class Solution {
    public int[] solution(int[] enter, int[] leave) {
        int n = enter.length;
        
        int[] enterOrder = new int[n];
        int[] leaveOrder = new int[n];
        for (int i=0 ; i<n ; i++) {
            enterOrder[enter[i]-1] = i;
            leaveOrder[leave[i]-1] = i;
        }
        
        int[] answer = new int[n];
        
        for (int i=0 ; i<n-1 ; i++) {
            for (int j=i+1 ; j<n ; j++) {
                if (enterOrder[i] < enterOrder[j] && leaveOrder[i] < leaveOrder[j]) {
                    int laterEnter = enterOrder[j];
                    int earlierLeave = leaveOrder[i];
                    while (++laterEnter < n) {
                        int person = enter[laterEnter];
                        if (leaveOrder[person-1] < earlierLeave) {
                            answer[i]++;
                            answer[j]++;
                            break;
                        }
                    }
                }
                
                if (enterOrder[i] < enterOrder[j] && leaveOrder[i] > leaveOrder[j]) {
                    answer[i]++;
                    answer[j]++;
                }
                
                if (enterOrder[i] > enterOrder[j] && leaveOrder[i] < leaveOrder[j]) {
                    answer[i]++;
                    answer[j]++;
                }
                
                if (enterOrder[i] > enterOrder[j] && leaveOrder[i] > leaveOrder[j]) {
                    int laterEnter = enterOrder[i];
                    int earlierLeave = leaveOrder[j];
                    while (++laterEnter < n) {
                        int person = enter[laterEnter];
                        if (leaveOrder[person-1] < earlierLeave) {
                            answer[i]++;
                            answer[j]++;
                            break;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}