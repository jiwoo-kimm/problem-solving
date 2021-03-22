// 2019 카카오 블라인드 채용
// 실패율
// 2021.03.22

import java.util.*;

class Solution {
    
    public int[] solution(int N, int[] users) {
        List<Stage> stages = new ArrayList<>();
        for (int i = 0; i < N; i++) stages.add(new Stage(i + 1, 0, 0));
        for (int position : users) {
            if (position <= N) stages.get(position - 1).userIsOnTheStage();
            for (int i = 1; i <= position && i <= N; i++) stages.get(i - 1).userVisitTheStage();
        }
        for (Stage stage : stages) stage.calcFailureRate();
        stages.sort(Comparator.comparingDouble(o -> o.failureRate * (-1)));
        return getFailureRateRanking(stages);
    }

    private int[] getFailureRateRanking(List<Stage> stages) {
        int[] result = new int[stages.size()];
        for (int i = 0; i < result.length; i++) result[i] = stages.get(i).index;
        return result;
    }
}

class Stage {
    int index;
    int unclearCount;
    int visitCount;
    double failureRate;

    public Stage(int index, int unclearCount, int visitCount) {
        this.index = index;
        this.unclearCount = unclearCount;
        this.visitCount = visitCount;
    }

    public void userIsOnTheStage() {
        this.unclearCount++;
    }

    public void userVisitTheStage() {
        this.visitCount++;
    }

    public void calcFailureRate() {
        if (this.visitCount == 0) this.failureRate = 0;
        else this.failureRate = (double) this.unclearCount / this.visitCount;
    }
}